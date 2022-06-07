package com.springCoupon.Repositories;

import com.springCoupon.Entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = "insert into customers_coupons (customerId, couponId) values(:customerId, :couponId)", nativeQuery = true)
    void addPurchase(@Param("customerId") int customerId, @Param("couponId") int couponId);
}
