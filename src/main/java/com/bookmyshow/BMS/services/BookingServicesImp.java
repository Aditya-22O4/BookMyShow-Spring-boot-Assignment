package com.bookmyshow.BMS.services;

import com.bookmyshow.BMS.model.Booking;
import com.bookmyshow.BMS.model.Movie;
import com.bookmyshow.BMS.model.Theatre;
import com.bookmyshow.BMS.repository.BookingRepository;
import com.bookmyshow.BMS.repository.MovieRepository;
import com.bookmyshow.BMS.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookingServicesImp implements BookingServices{

    @Autowired
    private BookingRepository bookingRepository;


    @Override
    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> getAllBooking() {
        return this.bookingRepository.findAll();
    }

    @Override
    public  Booking getBookingId(long bookingid) {
        Optional<Booking> bookingObj = this.bookingRepository.findById(bookingid);
        if(bookingObj.isPresent()){
            return bookingObj.get();
        }
        else {
            throw new RuntimeException("No booking found with id " + bookingid);
        }
    }

    @Override
    public void cancelBooking(long bookingid) {
        Optional<Booking> bookingObj = this.bookingRepository.findById(bookingid);
        if(bookingObj.isPresent()){
            bookingRepository.delete(getBookingId(bookingid));
        }
        else {
            throw new RuntimeException("No booking  found with id " + bookingid);
        }
    }
}