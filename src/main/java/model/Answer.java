package model;

import lombok.Builder;

import java.util.Objects;
@Builder
public class Answer {

    private int id;
    private String text;
    private int weight;
    private Question questionId;

    public Answer(int id) {
        this.id = id;
    }

    public Answer(int id, String text, int weight, Question questionId) {
        this.id = id;
        this.text = text;
        this.weight = weight;
        this.questionId = questionId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Question getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Question questionId) {
        this.questionId = questionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer answer = (Answer) o;
        return id == answer.id && weight == answer.weight && Objects.equals(text, answer.text) && Objects.equals(questionId, answer.questionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, weight, questionId);
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", weight=" + weight +
                ", questionId=" + questionId +
                '}';
    }
}
