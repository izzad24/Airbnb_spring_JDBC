package airbnb.airbnb_spring_jdbc.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import airbnb.airbnb_spring_jdbc.entities.Booking;
import airbnb.airbnb_spring_jdbc.repositories.BookingRepository;



/**
 * BookingController
 */
@RestController
public class BookingController {

    @Autowired
    BookingRepository repo;

    @GetMapping(value = "/bookings")
    public List<Booking> index(
        @RequestParam(name = "user_id", required = false) Long user_id,
        @RequestParam(name = "property_id", required = false) Long property_id,
        @RequestParam(name = "booking_date", required = false) @DateTimeFormat(pattern = "MMddyyyy") Date booking_date,
        @RequestParam(name = "price", required = false) Integer price
    ){
        if(user_id != null && property_id !=null){
            return repo.findByUserIdAndPropertyId(user_id, property_id);
        }else if(user_id != null && booking_date !=null){
            return repo.findByUserIdAndBookingDate(user_id, booking_date);
        }else if(property_id != null && booking_date !=null){
            return repo.findByPropertyIdAndBookingDate(property_id, booking_date);
        }else if(user_id != null){
            return repo.findByUserId(user_id);
        }else if(property_id != null){
            return repo.findByPropertyId(property_id);
        }else if(price != null){
            return repo.findByPrice(price);
        }else if(booking_date != null){
            return repo.findByBookingDate(booking_date);
        }

        return repo.findAll();
    }

    @PostMapping(value = "/bookings")
    public Booking create(@RequestBody Booking booking) {
        repo.save(booking);
        return booking;
    }

    @GetMapping(value = "/bookings/{id}")
    public Booking show(@PathVariable("id") Long id){
        return repo.findById(id).orElse(null);
    }

    @PutMapping(value = "/bookings/{id}")
    public void update(@PathVariable("id") Long id, @RequestBody Booking newBooking){
        Booking booking = repo.findById(id).orElse(null);

        if(booking != null){
            booking.setBookingDate(newBooking.getBookingDate());
            booking.setCheck_in(newBooking.getCheck_in());
            booking.setCheck_out(newBooking.getCheck_out());
            booking.setPrice(newBooking.getPrice());
            booking.setPropertyId(newBooking.getPropertyId());
            booking.setUserId(newBooking.getUserId());

            repo.save(booking);
        }
    }
    
    @DeleteMapping(value = "/bookings/{id}")
    public String delete(@PathVariable("id") Long id){
       
        Booking booking = repo.findById(id).orElse(null);

        if(booking != null){
            repo.delete(booking);
            return "Sucessfully deleted booking data";
        } else {
            return "Booking id could not be found";
        }
    }
}