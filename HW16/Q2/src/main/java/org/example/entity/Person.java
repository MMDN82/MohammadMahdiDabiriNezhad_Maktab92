package org.example.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.base.entity.BaseEntity;

import java.time.LocalDate;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Person extends BaseEntity<Long> {
    @Column(nullable = false)
    private String name;
    private String family;
    private LocalDate birthDate;

}
