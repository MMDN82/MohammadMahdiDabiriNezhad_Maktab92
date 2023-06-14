import entity.City;
import org.hibernate.Session;
import repository.*;
import repository.impl.*;
import service.TeamService;
import service.impl.TeamServiceImpl;
import utill.HibernateUtil;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        CityRepository cityRepository = new CityRepositoryImpl(session);
        CoachRepository coachRepository = new CoachRepositoryImpl(session);
        PlayerRepository playerRepository = new PlayerRepositoryImpl(session);
        TeamRepository teamRepository = new TeamRepositoryImpl(session);
        TeamService teamService = new TeamServiceImpl();
        MatchRepository matchRepository = new MatchRepositoryImpl(session);

        //the most expensive Coach
        //System.out.println(coachRepository.maxPrice());

        //the most expensive players
        //System.out.println(playerRepository.theMostExpensivePlayers());

        //List of city and team count
        //System.out.println(cityRepository.teamCount());

        //teams score
        //System.out.println(teamService.scoreTable());

        //top team
        //System.out.println(teamService.topTeam());

        //The most successful derby
        //System.out.println(matchRepository.TheMostSuccessfulDerby());

    }
}
