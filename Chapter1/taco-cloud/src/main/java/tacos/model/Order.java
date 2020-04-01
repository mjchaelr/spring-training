package tacos.model;
import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.CreditCardNumber;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="Taco_Order")
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column(name="PLACEDAT")
    private Date placedAt;

    @ManyToOne
    private User user;

    //end::allButValidation[]
    @NotBlank(message="Name is required")
    private String deliveryName;
    //end::allButValidation[]

    @NotBlank(message="Street is required")
    private String deliveryStreet;
    //end::allButValidation[]

    @NotBlank(message="City is required")
    private String deliveryCity;
    //end::allButValidation[]

    @NotBlank(message="State is required")
    private String deliveryState;
    //end::allButValidation[]

    @NotBlank(message="Zip code is required")
    private String deliveryZip;
    //end::allButValidation[]

    @CreditCardNumber(message="Not a valid credit card number")
    //tag::allButValidation[]
    @Column(name="CCNUMBER")
    private String ccNumber;
    //end::allButValidation[]

    @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",
            message="Must be formatted MM/YY")
    //tag::allButValidation[]
    @Column(name="CCEXPIRATION")
    private String ccExpiration;
    //end::allButValidation[]

    @Digits(integer=3, fraction=0, message="Invalid CVV")
    //tag::allButValidation[]
    private String ccCVV;

    @ManyToMany(targetEntity=Taco.class)
    private List<Taco> tacos = new ArrayList<>();
    public void addDesign(Taco design) {
        this.tacos.add(design);
    }
    @PrePersist
    void placedAt() {
        this.placedAt = new Date();
    }
}