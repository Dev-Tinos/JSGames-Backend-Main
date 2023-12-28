package com.example.jsgamesbackendmain.Model.DAO;

import com.example.jsgamesbackendmain.Model.DTO.Review.Request.ReviewUpdateRequestDTO;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.time.LocalDateTime;

@Entity
@Table(name = "reviews")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReviewDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @Setter
    private String userId;
    @Setter
    private Long gameId;
    private String reviewContent;

    // 별점
    @Max(5)
    private Float star;

    // helpful
    private Long helpful = 0L;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime dateTime;

    public void update(ReviewUpdateRequestDTO request) {
        this.reviewContent = request.getReviewContent();
    }

    public static ReviewDAO createTest(int i){
        return ReviewDAO.builder()
                .userId("" + i)
                .gameId((long) i)
                .reviewContent(String.valueOf(i))
                .star((float) i % 5 + 1)
                .helpful((long) i)
                .build();
    }
}
