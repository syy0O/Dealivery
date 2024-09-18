package org.example.backend.domain.orders.controller;

import static org.example.backend.domain.orders.model.dto.OrderDto.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.backend.domain.board.model.dto.BoardDto;
import org.example.backend.domain.board.model.dto.BoardDto.BoardListResponse;
import org.example.backend.domain.orders.service.OrderService;

import org.example.backend.domain.user.model.entity.User;
import org.example.backend.global.common.constants.BaseResponse;
import org.example.backend.global.common.constants.BoardStatus;
import org.example.backend.global.common.constants.SwaggerDescription;
import org.example.backend.global.common.constants.SwaggerExamples;
import org.example.backend.global.security.custom.model.dto.CustomUserDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrdersController {
    private final OrderService orderService;

    @PostMapping("/register")
    @Operation(summary = "주문 등록 API", description = SwaggerDescription.ORDERS_REGISTER_REQUEST,
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = OrderRegisterRequest.class),
                            examples = @ExampleObject(value = SwaggerExamples.ORDERS_REGISTER_REQUEST)
                    )
            )
    )
    public ResponseEntity<BaseResponse> registerOrder(/*@AuthenticationPrincipal CustomUserDetails customUserDetails,*/ @RequestBody OrderRegisterRequest order) {
        //User user = customUserDetails.getUser();
        OrderCreateResponse res = orderService.register(/*user,*/ order);
        return ResponseEntity.ok(new BaseResponse(res));
    }


    @Operation(summary = "주문 내역 조회 API")
    @GetMapping(value = "/history")
    public BaseResponse list(/*@AuthenticationPrincipal CustomUserDetails customUserDetails,*/ Integer page, String status, Integer month) {
        //User user = customUserDetails.getUser();
        Page<OrderListResponse> boardListResponses = orderService.history(/*user,*/ page, status, month);
        return new BaseResponse(boardListResponses);
    }
}
