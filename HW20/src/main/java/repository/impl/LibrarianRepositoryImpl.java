package repository.impl;

import base.repository.impl.BaseRepositoryImpl;
import entity.Librarian;
import org.hibernate.Session;
import repository.LibrarianRepository;

public class LibrarianRepositoryImpl extends BaseRepositoryImpl<Librarian,Long> implements LibrarianRepository {
    public LibrarianRepositoryImpl(Session session) {
        super(session);
    }

    @Override
    public Class<Librarian> getEntityClass() {
        return Librarian.class;
    }
}
