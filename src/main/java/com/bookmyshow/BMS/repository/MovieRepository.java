package com.bookmyshow.BMS.repository;

import com.bookmyshow.BMS.model.Movie;
import com.bookmyshow.BMS.model.Theatre;
import com.bookmyshow.BMS.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  MovieRepository extends JpaRepository<Movie,Long> {
}