package repository.impl;

import base.repository.impl.BaseRepositoryImpl;
import entity.Service;
import exceptions.ServiceException;
import jakarta.persistence.NoResultException;
import org.hibernate.Session;
import repository.ServiceRepository;
import util.HibernateUtil;

public class ServiceRepositoryImpl extends BaseRepositoryImpl<Service, Long>
        implements ServiceRepository {
    private Session session;


    public ServiceRepositoryImpl(Session session) {
        super(session);
        this.session=session;
    }

    @Override
    public Class<Service> getEntityClass() {
        return Service.class;
    }

    @Override
    public Service searchByService(String service) {
       Service ans =  session.createQuery("from Service where service=:service",
                Service.class).setParameter("service", service).getSingleResult();
       return ans;
    }

    @Override
    public Session getSession() {
        return session;
    }
}
