package com.springCoupon.Services;

import com.springCoupon.repositories.CompanyRepository;
import com.springCoupon.repositories.CouponRepository;
import com.springCoupon.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public abstract class MainService {

    @Autowired
    CouponRepository couponRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CompanyRepository companyRepository;


}
