package airbnb.airbnb_spring_jdbc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    // @GetMapping(value = "/bookings")
    // public List<Booking> index(){
    //     return repo.getAll();
    // }

    // @PostMapping(value = "/bookings")
    // public Booking create(@RequestBody Booking booking) {
    //     repo.addBooking(booking);
    //     return booking;
    // }

    // @GetMapping(value = "/bookings/{id}")
    // public Booking show(@PathVariable("id") int id){
    //     Booking booking = repo.getOne(id);
    //     return booking;
    // }

    // @PostMapping(value = "/bookings/{id}")
    // public void update(@PathVariable("id") int id, @RequestBody Booking booking){
    //     repo.updateBooking(id, booking);
    // }
    
    // @DeleteMapping(value = "/bookings/{id}")
    // public String delete(@PathVariable("id") int id){
    //     if(repo.bookingExists(id)){
    //         repo.deleteBooking(id);
    //         return "Booking deleted";
    //     }
    //     else{
    //         return "Booking not found";
    //     }
    // }
}