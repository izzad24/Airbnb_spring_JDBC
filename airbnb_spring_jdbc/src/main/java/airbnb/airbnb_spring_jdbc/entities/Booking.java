package airbnb.airbnb_spring_jdbc.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * Booking
 */
@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnoreProperties("booking")
    @OneToMany(mappedBy = "booking")
    private Set<Payment> payments;

    @Column(name = "price")
    private int price;

    @Column(name = "booking_date")
    private Date bookingDate;

    @Column(name = "check_in")
    private Date check_in;

    @Column(name = "check_out")
    private Date check_out;

    @JsonIgnore
    @Column(name = "user_id", insertable = false, updatable = false)
    private Long userId;

    @JsonIgnore
    @Column(name = "property_id", insertable = false, updatable = false)
    private Long propertyId;

    @JsonIgnoreProperties("booking")
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @JsonIgnoreProperties("booking")
    @ManyToOne
    @JoinColumn(name = "property_id")
    private Property property;

    @Column(name = "created_at")
    private Date created_at;

    @Column(name = "updated_at")
    private Date updated_at;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public Date getBookingDate() {
        return this.bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }


    public Date getCheck_in() {
        return this.check_in;
    }

    public void setCheck_in(Date check_in) {
        this.check_in = check_in;
    }

    public Date getCheck_out() {
        return this.check_out;
    }

    public void setCheck_out(Date check_out) {
        this.check_out = check_out;
    }


    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPropertyId() {
        return this.propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }
    

    public Date getCreated_at() {
        return this.created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return this.updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

}