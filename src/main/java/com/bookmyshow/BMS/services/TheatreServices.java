package com.bookmyshow.BMS.services;

import com.bookmyshow.BMS.model.Theatre;
import com.bookmyshow.BMS.model.User;

import java.util.List;

public interface TheatreServices {
    Theatre createTheatre(Theatre theatre);
    Theatre updateTheatre(Theatre theatre);
    List<Theatre> getAllTheatre();
    Theatre getTheatreById(long id );
    void deleteTheatre(long id);
}
