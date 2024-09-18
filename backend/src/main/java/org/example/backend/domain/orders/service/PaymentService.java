package org.example.backend.domain.orders.service;

import static org.example.backend.global.common.constants.BaseResponseStatus.ORDER_PAYMENT_CANCEL_FAILED;
import static org.example.backend.global.common.constants.BaseResponseStatus.ORDER_VALIDATION_FAIL_PRICE_MISMATCH;

import com.google.gson.Gson;
import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.request.CancelData;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.example.backend.domain.orders.model.entity.OrderedProduct;
import org.example.backend.domain.orders.model.entity.Orders;
import org.example.backend.global.exception.InvalidCustomException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final IamportClient iamportClient;

    public Payment getPaymentInfo(String impUid) throws IamportResponseException, IOException {
        IamportResponse<Payment> iamportResponse = iamportClient.paymentByImpUid(impUid);
        return iamportResponse.getResponse();
    }

    public void validatePayment(Payment payment, Orders order) {

        String customData = payment.getCustomData();
        Gson gson = new Gson();
        Map<String, Object> data = gson.fromJson(customData, Map.class);

        Integer usedPoint = (Double.valueOf(data.get("usedPoint").toString())).intValue();
        Integer discountRate = Integer.parseInt(String.valueOf(data.get("discountRate")));
        Integer amount = payment.getAmount().intValue(); // 결제된 금액

        List<OrderedProduct> orderedProducts = order.getOrderedProducts();
        long totalPrice = orderedProducts.stream() // 할인가 적용 합계 계산
                .mapToLong(orderedProduct -> {
                    long originalPrice = orderedProduct.getProduct().getPrice();
                    int quantity = orderedProduct.getQuantity();
                    return Math.round(originalPrice * quantity * (1 - discountRate / 100.0));
                })
                .sum() - usedPoint;

//        TODO: 사용자 보유 포인트보다 많은 포인트 결제했을 때 (포인트 조작 확인)
//        if (usedPoint > 사용자 보유 포인트) {
//            refund(payment.getImpUid(), payment);
//        }

       if (amount != totalPrice) {
           refund(payment.getImpUid(), payment);
           throw new InvalidCustomException(ORDER_VALIDATION_FAIL_PRICE_MISMATCH);
       }
    }

    public IamportResponse refund(String impUid, Payment info)  {
        CancelData cancelData = new CancelData(impUid, true, info.getAmount());
        try {
            return iamportClient.cancelPaymentByImpUid(cancelData);
        } catch (IamportResponseException | IOException e) {
            throw new InvalidCustomException(ORDER_PAYMENT_CANCEL_FAILED);
        }
    }
}
