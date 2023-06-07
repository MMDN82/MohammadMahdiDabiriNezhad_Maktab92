package repository;

import base.repository.BaseRepository;
import entity.Tweet;
import entity.Users;

public interface TweetRepository extends BaseRepository<Tweet,Long> {
    String view(Tweet tweet);
    String yourTweet(Users users);
    String deleteTweet(Tweet tweet);
}
