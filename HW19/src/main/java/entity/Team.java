package entity;

import Base.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class Team extends BaseEntity<Long> {
    @Column(name = "team_id")
    private Long TeamId;
    private String name;
    @ManyToOne
    private City city;
}
