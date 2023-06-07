package repository.impl;

import base.repository.impl.BaseRepositoryImpl;
import entity.Comment;
import entity.Likes;
import entity.Tweet;
import entity.Users;
import org.hibernate.Session;
import repository.CommentRepository;
import repository.LikeRepository;
import repository.TweetRepository;
import utill.HibernateUtil;

import java.util.List;

public class TweetRepositoryImpl extends BaseRepositoryImpl<Tweet,Long> implements TweetRepository {
    public TweetRepositoryImpl(Session session) {
        super(session);
    }
    Session session = HibernateUtil.getSessionFactory().openSession();
    LikeRepository likeRepository = new LikeRepositoryImpl(session);
    CommentRepository commentRepository = new CommentRepositoryImpl(session);
    @Override
    public Class<Tweet> getEntityClass() {
        return Tweet.class;
    }
    @Override
    public String view(Tweet tweet){
        List<Likes> likes= session.createQuery("from Likes where tweet=:tweet",
                Likes.class).setParameter("tweet",tweet).getResultList();
        List<Comment> comments = session.createQuery("from Comment where tweet=:tweet",
                Comment.class).setParameter("tweet",tweet).getResultList();
        System.out.println(tweet.getUser().getUsername()+" : "+tweet.getTweet());
        System.out.println("likes : "+likes.size());
        System.out.println("comments : ");
        for (Comment c:comments
        ) {
            System.out.println(c.getUsers().getUsername()+" : "+c.getComment());
        }
        return tweet.getTweet();
    }
    @Override
    public String yourTweet(Users users) {
        List<Tweet> tweets = session.createQuery("from Tweet where user=:users",
                Tweet.class).setParameter("users",users).getResultList();
        for (Tweet t:tweets
        ) {
            System.out.println(t.getId() + " "+ t.getTweet());
        }
        return users.getUsername();
    }

    @Override
    public String deleteTweet(Tweet tweet){
        List<Likes> likes= session.createQuery("from Likes where tweet=:tweet",
                Likes.class).setParameter("tweet",tweet).getResultList();
        for (Likes l:likes
             ) {
            likeRepository.delete(l);
        }
        List<Comment> comments = session.createQuery("from Comment where tweet=:tweet",
                Comment.class).setParameter("tweet",tweet).getResultList();
        for (Comment c:comments
             ) {
            commentRepository.delete(c);
        }
        delete(tweet);
        return "the tweet delete";
    }

}
