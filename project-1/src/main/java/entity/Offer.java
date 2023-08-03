package entity;

import base.entity.BaseEntity;
import base.service.impl.BaseServiceImpl;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Offer extends BaseEntity<Long> {
    @ManyToOne
    private Orders orders;
    @Column(name = "date_of_registration")
    private LocalDate dateOfRegistration=LocalDate.now();
    private Long offerPrice;
    @Column(name = "offer_date")
    private LocalDate offerDate;
    @Column(name = "duration_of_work")
    private String durationOfWork;
}
