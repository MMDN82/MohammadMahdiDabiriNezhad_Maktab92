package repository;

import Base.repository.BaseRepository;
import entity.Coach;

public interface CoachRepository extends BaseRepository<Coach,Long> {
    Coach maxPrice();
}
