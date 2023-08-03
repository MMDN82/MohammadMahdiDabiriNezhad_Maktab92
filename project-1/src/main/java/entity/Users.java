package entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@MappedSuperclass
public class Users extends Person {
    private String mail;
    @Column(name = "date_of_join")
    private LocalDate dateOfJoin;
}
