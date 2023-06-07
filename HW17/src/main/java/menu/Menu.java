package menu;

import entity.Comment;
import entity.Likes;
import entity.Tweet;
import entity.Users;
import jakarta.persistence.NoResultException;
import org.hibernate.Session;
import repository.CommentRepository;
import repository.LikeRepository;
import repository.TweetRepository;
import repository.impl.CommentRepositoryImpl;
import repository.impl.LikeRepositoryImpl;
import repository.impl.TweetRepositoryImpl;
import repository.impl.UserRepositoryImpl;
import service.CommentService;
import service.TweetService;
import service.UserService;
import service.impl.CommentServiceImpl;
import service.impl.TweetServiceImpl;
import service.impl.UserServiceImpl;
import utill.HibernateUtil;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        UserRepositoryImpl userRepository = new UserRepositoryImpl(session);
        UserService userService = new UserServiceImpl();
        TweetRepositoryImpl tweetRepository = new TweetRepositoryImpl(session);
        TweetService tweetService = new TweetServiceImpl();
        CommentRepository commentRepository = new CommentRepositoryImpl(session);
        CommentService commentService = new CommentServiceImpl();
        LikeRepository likeRepository = new LikeRepositoryImpl(session);
        Users ans = new Users();
        String value;
        Long id;
        int num2 = 0;
        while (true) {
            System.out.println("Enter the desired operation number");
            System.out.println("1-login");
            System.out.println("2-sign Up");
            int num = new Scanner(System.in).nextInt();

            switch (num) {

                case 1:
                    System.out.println("enter username");
                    String user = new Scanner(System.in).next();
                    System.out.println("enter password");
                    String pass = new Scanner(System.in).next();
                    try {
                        ans = session.createQuery("from Users where username=:username and password=:password",
                                Users.class).setParameter("username", user).setParameter("password", pass).getSingleResult();
                    } catch (NoResultException e) {
                        System.out.println("username or password is incorrect");
                        break;
                    }
                    if (ans != null) {
                        while (true) {
                            System.out.println("Enter the desired operation number");
                            System.out.println("1-edit profile");
                            System.out.println("2-search by username");
                            System.out.println("3-start");
                            System.out.println("4-logout");
                            num = new Scanner(System.in).nextInt();
                            switch (num) {
                                case 1:
                                    while (true) {
                                        System.out.println(ans);
                                        System.out.println("Enter the desired operation number : ");
                                        System.out.println("1-edite firstname");
                                        System.out.println("2-edite lastname");
                                        System.out.println("3-edite date of birth");
                                        System.out.println("4-edite username");
                                        System.out.println("5-edite password");
                                        System.out.println("6-delete account");
                                        System.out.println("7- back");
                                        num = new Scanner(System.in).nextInt();
                                        switch (num) {
                                            case 1:
                                                ans.setId(ans.getId());
                                                System.out.println("enter new firstname : ");
                                                value = new Scanner(System.in).nextLine();
                                                ans.setFirstname(value);
                                                userRepository.update(ans);
                                                break;
                                            case 2:
                                                ans.setId(ans.getId());
                                                System.out.println("enter new lastname : ");
                                                value = new Scanner(System.in).nextLine();
                                                ans.setLastname(value);
                                                userRepository.update(ans);
                                                break;
                                            case 3:
                                                ans.setId(ans.getId());
                                                System.out.println("enter new date of birthday [yyyy.MM.dd] : ");
                                                value = new Scanner(System.in).next();
                                                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd");
                                                LocalDate localDate = LocalDate.parse(value, dtf);
                                                ans.setDateOfBirth(localDate);
                                                userRepository.update(ans);
                                                break;
                                            case 4:
                                                ans.setId(ans.getId());
                                                System.out.println("enter new username : ");
                                                value = new Scanner(System.in).nextLine();
                                                Optional<Users> ans1 = userRepository.findByUsername(value);
                                                if (ans1.isPresent()){System.out.println("this user exist please enter another");
                                                }else {
                                                    System.out.println("user not found");
                                                }
                                                break;
                                            case 5:
                                                ans.setId(ans.getId());
                                                System.out.println("enter new password :");
                                                value = new Scanner(System.in).next();
                                                ans.setPassword(value);
                                                userRepository.update(ans);
                                                break;
                                            case 6:
                                                userRepository.deleteUser(ans);
                                                num = 7;
                                                num2 = 2;
                                                break;
                                        }
                                        if (num == 7 || num2 == 2)
                                            break;
                                    }
                                    break;
                                case 2:
                                    System.out.println("enter username : ");
                                    value = new Scanner(System.in).next();
                                    try {
                                        System.out.println(userService.searchByUsername(value));
                                    }catch (NoResultException e){
                                        System.out.println("this user not exist");
                                    }

                                    break;
                                case 3:
                                    while (true) {
                                        System.out.println("Enter the desired operation number : ");
                                        System.out.println("1-add tweet");
                                        System.out.println("2-your tweets");
                                        System.out.println("3-edite tweets");
                                        System.out.println("4-delete tweets");
                                        System.out.println("5-all tweets");
                                        System.out.println("6-add comment");
                                        System.out.println("7-your comments");
                                        System.out.println("8_edite comment");
                                        System.out.println("9_delete comment");
                                        System.out.println("10_like tweet");
                                        System.out.println("11_unlike tweet");
                                        System.out.println("12_view a tweet");
                                        System.out.println("13-back");
                                        num = new Scanner(System.in).nextInt();
                                        switch (num) {
                                            case 1:
                                                System.out.println("enter tweet : ");
                                                Tweet nt = new Tweet();
                                                value = new Scanner(System.in).nextLine();
                                                nt.setUser(ans);
                                                nt.setTweet(value);
                                                tweetRepository.save(nt);
                                                break;
                                            case 2:
                                                System.out.println(tweetRepository.yourTweet(ans));
                                                break;
                                            case 3:
                                                System.out.println("enter tweet id : ");
                                                id = new Scanner(System.in).nextLong();
                                                Optional<Tweet> et = tweetRepository.findById(id);
                                                if (et.isPresent()){
                                                if (et.get().getUser().getId() == ans.getId()) {
                                                    System.out.println("edite tweet : ");
                                                    value = new Scanner(System.in).nextLine();
                                                    et.get().setTweet(value);
                                                    tweetRepository.update(et.get());
                                                    System.out.println("tweet edite");
                                                } else {
                                                    System.out.println("you can't edite this tweet");
                                                }
                                                }
                                                else {
                                                    System.out.println("tweet not found");
                                                }
                                                break;
                                            case 4:
                                                System.out.println("enter tweet id : ");
                                                id = new Scanner(System.in).nextLong();
                                                Optional<Tweet> dt = tweetRepository.findById(id);
                                                if (dt.isPresent()){
                                                    tweetRepository.deleteTweet(dt.get());
                                                }else {
                                                    System.out.println("tweet not found");
                                                }

                                                break;
                                            case 5:
                                                tweetService.allTweet();
                                                break;
                                            case 6:
                                                System.out.println("enter tweet id : ");
                                                id = new Scanner(System.in).nextLong();
                                                Optional<Tweet> ht = tweetRepository.findById(id);
                                                if (ht.isPresent()) {
                                                    Comment nc = new Comment();
                                                    nc.setTweet(ht.get());
                                                    nc.setUsers(ans);
                                                    System.out.println("enter comment : ");
                                                    value = new Scanner(System.in).nextLine();
                                                    nc.setComment(value);
                                                    commentRepository.save(nc);
                                                }else {
                                                    System.out.println("tweet not found");
                                                }
                                                break;
                                            case 7:
                                                for (Comment c : commentRepository.yourComments(ans)) {
                                                    System.out.print(c.getId() + "-" + c.getComment());
                                                    System.out.println("(reply as " + c.getTweet().getUser().getUsername() + ":" + c.getTweet().getId() + "-" + c.getTweet().getTweet() + ")");
                                                }
                                                break;
                                            case 8:
                                                System.out.println("enter comment id : ");
                                                id = new Scanner(System.in).nextLong();
                                                Optional<Comment> ec =commentRepository.findById(id);
                                                if (ec.isPresent()){
                                                if (ec.get().getUsers().getUsername() == ans.getUsername()) {
                                                    System.out.println("edite comment : ");
                                                    value = new Scanner(System.in).nextLine();
                                                    ec.get().setComment(value);
                                                    commentRepository.update(ec.get());
                                                } else {
                                                    System.out.println(("you can't edite this comment"));
                                                }
                                                }else {
                                                    System.out.println("comment not found");
                                                }
                                                break;
                                            case 9:
                                                System.out.println("enter comment id : ");
                                                id = new Scanner(System.in).nextLong();
                                                Optional<Comment> dc =commentRepository.findById(id);
                                                if (dc.isPresent()){
                                                if (dc.get().getUsers().getUsername() == ans.getUsername()) {
                                                    commentRepository.delete(dc.get());
                                                } else {
                                                    System.out.println(("you can't delete this comment"));
                                                }
                                                }else {
                                                    System.out.println("comment not found");
                                                }
                                                break;
                                            case 10:
                                                System.out.println("enter tweet id : ");
                                                id = new Scanner(System.in).nextLong();
                                                Optional<Tweet> lt = tweetRepository.findById(id);
                                                if (lt.isPresent()){
                                                 likeRepository.like(lt.get(),ans);
                                                }else {
                                                    System.out.println("the tweet not found");
                                                }
                                                break;
                                            case 11:
                                                System.out.println("enter tweet id : ");
                                                id = new Scanner(System.in).nextLong();
                                                Optional<Tweet> ut = tweetRepository.findById(id);
                                                if (ut.isPresent()){
                                                    likeRepository.UnLike(ut.get(),ans);
                                                }else {
                                                    System.out.println("the tweet not found");
                                                }
                                                break;
                                            case 12:
                                                System.out.println("enter tweet id : ");
                                                id = new Scanner(System.in).nextLong();
                                                Optional<Tweet> vt = tweetRepository.findById(id);
                                                if (vt.isPresent()){
                                                    tweetRepository.view(vt.get());
                                                }else {
                                                    System.out.println("the tweet not found");
                                                }
                                                break;
                                        }
                                        if (num == 13) {
                                            break;
                                        }
                                    }
                            }
                            if (num == 4 || num2 == 2) {
                                break;
                            }
                        }

                    } else {
                        throw new NoResultException("username or password is incorrect");
                    }
                    break;
                case 2:
                    Users users = new Users();
                    System.out.println("enter your first name : ");
                    value = new Scanner(System.in).nextLine();
                    users.setFirstname(value);
                    System.out.println("enter your last name : ");
                    value = new Scanner(System.in).nextLine();
                    users.setLastname(value);
                    System.out.print("Enter a date of birth [yyyy.MM.dd]: ");
                    value = new Scanner(System.in).nextLine();
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd");
                    LocalDate localDate = LocalDate.parse(value, dtf);
                    users.setDateOfBirth(localDate);
                    System.out.println("enter your username : ");
                    value = new Scanner(System.in).next();
                    users.setUsername(value);
                    System.out.println("enter your password(At least 8 characters) : ");
                    value = new Scanner(System.in).next();
                    users.setPassword(value);
                    userRepository.signUp(users);
                    break;
            }

        }
    }
}
