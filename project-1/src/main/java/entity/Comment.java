package entity;

import base.entity.BaseEntity;
import base.service.impl.BaseServiceImpl;
import exceptions.ExpertException;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Comment extends BaseEntity<Long> {
    private String comment;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Expert expert;
    private int rate;
}
