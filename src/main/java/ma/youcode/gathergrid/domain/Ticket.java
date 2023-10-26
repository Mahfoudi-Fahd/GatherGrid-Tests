package ma.youcode.gathergrid.domain;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity
@Table(name = "tickets")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private float price;
    @Column(name = "quantity",columnDefinition = "int default 1")
    private int quantity;

    @Column(name = "ticket_type")
    @Enumerated(EnumType.STRING)
    private TicketType ticketType;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @ManyToOne
    private User user;

    @Column(name = "reservation_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date reservationDate;
}
