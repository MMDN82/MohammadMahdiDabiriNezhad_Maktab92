import entity.Likes;
import entity.Tweet;
import entity.Users;
import org.hibernate.Session;
import repository.CommentRepository;
import repository.LikeRepository;
import repository.TweetRepository;
import repository.UserRepository;
import repository.impl.CommentRepositoryImpl;
import repository.impl.LikeRepositoryImpl;
import repository.impl.TweetRepositoryImpl;
import repository.impl.UserRepositoryImpl;
import service.TweetService;
import service.impl.TweetServiceImpl;
import utill.HibernateUtil;

import java.time.LocalDate;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Users user = new Users();
       user.setFirstname("maahdi");
       user.setLastname("a");
        user.setDateOfBirth(LocalDate.of(2003,12,12));
       user.setUsername("dc");
        user.setPassword("12345678");
//        Users user1 = new Users();
//        user1.setId(11l);
//        user1.setFirstname("bbb");
//        user1.setLastname("asdsd");
//        user1.setDateOfBirth(LocalDate.of(2003,1,1));
//        user1.setUsername("asssssd");
//        user1.setPassword("12345678");
        TweetService tweetService = new TweetServiceImpl();
        TweetRepository tweetRepository = new TweetRepositoryImpl(session);
        UserRepository userRepository = new UserRepositoryImpl(session);


//         = session.createQuery("from Users where user=:user",
//                Users.class).setParameter("id",user).getResultList();
        CommentRepository commentRepository = new CommentRepositoryImpl(session);



//         Optional<Users> users = userRepository.findById(1l);
//         if (users.isPresent()){
//             Users users1 = users.get();
//             System.out.println(users1);
//         }
//        System.out.println(users.get().getFirstname());
//        Optional<Tweet> tweet = tweetRepository.findById(1l);
//        tweetRepository.delete(tweet.get());



    }
}
