package entity;

import Base.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class Match extends BaseEntity<Long> {
    @ManyToOne
    private Team teamOne;
    @ManyToOne
    private Team teamTwo;
    @ManyToOne
    private Stadium stadium;
    private Long teamOneGoal;
    private Long teamTwoGoal;
    @ManyToOne
    private Team winner;
    private Boolean isDraw;
    @Transient
    private List<Player> playersScore;

}
