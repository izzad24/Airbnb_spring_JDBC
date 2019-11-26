package airbnb.airbnb_spring_jdbc.entities;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * BookingRowMapper
 */
public class BookingRowMapper implements RowMapper<Booking> {
    @Override 
    public Booking mapRow(ResultSet row, int rowNum) throws SQLException{
        Booking x = new Booking();
        // for each column in the DB, set 1 property on the java object
        // use getInt / getString / getBoolean depending on the column type in the DB
        x.setId(row.getInt("id"));
        x.setPrice(row.getInt("price"));
        x.setBooking_date(row.getDate("booking_date"));
        x.setCheck_in(row.getTimestamp("check_in"));
        x.setCheck_out(row.getTimestamp("check_out"));
        x.setCreated_at(row.getTimestamp("created_at"));
        x.setUpdated_at(row.getTimestamp("updated_at"));
        x.setUser_id(row.getInt("user_id"));
        x.setProperty_id(row.getInt("property_id"));
        return x;
    }

    
}