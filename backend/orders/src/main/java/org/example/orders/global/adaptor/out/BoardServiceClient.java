package org.example.orders.global.adaptor.out;

import org.example.orders.domain.product.model.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "board-service", url = "http://localhost:8000/api",contextId = "boardServiceClientForOrders")
@Component
public interface BoardServiceClient {

    @PostMapping("/product-boards/decrease/stock")
    Boolean isStockDecreased(
            @RequestBody List<ProductDto.OrderedProductInfo> orderedProductInfoList
    );

    @PostMapping("/product-boards/restore/stock")
    Boolean isStockRestored(
            @RequestBody List<ProductDto.OrderedProductInfo> orderedProductInfoList
    );
}
