package entity;

import base.entity.Person;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@ToString
public class Member extends Person {
    @Column(name = "membership_code")
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long membershipCode;
}
