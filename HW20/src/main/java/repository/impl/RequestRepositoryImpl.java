package repository.impl;

import base.repository.impl.BaseRepositoryImpl;
import entity.Request;
import org.hibernate.Session;
import repository.RequestRepository;

public class RequestRepositoryImpl extends BaseRepositoryImpl<Request,Long> implements RequestRepository {
    public RequestRepositoryImpl(Session session) {
        super(session);
    }
    @Override
    public Class<Request> getEntityClass() {
        return Request.class;
    }
}
