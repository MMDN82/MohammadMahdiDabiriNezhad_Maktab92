package repository.impl;

import base.repository.impl.BaseRepositoryImpl;
import entity.Manager;
import org.hibernate.Session;
import repository.ManagerRepository;
import util.HibernateUtil;

public class ManagerRepositoryImpl extends BaseRepositoryImpl<Manager,Long>
                                    implements ManagerRepository {
    private Session session;
    public ManagerRepositoryImpl(Session session) {
        super(session);
        this.session=session;
    }

    @Override
    public Class<Manager> getEntityClass() {
        return Manager.class;
    }

    @Override
    public Session getSession() {
        return session;
    }
}
