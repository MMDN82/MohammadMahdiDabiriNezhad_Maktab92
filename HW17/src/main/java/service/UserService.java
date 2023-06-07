package service;

import entity.Users;
import repository.LikeRepository;
import repository.impl.LikeRepositoryImpl;

import java.util.List;
import java.util.Optional;
import java.util.Queue;

public interface UserService {
    String searchByUsername(String user);

}
