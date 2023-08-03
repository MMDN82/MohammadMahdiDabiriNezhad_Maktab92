package entity;

import base.entity.BaseEntity;
import jakarta.persistence.Entity;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class Service extends BaseEntity<Long> {
    private String Service;
}
