package service.impl;

import base.service.impl.BaseServiceImpl;
import entity.Request;
import org.hibernate.Session;
import service.RequestService;

import javax.imageio.spi.RegisterableService;

public class RequestServiceImpl extends BaseServiceImpl<Request,Long> implements RequestService {
    public RequestServiceImpl(Session session) {
        super(session);
    }
    @Override
    public Class<Request> getEntityClass() {
        return Request.class;
    }
}
