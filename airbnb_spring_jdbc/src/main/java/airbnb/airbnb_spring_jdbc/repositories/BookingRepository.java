package airbnb.airbnb_spring_jdbc.repositories;


import java.util.Date;
import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.jdbc.core.JdbcTemplate;
// import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import airbnb.airbnb_spring_jdbc.entities.Booking;



@Transactional
@Repository
public interface BookingRepository  extends JpaRepository<Booking, Long>{

    List<Booking> findByUserId(Long user_id);
    List<Booking> findByPropertyId(Long property_id);
    List<Booking> findByBookingDate(Date booking_date);
    List<Booking> findByPrice(Integer price);
    List<Booking> findByUserIdAndPropertyId(Long user_id, Long property_id);
    List<Booking> findByUserIdAndBookingDate(Long user_id, Date booking_date);
    List<Booking> findByPropertyIdAndBookingDate(Long property_id, Date booking_date);

    // private final JdbcTemplate jdbcTemplate;
    // @Autowired
    // public BookingRepository(JdbcTemplate jdbcTemplate){
    //     this.jdbcTemplate = jdbcTemplate;
    // }
    
    // public List<Booking> getAll() {
    //     String sql = "SELECT * FROM [airbnb_spring_db].[dbo].[booking]";
    //     RowMapper<Booking> rowMapper = new BookingRowMapper();
    //     // run sql query, convert SQL data into Java objects using rowmapper
    //     return this.jdbcTemplate.query(sql, rowMapper);
    // }

    // public void addBooking (Booking booking){
    //     String sql = "INSERT INTO [airbnb_spring_db].[dbo].[booking] (price, booking_date, check_in, check_out, user_id, property_id) VALUES (?, ?, ?, ?, ?, ?)";
    //     jdbcTemplate.update(sql, booking.getPrice(), booking.getBooking_date(), booking.getCheck_in(), booking.getCheck_out(), booking.getUser_id(), booking.getProperty_id());

    //     String sql2 = "SELECT id FROM [airbnb_spring_db].[dbo].[booking] WHERE price = ? AND booking_date = ? AND check_in = ? AND check_out = ? AND user_id = ? AND property_id = ?";
    //     int bookingId = jdbcTemplate.queryForObject(sql2, Integer.class, booking.getPrice(), booking.getBooking_date(), booking.getCheck_in(), booking.getCheck_out(), booking.getUser_id(), booking.getProperty_id());

    //     booking.setId(bookingId);
    // }

    // public Booking getOne(int bookingId){
    //     String sql = "SELECT * FROM [airbnb_spring_db].[dbo].[booking] WHERE id = ?";
    //     RowMapper<Booking> rowMapper = new BookingRowMapper();
    //     return jdbcTemplate.queryForObject(sql, rowMapper, bookingId);
    // }

    // public void updateBooking(int bookingId, Booking booking){
    //     String sql = "UPDATE [airbnb_spring_db].[dbo].[booking] SET price = ? WHERE id = ?";
    //     jdbcTemplate.update(sql, booking.getPrice(), bookingId);

    // }

    // public void deleteBooking(int bookingId){
    //     String sql = "DELETE FROM [airbnb_spring_db].[dbo].[booking] WHERE id = ?";
    //     jdbcTemplate.update(sql, bookingId);
        
    // }

    // public Boolean bookingExists(int bookingId){
    //     String sql = "SELECT count(*) FROM [airbnb_spring_db].[dbo].[booking] WHERE id = ?";
    //     int count = jdbcTemplate.queryForObject(sql, Integer.class, bookingId);

    //     if(count == 0){
    //         return false;
    //     }
    //     else{
    //         return true;
    //     }
    // }
}