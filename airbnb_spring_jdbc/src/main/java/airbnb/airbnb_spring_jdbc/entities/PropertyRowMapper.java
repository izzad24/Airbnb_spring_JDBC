package airbnb.airbnb_spring_jdbc.entities;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * PropertyRowMapper
 */
public class PropertyRowMapper implements RowMapper<Property> {
    @Override
    public Property mapRow(ResultSet row, int rowNum) throws SQLException{
        Property x = new Property();
        x.setId(row.getInt("id"));
        x.setAddress(row.getString("address"));
        x.setOwner_id(row.getInt("owner_id"));
        x.setCreated_at(row.getDate("created_at"));
        x.setUpdated_at(row.getDate("updated_at"));

        return x;
    }

    
}