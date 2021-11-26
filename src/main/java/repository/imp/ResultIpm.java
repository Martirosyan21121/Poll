package repository.imp;

import lombok.RequiredArgsConstructor;
import model.Poll;
import model.Result;
import repository.ResultRepository;

import java.util.List;

@RequiredArgsConstructor
public class ResultIpm {
    private final ResultRepository resultRepository;

    List<Result> findAll() {
        return resultRepository.findAll();
    }
    List<Result> findById(int id){
        return resultRepository.findById(id);
    }

    List<Result> findByPollId(Poll poll){
        return resultRepository.findByPollId(poll.getId());
    }
    List<Result> findByScore(Result result){
        return resultRepository.findByScoreId(result.getMaxScore());
    }
}
