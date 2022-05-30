package com.springCoupon.Entities;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "customers")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(of = "customerId")
@ToString(of = {"customerId", "firstName", "lastName"})
public class Customer {


    @Id
    @GeneratedValue
    private int customerId;

    private String firstName;

    private String lastName;
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    private List<Coupon> coupons = new ArrayList<Coupon>();


}




