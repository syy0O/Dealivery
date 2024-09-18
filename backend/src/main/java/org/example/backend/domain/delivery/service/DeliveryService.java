package org.example.backend.domain.delivery.service;

import lombok.RequiredArgsConstructor;
import org.example.backend.domain.delivery.repository.DeliveryRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeliveryService {
    private final DeliveryRepository deliveryRepository;


}
