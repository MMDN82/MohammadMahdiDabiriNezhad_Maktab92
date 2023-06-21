package entity;

import base.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class Request extends BaseEntity<Long> {
    @ManyToOne
    private Member member;
    @ManyToOne
    private Book book;
    @Column(name = "type_of_application")
    TypeOfApplication typeOfApplication;
    @Column(name = "request_status")
    RequestStatus requestStatus = RequestStatus.not_confirmed;

    public void setRequestStatus(RequestStatus requestStatus) {
        this.requestStatus = requestStatus;
    }
}
