package service.impl;

import base.service.impl.BaseServiceImpl;
import entity.Book;
import org.hibernate.Session;
import service.BookService;

public class BookServiceImpl extends BaseServiceImpl<Book,Long> implements BookService {
    public BookServiceImpl(Session session) {
        super(session);
    }

    @Override
    public Class<Book> getEntityClass() {
        return Book.class;
    }
}
