package com.project.EcommerceWebsite.models;

import jakarta.persistence.*;
import lombok.*;

import java.text.DateFormat;
import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer productid;
    private Float price;
    private Integer userid;
    private Date dateadded;

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", productid=" + productid +
                ", price=" + price +
                ", userid=" + userid +
                ", dateadded=" + dateadded +
                '}';
    }
}
