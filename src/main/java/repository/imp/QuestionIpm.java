package repository.imp;

import lombok.RequiredArgsConstructor;
import model.Poll;
import model.Question;
import repository.QuestionRepository;

import java.util.List;

@RequiredArgsConstructor
public class QuestionIpm {
    private final QuestionRepository questionRepository;

    public List<Question> findAll() {
        return questionRepository.findAll();

    }

    public List<Question> findById(int id) {
        return questionRepository.findById(id);

    }

    public List<Question> findByPollId(Poll poll) {
        return questionRepository.findById(poll.getId());

    }
}
