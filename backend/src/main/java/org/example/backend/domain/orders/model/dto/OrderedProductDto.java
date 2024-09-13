package org.example.backend.domain.orders.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.backend.domain.board.product.model.entity.Product;
import org.example.backend.domain.orders.model.entity.OrderedProduct;
import org.example.backend.domain.orders.model.entity.Orders;

public class OrderedProductDto {
    @Builder
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Request {
        private Long idx;
        private Integer quantity;
        public static OrderedProduct toEntity(Request request, Orders order) {

            Product product = Product.builder().idx(request.getIdx()).build();

            return OrderedProduct.builder()
                    .product(product)
                    .quantity(request.quantity)
                    .orders(order)
                    .build();
        }
    }
}
