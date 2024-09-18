package org.example.backend.domain.user.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class DeliveryDto {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class DeliveryResponse{
        private Long idx;

        private String name;

        private Boolean isDefault;

        private String address;

        private String addressDetail;

        private String postNumber;

    }
}
