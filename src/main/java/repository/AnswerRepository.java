package repository;

import model.Answer;

import java.util.List;
import java.util.Objects;

public interface AnswerRepository {

  List<Answer> findAll();

  List<Answer> findById(int id);
  List<Answer> findByQuestionId(int id);
}
