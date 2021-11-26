package repository;

import model.Poll;

import java.util.List;

public interface PollRepository {

    List<Poll> findAll();

    List<Poll> findById(int id);
}
