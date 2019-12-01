package airbnb.airbnb_spring_jdbc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import airbnb.airbnb_spring_jdbc.entities.Property;
import airbnb.airbnb_spring_jdbc.repositories.PropertyRepository;






/**
 * PropertyController
 */
@RestController
public class PropertyController {

    @Autowired
    PropertyRepository repo;

    // @GetMapping(value = "/properties")
    // public List<Property> index(){
    //     return repo.getAll();
    // }

    // @PostMapping(value = "/properties")
    // public Property create(@RequestBody Property property) {
    //     repo.addProperty(property);
    //     return property;
    // }

    // @GetMapping(value = "/properties/{id}")
    // public Property show(@PathVariable("id") int id){
    //     Property property = repo.getOne(id);
    //     return property;
    // }

    // @PostMapping(value = "/properties/{id}")
    // public void update(@PathVariable("id") int id, @RequestBody Property property){
    //     repo.updateProperty(id, property);
    // }
    
    // @DeleteMapping(value = "/properties/{id}")
    // public String delete(@PathVariable("id") int id){
    //     if(repo.propertyExists(id)){
    //         repo.deleteProperty(id);
    //         return "Property deleted";
    //     }
    //     else{
    //         return "Property not found";
    //     }
    // }
}