package com.springCoupon.controllers;


import com.springCoupon.Entities.Coupon;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CouponController {

    @RequestMapping("/hey")
    @ResponseBody
    public List<Coupon> greet() {
        return new ArrayList<Coupon>();
    }

    @RequestMapping("/hey2")
    @ResponseBody
    public void greet2() {
    }


}
