package airbnb.airbnb_spring_jdbc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
        return userRepo.findAll();
    }

    @PostMapping(value = "/users")
    public User create(@RequestBody User user) {
        userRepo.save(user);
        return user;
    }

    @GetMapping(value = "/users/{id}")
    public User show(@PathVariable("id") Long id){
        User user = userRepo.findById(id).orElse(null);
        return user;
    }

    @PutMapping(value = "/users/{id}")
    public void update(@PathVariable("id") Long id, @RequestBody User newUser){
        User user = userRepo.findById(id).orElse(null);

        if(user != null){
            user.setName(newUser.getName());
            user.setContact_no(newUser.getContact_no());
        }
    }
    
    @DeleteMapping(value = "/users/{id}")
    public void delete(@PathVariable("id") Long id){
        
        userRepo.deleteById(id);
    }
}