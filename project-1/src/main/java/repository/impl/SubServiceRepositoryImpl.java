package repository.impl;

import base.repository.impl.BaseRepositoryImpl;
import entity.Service;
import entity.SubService;
import org.hibernate.Session;
import repository.SubServiceRepository;
import util.HibernateUtil;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

public class SubServiceRepositoryImpl extends BaseRepositoryImpl<SubService,Long>
                        implements SubServiceRepository {
    private Session session;
    public SubServiceRepositoryImpl(Session session) {
        super(session);
        this.session=session;
    }
    @Override
    public Class<SubService> getEntityClass() {
        return SubService.class;
    }
    @Override
    public Session getSession() {
        return session;
    }
    @Override
    public Optional<SubService> searchBySubService(String subService) {
        SubService ans = session.createQuery("from SubService where subService=:subService",
                SubService.class).setParameter("subService",subService).getSingleResult();
        return Optional.ofNullable(ans);
    }
    @Override
    public List<SubService> searchByService(Service service) {
        List<SubService> subServices = session.createQuery("from SubService where service=:service",
                SubService.class).setParameter("service",service).getResultList();
        return subServices;
    }

}
