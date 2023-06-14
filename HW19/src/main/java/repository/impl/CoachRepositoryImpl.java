package repository.impl;

import Base.repository.impl.BaseRepositoryImpl;
import entity.Coach;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.hibernate.Session;
import repository.CoachRepository;
import utill.HibernateUtil;

public class CoachRepositoryImpl extends BaseRepositoryImpl<Coach,Long> implements CoachRepository {
    private Session session = HibernateUtil.getSessionFactory().openSession();

    public CoachRepositoryImpl(Session session) {
        super(session);
    }

    @Override
    public Class<Coach> getEntityClass() {
        return Coach.class;
    }
    @Override
    public Coach maxPrice(){
        Long maxPrice = session.createQuery("select max(price) from Coach ",
                Long.class).getSingleResult();
        Coach coach = session.createQuery("FROM Coach where price=:mp",
                Coach.class).setParameter("mp",maxPrice).getSingleResult();
        return coach;
    }

}
