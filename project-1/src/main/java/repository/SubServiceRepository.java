package repository;

import base.repository.BaseRepository;
import entity.Service;
import entity.SubService;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

public interface SubServiceRepository extends BaseRepository<SubService,Long> {
    Optional<SubService> searchBySubService(String subService) ;
    List<SubService> searchByService(Service service);
}
