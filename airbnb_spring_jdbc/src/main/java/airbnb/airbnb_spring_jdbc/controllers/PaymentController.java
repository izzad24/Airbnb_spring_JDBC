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

import airbnb.airbnb_spring_jdbc.entities.Payment;
import airbnb.airbnb_spring_jdbc.repositories.PaymentRepository;





/**
 * PaymentController
 */
@RestController
public class PaymentController {

    @Autowired
    PaymentRepository repo;

    @GetMapping(value = "/payments")
    public List<Payment> index(){
        return repo.findAll();
    }

    @PostMapping(value = "/payments")
    public Payment create(@RequestBody Payment payment) {
        repo.save(payment);
        return payment;
    }

    @GetMapping(value = "/payments/{id}")
    public Payment show(@PathVariable("id") Long id){
        Payment payment = repo.findById(id).orElse(null);
        return payment;
    }

    @PutMapping(value = "/payments/{id}")
    public void update(@PathVariable("id") Long id, @RequestBody Payment newPayment){
        Payment payment = repo.findById(id).orElse(null);

        if(payment != null){
            payment.setAmount(newPayment.getAmount());
            payment.setStatus(newPayment.getStatus());

            repo.save(payment);
        }
    }
    
    @DeleteMapping(value = "/payments/{id}")
    public String delete(@PathVariable("id") Long id){

        Payment payment = repo.findById(id).orElse(null);

        if(payment != null){
            repo.delete(payment);
            return "Payment deleted";
        }
        else{
            return "Payment not found";
        }
    }
}