package airbnb.airbnb_spring_jdbc.repositories;

import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.jdbc.core.JdbcTemplate;
// import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import airbnb.airbnb_spring_jdbc.entities.Property;




@Transactional
@Repository
public class PropertyRepository {
    // private final JdbcTemplate jdbcTemplate;
    // @Autowired
    // public PropertyRepository(JdbcTemplate jdbcTemplate){
    //     this.jdbcTemplate = jdbcTemplate;
    // }
    
    // public List<Property> getAll() {
    //     String sql = "SELECT * FROM [airbnb_spring_db].[dbo].[property]";
    //     RowMapper<Property> rowMapper = new PropertyRowMapper();
    //     // run sql query, convert SQL data into Java objects using rowmapper
    //     return this.jdbcTemplate.query(sql, rowMapper);
    // }

    // public void addProperty (Property property){
    //     String sql = "INSERT INTO [airbnb_spring_db].[dbo].[property] (address, owner_id) VALUES (?, ?)";
    //     jdbcTemplate.update(sql, property.getAddress(), property.getOwner_id());

    //     String sql2 = "SELECT id FROM [airbnb_spring_db].[dbo].[property] WHERE address = ? AND owner_id = ?";
    //     int propertyId = jdbcTemplate.queryForObject(sql2, Integer.class, property.getAddress(), property.getOwner_id());

    //     property.setId(propertyId);
    // }

    // public Property getOne(int propertyId){
    //     String sql = "SELECT * FROM [airbnb_spring_db].[dbo].[property] WHERE id = ?";
    //     RowMapper<Property> rowMapper = new PropertyRowMapper();
    //     return jdbcTemplate.queryForObject(sql, rowMapper, propertyId);
    // }

    // public void updateProperty(int propertyId, Property property){
    //     String sql = "UPDATE [airbnb_spring_db].[dbo].[property] SET address = ? WHERE id = ?";
    //     jdbcTemplate.update(sql, property.getAddress(), propertyId);

    // }

    // public void deleteProperty(int propertyId){
    //     String sql = "DELETE FROM [airbnb_spring_db].[dbo].[property] WHERE id = ?";
    //     jdbcTemplate.update(sql, propertyId);
        
    // }

    // public Boolean propertyExists(int propertyId){
    //     String sql = "SELECT count(*) FROM [airbnb_spring_db].[dbo].[property] WHERE id = ?";
    //     int count = jdbcTemplate.queryForObject(sql, Integer.class, propertyId);

    //     if(count == 0){
    //         return false;
    //     }
    //     else{
    //         return true;
    //     }
    // }
}