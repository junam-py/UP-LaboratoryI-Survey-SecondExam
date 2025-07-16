package services.model;

import java.sql.Timestamp;
import java.util.List;

/**
 * Modelo de Survey con fecha de creación y lista de preguntas.
 */
public class Survey {
    private Long id;
    private String title;
    private String description;
    private Timestamp createdAt;
    private List<Question> questions;

    public Survey() { }

    /**
     * Constructor usado en SurveyDAOH2.findById().
     *
     * @param id          identificador
     * @param title       título de la encuesta
     * @param description descripción de la encuesta
     * @param createdAt   fecha de creación
     * @param questions   lista de preguntas asociadas (o null)
     */
    public Survey(Long id, String title, String description, Timestamp createdAt, List<Question> questions) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
        this.questions = questions;
    }

    /**
     * Constructor para creación/edición en el panel de registro (sin fecha ni preguntas).
     *
     * @param id          identificador (puede ser null para nuevo)
     * @param title       título de la encuesta
     * @param description descripción de la encuesta
     */
    public Survey(Long id, String title, String description) {
        this(id, title, description, null, null);
    }

    // Getters y setters...

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
