package service.impl;

import entity.Comment;
import entity.Likes;
import entity.Tweet;
import entity.Users;
import org.hibernate.Session;
import repository.LikeRepository;
import repository.TweetRepository;
import repository.impl.LikeRepositoryImpl;
import repository.impl.TweetRepositoryImpl;
import service.TweetService;
import utill.HibernateUtil;
import java.util.List;

public class TweetServiceImpl implements TweetService {
    Session session = HibernateUtil.getSessionFactory().openSession();
    TweetRepository tweetRepository = new TweetRepositoryImpl(session);

    @Override
    public String allTweet() {

        List<Tweet> tweets = tweetRepository.findAll();
        for (Tweet t:tweets
        ) {
            System.out.println(t.getUser().getUsername() + " : "+t.getId()+ " - " + t.getTweet());
        }
        return null;
    }


}
