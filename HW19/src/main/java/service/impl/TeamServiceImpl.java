package service.impl;

import entity.Team;
import org.hibernate.Session;
import repository.TeamRepository;
import repository.impl.TeamRepositoryImpl;
import service.TeamService;
import utill.HibernateUtil;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class TeamServiceImpl implements TeamService {
    Session session= HibernateUtil.getSessionFactory().openSession();
    TeamRepository teamRepository = new TeamRepositoryImpl(session);
    @Override
    public HashMap<String, Integer> scoreTable() {
        HashMap<String,Integer> ans = new HashMap<String,Integer>();
        List<Team> teams = teamRepository.findAll();
        for (Team t:teams
             ) {
            ans.put(t.getName(),teamRepository.teamScore(t.getId()));
        }
        return ans;
    }

    @Override
    public HashMap<String, Integer> topTeam() {
        HashMap<String,Integer> teams = scoreTable();
        HashMap<String,Integer> ans = new HashMap<String,Integer>();
        Integer maxScore = Collections.max(teams.values());

        for ( String key : teams.keySet() ) {
            if (teams.get(key)==maxScore)
            ans.put(key,maxScore);
        }


        return ans;
    }
}
