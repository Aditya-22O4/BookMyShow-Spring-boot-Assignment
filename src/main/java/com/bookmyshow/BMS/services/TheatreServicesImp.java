package com.bookmyshow.BMS.services;

import com.bookmyshow.BMS.model.Theatre;
import com.bookmyshow.BMS.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TheatreServicesImp implements TheatreServices{

    @Autowired
    private TheatreRepository theatreRepository;


    @Override
    public Theatre createTheatre(Theatre theater) {
        return theatreRepository.save(theater);
    }

    @Override
    public Theatre updateTheatre(Theatre theatre) {
        Optional<Theatre> theatreObj = this.theatreRepository.findById(theatre.getTheatre_id());
        if(theatreObj.isPresent()){
            Theatre theatreUpdate = theatreObj.get();
            theatreUpdate.setTheatre_id(theatre.getTheatre_id());
            theatreUpdate.setTheatre_name(theatre.getTheatre_name());
            theatreUpdate.setCity(theatre.getCity());
            return this.theatreRepository.save(theatreUpdate);
        }else {
            throw new RuntimeException("No Theater found with + " + theatre.getTheatre_id());
        }
    }

    @Override
    public List<Theatre> getAllTheatre() {
        return this.theatreRepository.findAll();
    }

    @Override
    public Theatre getTheatreById(long theatreid) {
        Optional<Theatre> theaterObj = this.theatreRepository.findById(theatreid);
        if(theaterObj.isPresent()){
            return theaterObj.get();
        }
        else {
            throw new RuntimeException("No theatre found with id " + theatreid);
        }
    }

    @Override
    public void deleteTheatre(long theatreid) {
        Optional<Theatre> theatreObj = this.theatreRepository.findById(theatreid);
        if(theatreObj.isPresent()){
            theatreRepository.delete(getTheatreById(theatreid));
        }
        else {
            throw new RuntimeException("No Theatre  found with id " + theatreid);
        }
    }
}