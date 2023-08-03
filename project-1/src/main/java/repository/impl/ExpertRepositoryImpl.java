package repository.impl;

import base.repository.impl.BaseRepositoryImpl;
import entity.Customer;
import entity.Expert;
import entity.SubService;
import exceptions.ExpertException;
import exceptions.MailException;
import org.hibernate.Session;
import repository.ExpertRepository;
import util.HibernateUtil;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

public class ExpertRepositoryImpl extends BaseRepositoryImpl<Expert,Long>
                                    implements ExpertRepository {
    private Session session;

    public ExpertRepositoryImpl(Session session) {
        super(session);
        this.session=session;
    }

    @Override
    public Class<Expert> getEntityClass() {
        return Expert.class;
    }

    @Override
    public void validateMail(String mail) {
        try {
            Customer customer = session.createQuery("from Expert where mail=:mail",
                    Customer.class).setParameter("mail",mail).getSingleResult();
        }catch (NullPointerException e){
            throw new  MailException();
        }
    }

    @Override
    public Session getSession() {
        return session;
    }
}
