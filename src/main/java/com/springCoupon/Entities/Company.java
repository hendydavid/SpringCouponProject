package com.springCoupon.Entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "companies")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(of = "companyId")
@ToString(of = {"companyId", "companyName", "email",})

public class Company {


    @Id
    @GeneratedValue
    private int companyId;

    private String companyName;
    private String email;
    private String password;
    private LocalDate dateCreated;

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    private List<Coupon> coupons = new ArrayList<Coupon>();

    public void addCoupon(Coupon coupon){
    this.coupons.add(coupon);
    }




}