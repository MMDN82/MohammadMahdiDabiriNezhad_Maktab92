package repository;

import Base.repository.BaseRepository;
import entity.Team;

import java.util.HashMap;

public interface TeamRepository extends BaseRepository<Team,Long> {
    Integer teamScore(Long id);
}
