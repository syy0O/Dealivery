package org.example.backend.domain.orders.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import org.example.backend.domain.orders.model.dto.OrderDto.OrderCompleteRequest;
import org.example.backend.domain.board.model.entity.ProductBoard;
import org.example.backend.domain.orders.model.dto.OrderDto.CompanyOrderDetailResponse;
import org.example.backend.domain.orders.model.dto.OrderDto.CompanyOrderListResponse;
import org.example.backend.domain.orders.model.dto.OrderDto.UserOrderDetailResponse;
import org.example.backend.domain.orders.model.dto.OrderDto.UserOrderListResponse;
import org.example.backend.domain.orders.model.dto.OrderedProductDto.OrderedProductResponse;
import org.example.backend.domain.user.model.entity.User;
import org.example.backend.global.common.constants.OrderStatus;
import org.example.backend.global.common.constants.PaymentType;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EntityListeners(AuditingEntityListener.class)
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    private Long boardIdx;

    private String ordersNumber; // 주문 번호

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime modifiedAt;

    private String receiverName;
    private String receiverPhoneNumber;

    private String address;
    private String addressDetail;
    private String postNumber;


    private String paymentId;
    @Enumerated(EnumType.STRING)
    private PaymentType payMethod;
  
    private Long usedPoint;


    private Long totalPaidAmount;

    private Long originalPaidAmount;

    @ManyToOne
    @JoinColumn(name = "user_idx")
    private User user;

    @OneToMany(mappedBy = "orders", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<OrderedProduct> orderedProducts;


    public void update(OrderCompleteRequest dto) {
        this.paymentId = dto.getPaymentId();
        this.totalPaidAmount = dto.getTotalPaidAmount();
        this.originalPaidAmount = dto.getOriginalPaidAmount();
        this.payMethod = dto.getPayMethod();
        this.usedPoint = dto.getUsedPoint();
        this.receiverName = dto.getReceiverName();
        this.receiverPhoneNumber = dto.getReceiverPhoneNumber();
        this.modifiedAt = LocalDateTime.now();
        this.address = dto.getAddress();
        this.addressDetail = dto.getAddressDetail();
        this.postNumber = dto.getPostNumber();
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }


    public static CompanyOrderListResponse toCompanyOrderListResponse(Orders order, String title) {
        return CompanyOrderListResponse.builder()
                .orderIdx(order.idx)
                .ordersNumber(order.ordersNumber)
                .title(title)
                .ordererName(order.user.getName())
                .status(order.status.getStatus())
                .totalPaidAmount(order.totalPaidAmount)
                .payMethod(order.payMethod.getType())
                .modifiedAt(order.modifiedAt)
                .build();
    }

    public static CompanyOrderDetailResponse toCompanyOrderDetailResponse(Long orderIdx, List<OrderedProductResponse> products) {
        return CompanyOrderDetailResponse.builder()
                .orderIdx(orderIdx)
                .products(products)
                .build();
    }

    public static UserOrderListResponse toUserOrderListResponse(Orders order, ProductBoard board) {
        return UserOrderListResponse.builder()
                .orderIdx(order.idx)
                .ordersNumber(order.ordersNumber)
                .title(board.getTitle())
                .thumnailUrl(board.getProductThumbnailUrl())
                .minimumPrice(board.getMinimumPrice())
                .discountRate(board.getDiscountRate())
                .status(order.status.getStatus())
                .createdAt(order.createdAt)
                .build();
    }

    public static UserOrderDetailResponse toUserOrderDetailResponse(Orders order, ProductBoard board) {
        return UserOrderDetailResponse.builder()
                .ordersNumber(order.ordersNumber)
                .status(order.status.getStatus())
                .createdAt(order.createdAt)
                .payMethod(order.payMethod.getType())
                .usedPoint(order.usedPoint)
                .totalPaidAmount(order.totalPaidAmount)
                .originalPaidAmount(order.originalPaidAmount)
                .receiverName(order.receiverName)
                .receiverPhoneNumber(order.receiverPhoneNumber)
                .address(order.getAddress())
                .build();
    }
}
