package service.impl;

import entity.Users;
import jakarta.persistence.NoResultException;
import org.hibernate.Session;
import repository.UserRepository;
import repository.impl.UserRepositoryImpl;
import service.UserService;
import utill.HibernateUtil;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Queue;

public class UserServiceImpl implements UserService {
    private Session session = HibernateUtil.getSessionFactory().openSession();
    private UserRepository userRepository = new UserRepositoryImpl(session);




    @Override
    public String searchByUsername(String user) {
          Optional<Users> ans = userRepository.findByUsername(user);
            if (ans.isPresent()) {
                String ans1 = "firstname : " + ans.get().getFirstname() + "\n" +
                        "lastname : " + ans.get().getLastname() + "\n" +
                        "date of birth : " + ans.get().getDateOfBirth() + "\n" +
                        "username : " + ans.get().getUsername();
                return ans1;
            }
        return user;
    }
}
