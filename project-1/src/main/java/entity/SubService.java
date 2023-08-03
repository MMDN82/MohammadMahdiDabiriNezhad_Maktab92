package entity;

import base.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class SubService extends BaseEntity<Long> {
    @Column(name = "sub_service")
    private String subService;
    @Column(name = "base_price")
    private Long BasePrice;
    @ManyToOne
    private Service service;
    private String description;
}
