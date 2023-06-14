package entity;

import Base.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class Coach extends BaseEntity<Long> {
    private String firstname;
    private String lastname;
    private LocalDate dateOfBirth;
    private Long price;
    @OneToOne
    private Team team;
}
