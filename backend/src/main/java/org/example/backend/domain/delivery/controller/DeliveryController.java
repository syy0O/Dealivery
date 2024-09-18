package org.example.backend.domain.delivery.controller;

import lombok.RequiredArgsConstructor;
import org.example.backend.domain.delivery.service.DeliveryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/delivery")
@RequiredArgsConstructor
public class DeliveryController {
    private final DeliveryService deliveryService;

}
