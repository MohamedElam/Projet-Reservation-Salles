package ma.emsi.reservationservice.bean;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.emsi.reservationservice.model.Client;
import ma.emsi.reservationservice.model.Salle;

import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Reservation {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date dateReservation;

    @Temporal(TemporalType.TIME)
    private Date startHour;

    @Temporal(TemporalType.TIME)
    private Date endHour;

    private Long client_id;
    @Transient
    private Client client;
    private Long salle_id;
    @Transient
    private Salle salle;

}
