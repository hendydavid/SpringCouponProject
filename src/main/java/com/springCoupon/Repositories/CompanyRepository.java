package com.springCoupon.Repositories;

import com.springCoupon.Entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Integer> {


}
