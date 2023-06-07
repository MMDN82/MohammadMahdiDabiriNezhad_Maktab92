package repository;

import base.repository.BaseRepository;
import entity.Likes;
import entity.Tweet;
import entity.Users;

public interface LikeRepository extends BaseRepository<Likes,Long> {
     void like(Tweet tweet,Users users );
    void UnLike(Tweet tweet,Users users );

}
