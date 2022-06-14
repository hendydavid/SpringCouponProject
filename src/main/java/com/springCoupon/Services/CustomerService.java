package com.springCoupon.Services;

import com.springCoupon.Entities.Coupon;
import com.springCoupon.Entities.Customer;
import com.springCoupon.exception.CouponSystemException;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService extends MainService {

    int customerId = 4;

    public void addPurchase(int couponId) {

        if (!customerRepository.findById(this.customerId).isPresent() || !couponRepository.findById(couponId).isPresent()) {
            try {
                throw new CouponSystemException("coupon or customer are not exist");
            } catch (CouponSystemException e) {
                e.printStackTrace();
            }
        }

        Customer customer = customerRepository.getById(customerId);
        Coupon coupon = couponRepository.getById(couponId);

        if (coupon.getAmount() <= 0) {
            try {
                throw new CouponSystemException("this coupon is sold out");
            } catch (CouponSystemException e) {
                e.printStackTrace();
            }

        }

        customer.addCoupon(coupon);
        customerRepository.save(customer);
    }

    public List<Coupon> getAllCustomersCoupons() {
        Customer customer = customerRepository.getById(customerId);
        return customer.getCoupons();
    }

    public List<Coupon> getAllCustomersCouponsByCategory(int categoryId) {
        List<Coupon> couponByCategory = customerRepository.getById(customerId).getCoupons();
        couponByCategory = couponByCategory.stream().filter(c -> c.getCategoryId() == categoryId).collect(Collectors.toList());
        return couponByCategory;
    }

    public List<Coupon> getAllCustomersCouponsByMaxPrice(int maxPrice) {
        List<Coupon> couponByMaxPrice = customerRepository.getById(customerId).getCoupons();
        couponByMaxPrice = couponByMaxPrice.stream().filter(c -> c.getPrice() <= maxPrice).collect(Collectors.toList());
        return couponByMaxPrice;
    }

    public String getCustomerDetails() {
        return customerRepository.findById(this.customerId).toString();
    }

    public void saveByCoupon(int couponId) {
        Coupon coupon = couponRepository.getById(couponId);
        coupon.addCustomer(customerRepository.getById(this.customerId));
        couponRepository.save(coupon);

    }


    @Modifying
    @Transactional
    public void deleteCustomerCoupon() {
        customerRepository.deleteAllCustomerCoupon(this.customerId);
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }


}
