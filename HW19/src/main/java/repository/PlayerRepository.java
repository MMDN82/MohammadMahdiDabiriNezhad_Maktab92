package repository;

import Base.repository.BaseRepository;
import entity.Player;

import java.util.List;

public interface PlayerRepository extends BaseRepository<Player,Long> {
    List<Player> theMostExpensivePlayers();
}
