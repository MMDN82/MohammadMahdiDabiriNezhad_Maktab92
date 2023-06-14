package repository;

import Base.repository.BaseRepository;
import entity.City;

import java.util.HashMap;

public interface CityRepository extends BaseRepository<City,Long> {
    HashMap<String,Integer> teamCount();
}
