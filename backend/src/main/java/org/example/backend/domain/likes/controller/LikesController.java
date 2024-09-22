package org.example.backend.domain.likes.controller;

import lombok.RequiredArgsConstructor;
import org.example.backend.domain.likes.model.dto.LikesDto;
import org.example.backend.domain.likes.service.LikesService;
import org.example.backend.global.common.constants.BaseResponse;
import org.example.backend.global.security.custom.model.dto.CustomUserDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/likes")
@RequiredArgsConstructor
public class LikesController {
    private final LikesService likesService;

    @PostMapping("")
    public BaseResponse like(
            @RequestBody LikesDto.LikeRequest request,
            @AuthenticationPrincipal CustomUserDetails userDetails
            ){
        likesService.like(request, userDetails.getIdx());
        return new BaseResponse();
    }
}
