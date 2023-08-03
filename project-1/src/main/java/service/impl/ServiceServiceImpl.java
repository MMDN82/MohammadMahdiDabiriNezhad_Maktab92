package service.impl;

import base.repository.impl.BaseRepositoryImpl;
import base.service.impl.BaseServiceImpl;
import entity.Service;
import entity.SubService;
import org.hibernate.Session;
import repository.ServiceRepository;
import repository.SubServiceRepository;
import repository.impl.ServiceRepositoryImpl;
import service.ServiceService;
import service.SubServiceService;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ServiceServiceImpl extends BaseServiceImpl<Service,Long, ServiceRepository>
        implements ServiceService {
    private ServiceRepository serviceRepository;
    public ServiceServiceImpl(ServiceRepository serviceRepository) {
        super(serviceRepository);
        this.serviceRepository=serviceRepository;
    }

    @Override
    public Service searchByService(String service) {
        return  serviceRepository.searchByService(service);
    }

    @Override
    public List<Service> showServices() {
        List<Service> services = new ArrayList<>(findAll());
        return services;
    }

}
