package com.springCoupon.Repositories;

import com.springCoupon.Admin;
import com.springCoupon.Entities.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {


}
