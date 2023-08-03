package repository.impl;

import base.repository.impl.BaseRepositoryImpl;
import entity.Customer;
import exceptions.MailException;
import org.hibernate.Session;
import repository.CustomerRepository;
import util.HibernateUtil;

public class CustomerRepositoryImpl extends BaseRepositoryImpl<Customer, Long>
        implements CustomerRepository {
    private Session session;

    public CustomerRepositoryImpl(Session session) {
        super(session);
        this.session=session;
    }

    @Override
    public Class<Customer> getEntityClass() {
        return Customer.class;
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
