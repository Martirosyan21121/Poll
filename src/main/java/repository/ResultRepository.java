package repository;

import model.Question;
import model.Result;

import java.util.List;
import java.util.Objects;

public interface ResultRepository {
    List<Result> findAll();

    List<Result> findById(int id);
    List<Result> findByPollId(int id);
    List<Result> findByScoreId(int score);

}
