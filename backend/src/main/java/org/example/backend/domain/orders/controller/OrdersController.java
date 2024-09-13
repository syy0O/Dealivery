package org.example.backend.domain.orders.controller;

import static org.example.backend.domain.orders.model.dto.OrderDto.*;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.backend.domain.orders.service.OrderService;

import org.example.backend.global.common.constants.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrdersController {
    private final OrderService orderService;

    @PostMapping("/register")
    @Operation(summary = "주문 등록 API", description = "주문을 등록하는 API입니다.")
    public ResponseEntity<BaseResponse> registerOrder(/*@AuthenticationPrincipal CustomUserDetails customUserDetails,*/ @RequestBody OrderRegisterRequest order) {
        OrderCreateResponse res = orderService.register(order);
        return ResponseEntity.ok(new BaseResponse(res));
    }
}
