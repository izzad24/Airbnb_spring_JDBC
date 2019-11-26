package airbnb.airbnb_spring_jdbc.entities;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * PaymentRowMapper
 */
public class PaymentRowMapper implements RowMapper<Payment>{
    @Override
    public Payment mapRow(ResultSet row, int rowNum) throws SQLException{
        Payment x = new Payment();
        x.setId(row.getInt("id"));
        x.setStatus(row.getBoolean("status"));
        x.setAmount(row.getInt("amount"));
        x.setCreated_at(row.getTimestamp("created_at"));
        x.setUpdated_at(row.getTimestamp("updated_at"));
        x.setBooking_id(row.getInt("booking_id"));
        return x;
    }

    
}