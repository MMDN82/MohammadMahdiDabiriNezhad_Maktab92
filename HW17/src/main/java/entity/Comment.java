package entity;

import base.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class Comment extends BaseEntity<Long> {
    private String comment;
    @ManyToOne
    private Tweet tweet;
    @ManyToOne
    private Users users;
}
