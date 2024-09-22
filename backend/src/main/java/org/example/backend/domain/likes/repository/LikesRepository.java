package org.example.backend.domain.likes.repository;

import org.example.backend.domain.likes.model.entity.Likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LikesRepository extends JpaRepository<Likes, Long> {
    Optional<Likes> findByProductBoardIdxAndUserIdx(Long productBoardIdx, Long userIdx);
}
