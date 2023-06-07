package repository.impl;

import base.repository.impl.BaseRepositoryImpl;
import entity.Tweet;
import entity.Users;
import jakarta.persistence.NoResultException;
import org.hibernate.Session;
import repository.TweetRepository;
import repository.UserRepository;
import utill.HibernateUtil;

import java.util.List;
import java.util.Optional;

public class UserRepositoryImpl extends BaseRepositoryImpl<Users,Long> implements UserRepository {
    private Session session = HibernateUtil.getSessionFactory().openSession();

    public UserRepositoryImpl(Session session) {
        super(session);
    }
    private TweetRepository tweetRepository = new TweetRepositoryImpl(session);

    @Override
    public Class<Users> getEntityClass() {
        return Users.class;
    }

    @Override
    public Optional<Users> findByUsername(String user) {
        Users ans = session.createQuery("from Users where username =:user",
                Users.class).setParameter("user",user).getSingleResult();
        return Optional.ofNullable(ans);
    }
    @Override
    public void signUp(Users user) {
        try {
            Users ans1 =session.createQuery("from Users where username=:username",
                    Users.class).setParameter("username", user.getUsername()).getSingleResult();
            if (ans1!=null)
                System.out.println("this user exist");
        }catch (NoResultException e){
            save(user);
        }
    }

    @Override
    public String deleteUser(Users users) {
        List<Tweet> tweets = session.createQuery("from Tweet where user=:user",
                Tweet.class).setParameter("user",users).getResultList();
        for (Tweet t:tweets
             ) {
            tweetRepository.deleteTweet(t);
        }
        delete(users);
        return "account deleted";
    }
}
