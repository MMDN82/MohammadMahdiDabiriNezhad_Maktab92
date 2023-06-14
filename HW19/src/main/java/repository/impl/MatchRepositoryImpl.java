package repository.impl;

import Base.repository.impl.BaseRepositoryImpl;
import entity.Match;
import org.hibernate.Session;
import repository.MatchRepository;
import utill.HibernateUtil;

import java.util.List;

public class MatchRepositoryImpl extends BaseRepositoryImpl<Match,Long> implements MatchRepository {
    private Session session = HibernateUtil.getSessionFactory().openSession();
    public MatchRepositoryImpl(Session session) {
        super(session);
    }
    @Override
    public Class<Match> getEntityClass() {
        return Match.class;
    }
    @Override
    public String TheMostSuccessfulDerby(){
        Match ans = new Match();
        List<Match> derby = session.createQuery("from Match where teamOne.city=teamTwo.city",
                Match.class).getResultList();
        Long maxGoal=0l;
        for (Match m:derby
             ) {
            if (m.getTeamOneGoal()+m.getTeamTwoGoal()>maxGoal) {
                maxGoal = m.getTeamOneGoal() + m.getTeamTwoGoal();
                ans=m;
            }
        }

        return ans.getTeamOne().getName()+" : "+ans.getTeamOneGoal()+" - "+ans.getTeamTwoGoal()+" : "+ans.getTeamTwo().getName() ;
    }
}
