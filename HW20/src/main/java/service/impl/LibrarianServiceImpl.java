package service.impl;

import base.service.impl.BaseServiceImpl;
import entity.Librarian;
import org.hibernate.Session;
import service.LibrarianService;

public class LibrarianServiceImpl extends BaseServiceImpl<Librarian,Long> implements LibrarianService {
    public LibrarianServiceImpl(Session session) {
        super(session);
    }

    @Override
    public Class<Librarian> getEntityClass() {
        return Librarian.class;
    }
}
