// src/services/model/Question.java
package services.model;

public class Question {
    private Long id;
    private Long surveyId;   // ensure this field exists
    private String text;

    public Question() { }

    public Question(Long id, Long surveyId, String text) {
        this.id = id;
        this.surveyId = surveyId;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(Long surveyId) {
        this.surveyId = surveyId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Question{" +
               "id=" + id +
               ", surveyId=" + surveyId +
               ", text='" + text + '\'' +
               '}';
    }
}
