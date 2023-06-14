package repository.impl;

import Base.repository.impl.BaseRepositoryImpl;
import entity.Player;
import org.hibernate.Session;
import repository.PlayerRepository;
import utill.HibernateUtil;

import java.util.List;

public class PlayerRepositoryImpl extends BaseRepositoryImpl<Player,Long> implements PlayerRepository {
    Session session= HibernateUtil.getSessionFactory().openSession();
    public PlayerRepositoryImpl(Session session) {
        super(session);
    }

    @Override
    public Class<Player> getEntityClass() {
        return Player.class;
    }

    @Override
    public List<Player> theMostExpensivePlayers() {
        Double avgPrice=session.createQuery("select AVG(price) from Player",
                Double.class).getSingleResult();
        Long avg = Math.round(avgPrice);
        List<Player> players = session.createQuery("from Player where price > :avg",
                Player.class).setParameter("avg",avg).getResultList();
        return players;
    }
}
