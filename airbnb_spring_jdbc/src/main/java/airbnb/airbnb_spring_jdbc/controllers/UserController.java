package airbnb.airbnb_spring_jdbc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import airbnb.airbnb_spring_jdbc.entities.User;
import airbnb.airbnb_spring_jdbc.repositories.UserRepository;

/**
 * UserController
 */
@RestController
public class UserController {

    @Autowired
    UserRepository userRepo;

    @GetMapping(value = "/users")
    public List<User> index(){
        return userRepo.getAll();
    }

    @PostMapping(value = "/users")
    public User create(@RequestBody User user) {
        userRepo.addUser(user);
        return user;
    }

    @GetMapping(value = "/users/{id}")
    public User show(@PathVariable("id") int id){
        User user = userRepo.getOne(id);
        return user;
    }

    @PostMapping(value = "/users/{id}")
    public void update(@PathVariable("id") int id, @RequestBody User user){
        userRepo.updateUser(id, user);
    }
    
    @DeleteMapping(value = "/users/{id}")
    public String delete(@PathVariable("id") int id){
        if(userRepo.userExists(id)){
            userRepo.deleteUser(id);
            return "User deleted";
        }
        else{
            return "User not found";
        }
    }
}