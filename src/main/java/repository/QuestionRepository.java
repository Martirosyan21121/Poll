package repository;

import model.Question;

import java.util.List;

public interface QuestionRepository {
    List<Question> findAll();

    List<Question> findById(int id);
    List<Question> findByPollId(int id);
}
