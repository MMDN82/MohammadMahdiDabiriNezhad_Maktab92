package repository.impl;

import Base.repository.impl.BaseRepositoryImpl;
import entity.Match;
import entity.Team;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import repository.MatchRepository;
import repository.TeamRepository;
import utill.HibernateUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Queue;

public class TeamRepositoryImpl extends BaseRepositoryImpl<Team, Long> implements TeamRepository {
    private Session session = HibernateUtil.getSessionFactory().openSession();
    private MatchRepository matchRepository = new MatchRepositoryImpl(session);

    public TeamRepositoryImpl(Session session) {
        super(session);
    }

    @Override
    public Class<Team> getEntityClass() {
        return Team.class;
    }

    @Override
    public Integer teamScore(Long id) {
        Integer score=null;
        Optional<Team> team = findById(id);
        if (team.isPresent()){
           List<Match> matches = session.createQuery("from Match where winner=:team",
                   Match.class).setParameter("team",team.get()).getResultList();
           score = matches.size()*3;
           List<Match> matchList = session.createQuery("from Match where isDraw=TRUE and (teamOne=:team1 or teamTwo=:team2)",
                   Match.class).setParameter("team1",team.get()).setParameter("team2",team.get()).getResultList();

            score+=matchList.size();

        }
        return score;
    }
}
