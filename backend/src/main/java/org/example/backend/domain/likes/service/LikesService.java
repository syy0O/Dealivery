package org.example.backend.domain.likes.service;

import lombok.RequiredArgsConstructor;
import org.example.backend.domain.board.model.entity.ProductBoard;
import org.example.backend.domain.board.repository.ProductBoardRepository;
import org.example.backend.domain.likes.model.dto.LikesDto;
import org.example.backend.domain.likes.model.entity.Likes;
import org.example.backend.domain.likes.repository.LikesRepository;
import org.example.backend.domain.user.model.entity.User;
import org.example.backend.domain.user.repository.UserRepository;
import org.example.backend.global.common.constants.BaseResponseStatus;
import org.example.backend.global.exception.InvalidCustomException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LikesService {
    private final LikesRepository likesRepository;
    private final UserRepository userRepository;
    private final ProductBoardRepository productBoardRepository;

    @Transactional
    public void like(LikesDto.LikeRequest request, Long userIdx) {
        //존재하는 회원인지 체크
        User user = userRepository.findByIdx(userIdx).orElseThrow(
                () -> new InvalidCustomException(BaseResponseStatus.LIKES_REGISTER_FAIL));
        //존재하는 게시글인지 체크
        ProductBoard productBoard = productBoardRepository.findByIdx(request.getProductBoardIdx()).orElseThrow(
                () -> new InvalidCustomException(BaseResponseStatus.LIKES_REGISTER_FAIL_NO_MATCH_PRODUCT_BOARD));
        //좋아요 내역이 있는지 확인
        Optional<Likes> optionalLikes = likesRepository.findByProductBoardIdxAndUserIdx(request.getProductBoardIdx(),userIdx);
        //이미 존재하면 삭제
        if (optionalLikes.isPresent()){
            Likes existingLikes = optionalLikes.get();
            likesRepository.delete(existingLikes);
        //없으면 생성
        }else {
            likesRepository.save(request.toEntity(productBoard, user));
        }

    }
}
