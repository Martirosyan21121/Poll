package repository.imp;

import lombok.RequiredArgsConstructor;
import model.Poll;
import repository.PollRepository;

import java.util.List;

@RequiredArgsConstructor
public class PollIpm {
    private final PollRepository pollRepository;

    public List<Poll> findAll() {
        return pollRepository.findAll();

    }

    public List<Poll> findById(int id) {
        return pollRepository.findById(id);

    }


}
