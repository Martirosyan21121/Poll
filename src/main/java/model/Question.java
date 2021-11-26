package model;

import lombok.Builder;

import java.util.Objects;
@Builder
public class Question {
    private int id;
    private String text;
    private Poll pollId;

    public Question() {
    }

    public Question(int id, String text, Poll pollId) {
        this.id = id;
        this.text = text;
        this.pollId = pollId;
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

    public Poll getPollId() {
        return pollId;
    }

    public void setPollId(Poll pollId) {
        this.pollId = pollId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return id == question.id && Objects.equals(text, question.text) && Objects.equals(pollId, question.pollId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, pollId);
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", pollId=" + pollId +
                '}';
    }
}
