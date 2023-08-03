package entity;

import base.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@MappedSuperclass
public class Person extends BaseEntity<Long> {
    private String firstName;
    private String lastName;
    private String password;
}
