package entity;

import base.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class Likes extends BaseEntity<Long>{
    @ManyToOne
    private Tweet tweet;
    @ManyToOne
    private Users User;
}
