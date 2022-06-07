package com.springCoupon.repositories;

import com.springCoupon.Admin;
import com.springCoupon.Entities.Company;
import com.springCoupon.Entities.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {

    @Query(value = "select  * from coupons c  where c.company_id = :company_id", nativeQuery = true)
    List<Coupon> findByCompany_id(@Param("company_id") String companyName);

//
//    List<Coupon> findByCategoryIdAndCompanyId(int categoryId, int companyId);

    // List<Coupon> findByCompanyIdAndCompanyId(int categoryId, int companyId);

//    @Query(value = "select * from coupons c where c.companyId = :companyId and c.price <= :price", nativeQuery = true)
//    List<Company> getCompanyCouponsByMaxPrice(@Param("companyId") int couponId, @Param("price") String password);

}
