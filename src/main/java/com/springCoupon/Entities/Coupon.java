package com.springCoupon.Entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Table(name = "coupons")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(of = "couponId")
@ToString(of = {"couponId", "couponName", "price",
        "description", "amount", "endDate"
})

public class Coupon {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int couponId;

    private String couponName;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_Id")
    private Company company;


    @ManyToMany(mappedBy = "coupons",fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    List<Customer> customers = new ArrayList<>();

    private int amount;
    private double price;
    private int categoryId;
    private String imageURL;
    private LocalDateTime startDate = LocalDateTime.now();
    private LocalDateTime endDate;

    public void addCustomer(Customer customer) {
        this.customers.add(customer);
    }


}
