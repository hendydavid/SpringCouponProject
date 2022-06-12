package com.springCoupon.repositories;

import com.springCoupon.Entities.Coupon;
import com.springCoupon.Entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = "insert into customers_coupons (customerId, couponId) values(:customerId, :couponId)", nativeQuery = true)
    void addPurchase(@Param("customerId") int customerId, @Param("couponId") int couponId);

    Optional<Customer> findByEmail(String email);

    @Query(value = "select * from customers_coupons where customers_customer_id = :customer_id", nativeQuery = true)
    List<Integer> getAllCustomerCoupon(@Param("customer_id") int customerId);


    @Query("delete from customers_coupons where customers_customer_id = :customer_id")
    void deleteAllCustomerCoupon(@Param("customer_id") int customerId);

}
