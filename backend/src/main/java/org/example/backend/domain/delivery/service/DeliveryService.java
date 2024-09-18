package org.example.backend.domain.delivery.service;

import lombok.RequiredArgsConstructor;
import org.example.backend.domain.delivery.model.dto.DeliveryDto;
import org.example.backend.domain.delivery.model.entity.Delivery;
import org.example.backend.domain.delivery.repository.DeliveryRepository;
import org.example.backend.global.common.constants.BaseResponseStatus;
import org.example.backend.global.exception.InvalidCustomException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DeliveryService {
    private final DeliveryRepository deliveryRepository;


    public List<DeliveryDto.DeliveryResponse> getList(Long idx) {
        List<Delivery> deliveries = deliveryRepository.findAllByUserIdx(idx).orElseThrow(
                () -> new InvalidCustomException(BaseResponseStatus.USER_DELIVERY_LIST_FAIL)
        );

        return deliveries.stream().map(Delivery::toDeliveryResponse).toList();
    }
}
