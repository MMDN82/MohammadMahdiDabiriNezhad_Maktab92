package repository;

import base.repository.BaseRepository;
import entity.Comment;
import entity.Users;

import java.util.List;

public interface CommentRepository extends BaseRepository<Comment,Long> {
    List<Comment> yourComments(Users user);
}
