package model;

import lombok.Builder;

import java.util.Objects;
@Builder
public class Result {

    private int id;
    private String explanation;
    private int MinScore;
    private int MaxScore;
    private Poll pollId;

    public Result() {
    }

    public Result(int id, String explanation, int minScore, int maxScore, Poll pollId) {
        this.id = id;
        this.explanation = explanation;
        MinScore = minScore;
        MaxScore = maxScore;
        this.pollId = pollId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public int getMinScore() {
        return MinScore;
    }

    public void setMinScore(int minScore) {
        MinScore = minScore;
    }

    public int getMaxScore() {
        return MaxScore;
    }

    public void setMaxScore(int maxScore) {
        MaxScore = maxScore;
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
        Result result = (Result) o;
        return id == result.id && MinScore == result.MinScore && MaxScore == result.MaxScore && Objects.equals(explanation, result.explanation) && Objects.equals(pollId, result.pollId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, explanation, MinScore, MaxScore, pollId);
    }

    @Override
    public String toString() {
        return "Result{" +
                "id=" + id +
                ", explanation='" + explanation + '\'' +
                ", MinScore=" + MinScore +
                ", MaxScore=" + MaxScore +
                ", pollId=" + pollId +
                '}';
    }
}
