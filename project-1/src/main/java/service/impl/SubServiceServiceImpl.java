package service.impl;

import base.service.impl.BaseServiceImpl;
import entity.Service;
import entity.SubService;
import exceptions.SubServiceException;
import org.hibernate.Session;
import org.hibernate.internal.SessionImpl;
import repository.SubServiceRepository;
import repository.impl.SubServiceRepositoryImpl;
import service.SubServiceService;
import util.HibernateUtil;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

public class SubServiceServiceImpl extends BaseServiceImpl<SubService,Long, SubServiceRepository>
                                    implements SubServiceService {

    private SubServiceRepository subServiceRepository;

    public SubServiceServiceImpl(SubServiceRepository subServiceRepository) {
        super(subServiceRepository);
        this.subServiceRepository=subServiceRepository;
    }
    @Override
    public SubService searchBySubService(String subService) {
        SubService subService1 = new SubService();
        try {
            if (subServiceRepository.searchBySubService(subService).isPresent()){
                subService1 = subServiceRepository.searchBySubService(subService).get();
            }else {
                throw new SubServiceException("sub service not found");
            }
        }catch (SubServiceException e){
            System.out.println(e.getMessage());
        }
        return subService1;
    }
    @Override
    public List<SubService> searchByService(Service service) {
        return subServiceRepository.searchByService(service);
    }
}
