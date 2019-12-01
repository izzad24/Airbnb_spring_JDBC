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

    @GetMapping(value = "/properties")
    public List<Property> index(){
        return repo.findAll();
    }

    @PostMapping(value = "/properties")
    public Property create(@RequestBody Property property) {
        repo.save(property);
        return property;
    }

    @GetMapping(value = "/properties/{id}")
    public Property show(@PathVariable("id") Long id){
        Property property = repo.findById(id).orElse(null);
        return property;
    }

    @PostMapping(value = "/properties/{id}")
    public void update(@PathVariable("id") Long id, @RequestBody Property newProperty){
        Property property = repo.findById(id).orElse(null);

        if(property != null){
            property.setAddress(newProperty.getAddress());
            property.setOwner_id(newProperty.getOwner_id());

            repo.save(property);
        }
    }
    
    @DeleteMapping(value = "/properties/{id}")
    public void delete(@PathVariable("id") Long id){
        // Property property = repo.findById(id).orElse(null);

        repo.deleteById(id);
        // if(property != null){
        //     repo.delete(property);
        //     return "Property deleted";
        // }
        // else{
        //     return "Property not found";
        // }
    }
}