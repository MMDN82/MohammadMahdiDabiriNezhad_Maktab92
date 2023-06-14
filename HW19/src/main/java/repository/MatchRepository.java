package repository;

import Base.repository.BaseRepository;
import entity.Match;

public interface MatchRepository extends BaseRepository<Match,Long> {
    String TheMostSuccessfulDerby();
}
