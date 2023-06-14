package entity;

import Base.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class Player extends BaseEntity<Long> {
    private String firstname;
    private String lastname;
    private LocalDate dateOfBirth;
    private Long price;
    @ManyToOne
    private Team team;

}
