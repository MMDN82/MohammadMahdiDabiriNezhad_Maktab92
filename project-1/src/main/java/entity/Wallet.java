package entity;

import base.entity.BaseEntity;
import jakarta.persistence.Entity;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Wallet extends BaseEntity<Long> {
    private Long inventory;
}
