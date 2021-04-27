package com.example.demo.model;
import com.example.demo.model.enumeration.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.time.ZonedDateTime;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(schema = "sale_ads", name = "sales")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_date")
    private ZonedDateTime startDate;

    @Column(name = "end_date")
    private ZonedDateTime endDate;

    @Enumerated
    @Column(name = "status_id")
    private Status status;


    @ManyToOne
    @JoinColumn(name = "market_id")
    private Market market;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;
}
