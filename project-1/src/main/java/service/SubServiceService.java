package service;

import base.service.BaseService;
import entity.Service;
import entity.SubService;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

public interface SubServiceService extends BaseService<SubService,Long> {
    SubService searchBySubService(String subService);
    List<SubService> searchByService(Service service);
}
