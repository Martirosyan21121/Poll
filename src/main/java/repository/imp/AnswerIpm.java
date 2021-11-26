package repository.imp;

import lombok.RequiredArgsConstructor;
import model.Answer;
import model.Question;
import repository.AnswerRepository;

import java.util.List;

@RequiredArgsConstructor
public class AnswerIpm {
    private final AnswerRepository answerRepository;

    public List<Answer> findAll() {
        return answerRepository.findAll();

    }

    public List<Answer> findById(int id) {
        return answerRepository.findById(id);

    }
    public List<Answer> findByQuestionId(Question question) {
        return answerRepository.findById(question.getId());

    }

}
