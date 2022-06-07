package com.springCoupon.Entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Table(name = "coupons")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(of = "couponId")
@ToString(of = {"couponId", "couponName", "price",
"description","amount","endDate"
})

public class Coupon {


    @Id
    @GeneratedValue
    private int couponId;

    private String couponName;
    private String description;

    @ManyToOne
    @JoinColumn(name = "company_Id")
    private Company company;
    private int amount;
    private double price;
    private int categoryId;
    private String imageURL;
    private LocalDateTime startDate;
    private LocalDateTime endDate;


}
