package com.bookmyshow.BMS.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Data
@Getter
@Setter
@Table(name = "theatre")
public class Theatre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "city")
    private String city;

    @Column(name = "name")
    private String theatre_name;

    @Column(name = "id")
    private Long theatre_id;

    @Column(name = "address")
    private String theatre_address;
}
