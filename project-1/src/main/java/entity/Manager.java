package entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Manager extends Person{
    @Column(name = "manager_id")
    private Long managerId;
}
