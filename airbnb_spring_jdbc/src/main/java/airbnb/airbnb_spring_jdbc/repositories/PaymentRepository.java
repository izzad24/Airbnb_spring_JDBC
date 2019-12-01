package airbnb.airbnb_spring_jdbc.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.jdbc.core.JdbcTemplate;
// import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import airbnb.airbnb_spring_jdbc.entities.Payment;

/**
 * PaymentRepository
 */
@Transactional
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long>{


    // private final JdbcTemplate jdbcTemplate;
    // @Autowired
    // public PaymentRepository(JdbcTemplate jdbcTemplate){
    //     this.jdbcTemplate = jdbcTemplate;
    // }
    
    // public List<Payment> getAll() {
    //     String sql = "SELECT * FROM [airbnb_spring_db].[dbo].[payment]";
    //     RowMapper<Payment> rowMapper = new PaymentRowMapper();
    //     // run sql query, convert SQL data into Java objects using rowmapper
    //     return this.jdbcTemplate.query(sql, rowMapper);
    // }

    // public void addPayment (Payment payment){
    //     String sql = "INSERT INTO [airbnb_spring_db].[dbo].[payment] (status, amount, booking_id) VALUES (?, ?, ?)";
    //     jdbcTemplate.update(sql, payment.getStatus(), payment.getAmount(), payment.getBooking_id());

    //     String sql2 = "SELECT id FROM [airbnb_spring_db].[dbo].[payment] WHERE status = ? AND amount = ? AND booking_id = ?";
    //     int paymentId = jdbcTemplate.queryForObject(sql2, Integer.class, payment.getStatus(), payment.getAmount(), payment.getBooking_id());

    //     payment.setId(paymentId);
    // }

    // public Payment getOne(int paymentId){
    //     String sql = "SELECT * FROM [airbnb_spring_db].[dbo].[payment] WHERE id = ?";
    //     RowMapper<Payment> rowMapper = new PaymentRowMapper();
    //     return jdbcTemplate.queryForObject(sql, rowMapper, paymentId);
    // }

    // public void updatePayment(int paymentId, Payment payment){
    //     String sql = "UPDATE [airbnb_spring_db].[dbo].[payment] SET status = ?, amount = ? WHERE id = ?";
    //     jdbcTemplate.update(sql, payment.getStatus(), payment.getStatus(), paymentId);

    // }

    // public void deletePayment(int paymentId){
    //     String sql = "DELETE FROM [airbnb_spring_db].[dbo].[payment] WHERE id = ?";
    //     jdbcTemplate.update(sql, paymentId);
        
    // }

    // public Boolean paymentExists(int paymentId){
    //     String sql = "SELECT count(*) FROM [airbnb_spring_db].[dbo].[payment] WHERE id = ?";
    //     int count = jdbcTemplate.queryForObject(sql, Integer.class, paymentId);

    //     if(count == 0){
    //         return false;
    //     }
    //     else{
    //         return true;
    //     }
    // }
}