package repository.impl;

import base.repository.impl.BaseRepositoryImpl;
import entity.Likes;
import entity.Tweet;
import entity.Users;
import org.hibernate.Session;
import repository.LikeRepository;
import utill.HibernateUtil;

import java.util.List;
import java.util.Optional;

public class LikeRepositoryImpl extends BaseRepositoryImpl<Likes,Long> implements LikeRepository {
    Session session = HibernateUtil.getSessionFactory().openSession();
    private Boolean isLiked;

    public LikeRepositoryImpl(Session session) {
        super(session);
    }

    @Override
    public Class<Likes> getEntityClass() {
        return Likes.class;
    }

    public void like(Tweet tweet,Users users ) {
        isLiked = false;
        List<Likes> likes = findAll();

        for (Likes l : likes
        ) {
            if (l.getUser().getId() == users.getId() && l.getTweet().getId() == tweet.getId()) {
                isLiked = true;
            }
        }
            if (isLiked==false){
                Likes sl = new Likes(tweet,users);
                save(sl);
                System.out.println("you liked this tweet");
            }
        else {
                System.out.println(("you have already liked this tweet"));
            }
    }

    @Override
    public void UnLike(Tweet tweet,Users users ) {
        isLiked = false;
        List<Likes> likes = findAll();
        for (Likes l:likes
             ) {
            if (l.getUser().getId()==users.getId()&&l.getTweet().getId()==tweet.getId()){
                isLiked=true;
                delete(l);
                System.out.println("you unlike this tweet");
            }
        }
        if (isLiked==false){
            System.out.println("you have not liked this tweet");
        }

    }

}
