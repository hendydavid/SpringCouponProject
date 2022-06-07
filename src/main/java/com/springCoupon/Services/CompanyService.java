package com.springCoupon.Services;

import com.springCoupon.Entities.Company;
import com.springCoupon.repositories.CompanyRepository;
import com.springCoupon.repositories.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyService {


    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    CouponRepository couponRepository;

    private int companyId = 1;

    public Optional<Company> getCompany(int i) {
        return companyRepository.findById(i);
    }


    public boolean isCompanyNameExist(String companyName) {

        return companyRepository.existsByName(companyName).size() == 1;
    }

    public Company saveCompany(Company company) {

        return companyRepository.save(company);
    }

    public boolean isEmailExist(String email) {

        return companyRepository.existsByEmail(email).size() == 1;
    }

    public boolean companyLoginCheck(String email, String password) {
        return companyRepository.companyLoginCheck(email, password).isPresent();
    }

    public boolean updateCompanyInfo(String email, String password)                                                                   {

        Company company = companyRepository.findById(companyId).get();
        if (isEmailExist(email) && !company.getEmail().equals(email)) {
            System.out.println("Noooooooooooo");
            return false;
            // throw new exception "this mail already exist"
        }
        System.out.println("yesssss");
        company.setEmail(email);
        company.setPassword(password);
        companyRepository.save(company);
        return true;
    }

    public void deleteCompany(int companyId) {
        companyRepository.delete(companyRepository.getById(1));

    }

//    public List<Coupon> getAllCouponsOfCompany() {
//        return couponRepository.findAllByCompanyId(companyId);
//    }
//
//    public List<Coupon> getAllCouponsOfCompanyByCategory(int categoryId) {
//        return couponRepository.findByCategoryIdAndCompanyId(categoryId, companyId);
//    }




}
