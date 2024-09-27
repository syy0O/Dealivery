package org.example.backend.domain.likes.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.backend.domain.board.model.entity.ProductBoard;
import org.example.backend.domain.board.product.model.entity.Product;
import org.example.backend.domain.likes.model.entity.Likes;
import org.example.backend.domain.user.model.entity.User;

public class LikesDto {
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LikeRequest{
        @NotNull
        private Long productBoardIdx;

        public Likes toEntity(ProductBoard productBoard, User user){
            return Likes.builder()
                    .productBoard(productBoard)
                    .user(user)
                    .build();
        }
    }
}
