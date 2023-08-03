package entity;

import base.entity.BaseEntity;
import entity.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Orders extends BaseEntity<Long> {
    @Enumerated(EnumType.STRING)
    @Column(name = "order_status")
    private OrderStatus orderStatus = OrderStatus.WAITING_FOR_EXPERTS_OFFER;
    @Column(name = "proposed_price")
    private Long proposedPrice;
    @Column(name = "work_description")
    private String workDescription;
    @Column(name = "date_of_work")
    private LocalDate dateOfWork;
    private String address;
    @ManyToOne
    private Expert expert;
    @ManyToOne
    private SubService subService;
    @ManyToOne
    private Customer customer;
    @Column(name = "expert_rate")
    private int expertRate;
}
