package com.bookmyshow.BMS.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Getter
@Setter
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "id")
    private String booking_id;

    @Column(name = "time")
    private Date booking_time;

    @Column(name = "price")
    private Long booking_price;
}
