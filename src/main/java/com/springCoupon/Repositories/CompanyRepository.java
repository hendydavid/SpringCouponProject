package com.springCoupon.repositories;

import com.springCoupon.Entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


public interface CompanyRepository extends JpaRepository<Company, Integer> {

    @Query(value = "select  * from companies c  where c.company_name = :companyName", nativeQuery = true)
    List<Company> existsByName(@Param("companyName") String companyName);

    @Query(value = "select  * from companies c  where c.email = :email", nativeQuery = true)
    List<Company> existsByEmail(@Param("email") String email);

    @Query(value = "select * from companies c where c.email = :email and c.password = :password", nativeQuery = true)
    List<Company> companyLoginCheck(@Param("email") String email, @Param("password") String password);

    @Modifying
    @Query(value = "update companies set email = :email, password = :password where company_id = :companyId", nativeQuery = true)
    void updateCompany(@Param("email") String email, @Param("password") String password, @Param("companyId") int companyId);




}
