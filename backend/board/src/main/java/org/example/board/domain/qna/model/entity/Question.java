package org.example.board.domain.qna.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.board.domain.board.model.entity.ProductBoard;
import org.example.board.domain.qna.model.dto.AnswerDto;
import org.example.board.domain.qna.model.dto.QuestionDto;
import org.example.board.domain.user.model.entity.User;
import org.example.board.global.common.constants.AnswerStatus;
import org.hibernate.annotations.BatchSize;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    private String title;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_idx")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_board_idx")
    private ProductBoard productBoard;

    @BatchSize(size = 5)  // 한 번에 가져올 배치 크기 설정
    @OneToMany(mappedBy = "question")
    private List<Answer> answers = new ArrayList<>();

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @Column(insertable = false)
    private LocalDateTime modifiedAt;

    @Column(name = "answer_status")
    private String answerStatus = AnswerStatus.ANSWER_WAITING.getStatus();

    // DTO 변환 메서드: 문의 생성 후 응답
    public QuestionDto.QuestionCreateResponse toCreateResponse() {
        return QuestionDto.QuestionCreateResponse.builder()
                .idx(this.idx)
                .title(this.title)
                .content(this.content)
                .userName(this.user.getName())
                .answerStatus(this.answerStatus)
                .createdAt(this.createdAt)
                .build();
    }

    // DTO 변환 메서드: 문의 목록 조회
    public static QuestionDto.QuestionListResponse toListResponse(Question q) {
        List<AnswerDto.AnswerResponse> answerResponses = q.answers.stream()
                .map(answer -> answer.toResponse())
                .collect(Collectors.toList());

        return QuestionDto.QuestionListResponse.builder()
                .idx(q.idx)
                .title(q.title)
                .content(q.content)
                .userName(q.user.getName())
                .answerStatus(q.answerStatus)
                .createdAt(q.createdAt)
                .email(q.user.getEmail())
                .answers(answerResponses)  // 답변 리스트 포함
                .productBoardIdx(q.getProductBoard().getIdx())
                .productTitle(q.getProductBoard().getTitle())

                .build();
    }

    // 답변이 등록 되면 문의 상태를 "답변완료"로 변경하는 메서드
    public void markAsAnswered(){
        this.answerStatus = AnswerStatus.ANSWER_COMPLETED.getStatus();
    }

    // 답변 상태를 "답변 대기"로 변경하는 메서드
    public void markAsWaiting() {
        this.answerStatus = AnswerStatus.ANSWER_WAITING.getStatus();
    }

    // 문의 제목과 내용을 수정하는 메서드
    public void updateContent(String newTitle, String newContent) {
        this.title = newTitle;
        this.content = newContent;
        this.modifiedAt = LocalDateTime.now();  // 수정 시간을 현재 시간으로 업데이트
    }
}
