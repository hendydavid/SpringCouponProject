package com.springCoupon.Services;

import com.springCoupon.Entities.Company;
import com.springCoupon.Entities.Coupon;
import com.springCoupon.Entities.Customer;
import com.springCoupon.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService extends MainService {

    public void deleteCustomer(Customer customer) {
        customerRepository.delete(customer);
    }

    public void deleteCustomer(int customerId) {
        customerRepository.deleteById(customerId);
    }

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public void addPurchase(int customerId, int couponId) {
        customerRepository.addPurchase(customerId, couponId);
    }

    public Optional<Customer> getCustomer(int customerId) {
        return customerRepository.findById(customerId);
    }

    public Optional<Coupon> getCoupon(int couponId) {
        return couponRepository.findById(couponId);
    }

    public Customer saveCustomer(Customer customer) {

        return customerRepository.save(customer);
    }
}
