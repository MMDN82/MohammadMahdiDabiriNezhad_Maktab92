package service.impl;

import base.service.impl.BaseServiceImpl;
import entity.Expert;
import entity.Manager;
import entity.Service;
import entity.SubService;
import entity.enums.ExpertStatus;
import exceptions.ExpertException;
import exceptions.ServiceException;
import exceptions.SubServiceException;
import jakarta.persistence.NoResultException;
import org.hibernate.Session;
import repository.ExpertRepository;
import repository.ManagerRepository;
import repository.ServiceRepository;
import repository.SubServiceRepository;
import repository.impl.ExpertRepositoryImpl;
import repository.impl.ServiceRepositoryImpl;
import repository.impl.SubServiceRepositoryImpl;
import service.ExpertService;
import service.ManagerService;
import service.ServiceService;
import service.SubServiceService;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ManagerServiceImpl extends BaseServiceImpl<Manager,Long, ManagerRepository>
        implements ManagerService {
    private ManagerRepository managerRepository;
    private Session session = HibernateUtil.getSessionfactory().openSession();
    private ServiceRepository serviceRepository = new ServiceRepositoryImpl(session);
    private SubServiceRepository subServiceRepository = new SubServiceRepositoryImpl(session);
    private ExpertRepository expertRepository = new ExpertRepositoryImpl(session);
    private ServiceService serviceService = new ServiceServiceImpl(serviceRepository);
    private SubServiceService subServiceService = new SubServiceServiceImpl(subServiceRepository);
    private ExpertService expertService = new ExpertServiceImpl(expertRepository);

    public ManagerServiceImpl(ManagerRepository managerRepository) {
        super(managerRepository);
        this.managerRepository=managerRepository;
    }
    @Override
    public void addService(String service) throws ServiceException {
        try {
            serviceService.searchByService(service);
            throw new ServiceException("this service exist");
        } catch (NoResultException e) {
            Service service1 = new Service();
            service1.setService(service);
            serviceService.save(service1);
        }
    }
    @Override
    public void addSubService(String subService, Long basePrice, String service) throws Exception {
        try {
            Service service1 = serviceService.searchByService(service);
            try {
                subServiceService.searchBySubService(subService);
                throw new SubServiceException("this sub service exist");
            } catch (NullPointerException e) {
                SubService subService1 = new SubService();
                subService1.setBasePrice(basePrice);
                subService1.setService(service1);
                subService1.setSubService(subService);
            }
        } catch (NoResultException e) {
            throw new ServiceException("service not exist");
        }
    }

    @Override
    public List<SubService> showSubServicesFromExpert(Expert expert) {
        List<SubService> ans = new ArrayList<>();
        try {
            ans.addAll(expertService.showSubServices(expert));
        } catch (ExpertException e) {
            System.out.println(e.getMessage());
        }
        return ans;
    }

    @Override
    public void addExpertFromSubService(Expert expert, String subService) throws ExpertException {
        SubService subService1 = subServiceService.searchBySubService(subService);
        HashSet<SubService> subServices = new HashSet<>();
        if (expert.getSubServices().contains(subService1)) {
            throw new ExpertException("this sub service exist in this expert");
        } else {
            subServices.add(subService1);
            expert.setSubServices(subServices);
        }
    }
    @Override
    public void removeExpertFromSubService(Expert expert, String subService) throws ExpertException {
        SubService subService1 = subServiceService.searchBySubService(subService);
        HashSet<SubService> subServices = new HashSet<>();
        if (expert.getSubServices().contains(subService1)) {
            subServices.add(subService1);
            expert.getSubServices().removeAll(subServices);
        } else {
            throw new ExpertException("this sub service not exist in this expert");
        }
    }

    @Override
    public List<Service> showServices() {
        return serviceService.showServices();
    }

    @Override
    public void modifyBasePriseFromSubService(SubService subService, Long newPrice) {
        subService.setBasePrice(newPrice);
        subServiceService.update(subService);
    }

    @Override
    public void modifyDescriptionFromSubService(SubService subService, String newDescription) {
        subService.setDescription(newDescription);
        subServiceService.update(subService);
    }

    @Override
    public List<Expert> showExperts() {
        List<Expert> ans = new ArrayList<>(expertService.findAll());
        return ans;
    }

    @Override
    public void confirmationExpert(Expert expert, ExpertStatus newExpertStatus) {
        expert.setExpertStatus(newExpertStatus);
        expertService.update(expert);
    }
}
