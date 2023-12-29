package com.example.jsgamesbackendmain.Model.DAO;

import com.example.jsgamesbackendmain.Model.DTO.Review.Request.ReviewUpdateRequestDTO;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserDAO user;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id")
    private GameDAO game;

    private String reviewContent;

    // 별점
    @Max(5)
    private Float star;

    // helpful
    @Builder.Default
    private Long helpful = 0L;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime dateTime;

    @Builder.Default
    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL)
    private List<HelpfulDAO> helpfuls = new ArrayList<>();

    public void setUser(UserDAO user) {
        this.user = user;

        List<ReviewDAO> reviews = user.getReviews();

        if (!reviews.contains(this))
            reviews.add(this);
    }

    public void setGame(GameDAO game) {
        this.game = game;

        List<ReviewDAO> reviews = game.getReviews();

        if (!reviews.contains(this))
            reviews.add(this);
    }

    public void update(ReviewUpdateRequestDTO request) {
        this.reviewContent = request.getReviewContent();
    }

    public static ReviewDAO createTest(int i, GameDAO game, UserDAO user) {
        ReviewDAO newReview = ReviewDAO.builder()
                .reviewContent(String.valueOf(i))
                .star((float) i % 5 + 1)
                .helpful((long) i)
                .build();

        newReview.setUser(user);
        newReview.setGame(game);

        return newReview;
    }
}
