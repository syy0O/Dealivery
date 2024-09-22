package org.example.backend.domain.likes.service;

import lombok.RequiredArgsConstructor;
import org.example.backend.domain.likes.repository.LikesRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikesService {
    private final LikesRepository likesRepository;
}
