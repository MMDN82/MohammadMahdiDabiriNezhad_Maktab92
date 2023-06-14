package repository.impl;

import Base.repository.impl.BaseRepositoryImpl;
import entity.City;
import entity.Player;
import entity.Team;
import org.hibernate.Session;
import repository.CityRepository;
import utill.HibernateUtil;

import java.util.HashMap;
import java.util.List;

public class CityRepositoryImpl extends BaseRepositoryImpl<City , Long> implements CityRepository {
    Session session = HibernateUtil.getSessionFactory().openSession();
    public CityRepositoryImpl(Session session) {
        super(session);
    }

    @Override
    public Class<City> getEntityClass() {
        return City.class;
    }

    @Override
    public HashMap<String,Integer> teamCount() {
        List<City> cities = findAll();
        HashMap<String,Integer> ans = new HashMap<String,Integer>();
        for (City c:cities
             ) {
            List<Team> teams = session.createQuery("from Team where city=:c",
                    Team.class).setParameter("c",c).getResultList();
            ans.put(c.getCity(),teams.size());
        }
        return ans;
    }
}
