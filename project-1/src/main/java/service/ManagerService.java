package service;

import base.service.BaseService;
import entity.Expert;
import entity.Manager;
import entity.Service;
import entity.SubService;
import entity.enums.ExpertStatus;
import exceptions.ExpertException;
import exceptions.ServiceException;

import java.util.HashSet;
import java.util.List;

public interface ManagerService extends BaseService<Manager,Long> {
    void addService(String service) throws ServiceException;
    void addSubService(String subService,Long basePrice,String service) throws Exception;
    List<SubService> showSubServicesFromExpert(Expert expert);
    void addExpertFromSubService(Expert expert,String subService) throws ExpertException;
    void removeExpertFromSubService(Expert expert,String subService) throws ExpertException;
    List<Service> showServices();
    void modifyBasePriseFromSubService(SubService subService,Long newPrice);
    void modifyDescriptionFromSubService(SubService subService,String newDescription);
    List<Expert> showExperts();
    void confirmationExpert(Expert expert, ExpertStatus newExpertStatus);
}
