package com.springCoupon.Services;


import com.springCoupon.Entities.Company;
import com.springCoupon.Entities.Coupon;
import com.springCoupon.exception.AdminException;
import com.springCoupon.repositories.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.SystemException;
import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Service
public class AdminService extends MainService {

    public boolean adminLogin(String email, String password) {
        if (!(email.equals("admin@admin.com"))) {
            try {
                throw new AdminException("This email is wrong");
            } catch (AdminException e) {
                e.getException();
            }
        } else if (!(password.equals("admin"))) {

            try {
                throw new AdminException("This password is wrong");
            } catch (AdminException e) {
                e.getException();
            }
        }
        return true;
    }

    public void addCompany(Company company) throws SQLException, AdminException {

        if (isEmailExist(company.getEmail())) {
            throw new AdminException("This company already exist");
        } else if (companyRepository.findByCompany_Name(company.getCompanyName()).isPresent()) {
            throw new AdminException("This company name already exist");
        }
        companyRepository.save(company);
    }

    public void updateCompanyDetails(String password, String email, Company company) throws AdminException {

        if (!isEmailExist(email)) {
            throw new AdminException("This company name isn't  exist");
        }
        companyRepository.save(company);
    }

    public void deleteCompany(int companyId) throws SQLException, AdminException {
        if (!companyRepository.findById(companyId).isPresent()) {
            throw new AdminException("This company isn't exist");
        }
        companyRepository.deleteById(companyId);
    }

    public List<Company> getAllCompany() {
        return companyRepository.findAll();
    }




    public boolean isEmailExist(String email) {
        return companyRepository.findByEmail(email).isPresent();
    }


}




