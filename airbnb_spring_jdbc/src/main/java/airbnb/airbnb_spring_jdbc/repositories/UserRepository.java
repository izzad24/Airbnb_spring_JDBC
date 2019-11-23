package airbnb.airbnb_spring_jdbc.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import airbnb.airbnb_spring_jdbc.entities.User;
import airbnb.airbnb_spring_jdbc.entities.UserRowMapper;

/**
 * UserRepository
 */
@Transactional
@Repository
public class UserRepository {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public UserRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public List<User> getAll() {
        String sql = "SELECT * FROM [airbnb_spring_db].[dbo].[user]";
        RowMapper<User> rowMapper = new UserRowMapper();
        // run sql query, convert SQL data into Java objects using rowmapper
        return this.jdbcTemplate.query(sql, rowMapper);
    }

    public void addUser (User user){
        String sql = "INSERT INTO [airbnb_spring_db].[dbo].[user] (name, contact_no, created_at, updated_at) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, user.getName(), user.getContact_no(), user.getCreated_at(), user.getUpdated_at());

        String sql2 = "SELECT id FROM [airbnb_spring_db].[dbo].[user] WHERE name = ? AND contact_no = ? AND created_at = ? AND updated_at = ?";
        int userId = jdbcTemplate.queryForObject(sql2, Integer.class, user.getName(), user.getContact_no(), user.getCreated_at(), user.getUpdated_at());

        user.setId(userId);
    }

    public User getOne(int userId){
        String sql = "SELECT * FROM [airbnb_spring_db].[dbo].[user] WHERE id = ?";
        RowMapper<User> rowMapper = new UserRowMapper();
        return jdbcTemplate.queryForObject(sql, rowMapper, userId);
    }

    public void updateUser(int userId, User user){
        String sql = "UPDATE [airbnb_spring_db].[dbo].[user] SET name = ?, contact_no = ? WHERE id = ?";
        jdbcTemplate.update(sql, user.getName(), user.getContact_no(), userId);

    }

    public void deleteUser(int userId){
        String sql = "DELETE FROM [airbnb_spring_db].[dbo].[user] WHERE id = ?";
        jdbcTemplate.update(sql, userId);
        
    }

    public Boolean userExists(int userId){
        String sql = "SELECT count(*) FROM [airbnb_spring_db].[dbo].[user] WHERE ID = ?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, userId);

        if(count == 0){
            return false;
        }
        else{
            return true;
        }
    }
}