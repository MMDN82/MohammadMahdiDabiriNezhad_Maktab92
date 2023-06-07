package repository;

import base.repository.BaseRepository;
import entity.Tweet;
import entity.Users;

import java.util.Optional;

public interface UserRepository extends BaseRepository<Users,Long> {
    Optional<Users> findByUsername(String username);
    void signUp(Users user);
    String deleteUser(Users users);
}
