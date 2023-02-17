package com.bookmyshow.BMS.model;

import lombok.Getter;
import lombok.Setter;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long movieId;
    @Column(name = "moviename")
    private String moviename;

    @Column(name = "description")
    private String description;

    @Column(name = "genre")
    private long genre;



}
