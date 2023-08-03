package repository;

import base.repository.BaseRepository;
import entity.Service;
import entity.SubService;
import exceptions.ServiceException;

import java.util.HashSet;

public interface ServiceRepository extends BaseRepository<Service,Long> {
    Service searchByService(String service) ;

}
