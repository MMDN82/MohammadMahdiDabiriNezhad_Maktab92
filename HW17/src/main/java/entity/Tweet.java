package entity;


import base.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class Tweet extends BaseEntity<Long> {
    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Include
    private Users user;
    private String tweet;



    public void setTweet(String tweet) {
        if (tweet.length() < 280) {
            this.tweet = tweet;
        } else throw new RuntimeException("The tweet must contain a maximum of 280 characters");
    }
}
