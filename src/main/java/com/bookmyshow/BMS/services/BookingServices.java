package com.bookmyshow.BMS.services;

import com.bookmyshow.BMS.model.Booking;
import com.bookmyshow.BMS.model.Movie;
import com.bookmyshow.BMS.model.Theatre;
import com.bookmyshow.BMS.model.User;

import java.util.List;

public interface BookingServices {
    Booking createBooking(Booking booking);
    List<Booking> getAllBooking();
    Booking getBookingId(long id );
    void cancelBooking(long id);
}
