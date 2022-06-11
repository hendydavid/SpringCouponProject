package com.springCoupon.Services;

import com.springCoupon.Entities.Coupon;
import com.springCoupon.Entities.Customer;
import com.springCoupon.exception.CouponException;
import com.springCoupon.exception.CustomerException;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService extends MainService {

    int customerId = 4;

    public void addPurchase(int couponId) {

        if (!customerRepository.findById(this.customerId).isPresent() || !couponRepository.findById(couponId).isPresent()) {
            try {
                throw new CustomerException("coupon or customer are not exist");
            } catch (CustomerException e) {
                e.printStackTrace();
            }
        }

        Customer customer = customerRepository.getById(customerId);
        Coupon coupon = couponRepository.getById(couponId);

        if (coupon.getAmount() <= 0) {
            try {
                throw new CouponException("this coupon is sold out");
            } catch (CouponException e) {
                e.printStackTrace();
            }

        }

        customer.addCoupon(coupon);
        customerRepository.save(customer);
    }

    public List<Integer> getAllCustomersCoupons() {
        Customer customer = customerRepository.getById(customerId);
//        return customer.getCoupons().stream().sorted(Comparator.comparing(Coupon::getCouponId)).collect(Collectors.toList());
        return customerRepository.getAllCustomerCoupon(customerId);
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }


    public void deleteCustomerCoupon() {
       customerRepository.deleteAllCustomerCoupon(this.customerId);
    }


}
