package service;

import base.service.BaseService;
import entity.Service;

import java.util.HashSet;
import java.util.List;

public interface ServiceService extends BaseService<Service,Long> {
    Service searchByService(String service) ;
    List<Service> showServices();

}
