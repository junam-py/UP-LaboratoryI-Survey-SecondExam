// src/services/model/Answer.java
package services.model;

import java.util.Date;

public class Answer {
    private Long id;
    private Long questionId;
    private Long userId;    // renamed from promoterId to userId
    private int rating;     // 1–5
    private Date answeredAt;

    public Answer() { }

    public Answer(Long id, Long questionId, Long userId, int rating, Date answeredAt) {
        this.id = id;
        this.questionId = questionId;
        this.userId = userId;
        this.rating = rating;
        this.answeredAt = answeredAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Date getAnsweredAt() {
        return answeredAt;
    }

    public void setAnsweredAt(Date answeredAt) {
        this.answeredAt = answeredAt;
    }

    @Override
    public String toString() {
        return "Answer{" +
               "id=" + id +
               ", questionId=" + questionId +
               ", userId=" + userId +
               ", rating=" + rating +
               ", answeredAt=" + answeredAt +
               '}';
    }
}
