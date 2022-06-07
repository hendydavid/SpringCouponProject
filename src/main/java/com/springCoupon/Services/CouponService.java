package com.springCoupon.Services;


import com.springCoupon.Entities.Coupon;
import com.springCoupon.repositories.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CouponService {

    @Autowired
    CouponRepository couponRepository;


    public void saveCoupon(Coupon coupon) {
        couponRepository.save(coupon);
    }


}




