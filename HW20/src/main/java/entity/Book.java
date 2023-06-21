package entity;

import base.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class Book extends BaseEntity<Long> {
    private String name;
    private String author;
    @Column(name = "date_of_print")
    private LocalDate dateOfPrint;
    private Long inventory;

}
