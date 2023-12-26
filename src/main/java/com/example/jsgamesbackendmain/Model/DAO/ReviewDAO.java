package com.example.jsgamesbackendmain.Model.DAO;

import com.example.jsgamesbackendmain.Model.DTO.Review.Request.ReviewUpdateRequestDTO;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.time.LocalDateTime;

@Entity
@Table(name = "reviews")
@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReviewDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    private String userId;
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
        String s = String.valueOf(i);
        ReviewDAO dao = new ReviewDAO();
        dao.setUserId(""+ i);
        dao.setGameId((long) i);
        dao.setReviewContent(s);
        dao.setStar((float) i % 5 + 1);
        dao.setHelpful((long) i);
        return dao;
    }
}
