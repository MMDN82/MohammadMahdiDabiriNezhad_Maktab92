package entity;

import Base.entity.BaseEntity;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Embeddable
@ToString
public class Stadium extends BaseEntity<Long> {
    private String name;
    @ManyToOne
    private City city;
}
