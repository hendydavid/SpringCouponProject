package com.springCoupon.Services;

import com.springCoupon.Entities.Company;
import com.springCoupon.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;
    private int companyId =1;

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
        return companyRepository.companyLoginCheck(email, password).size() == 1;
    }

    public boolean updateCompanyInfo(String email, String password) {

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

    public void deleteCompany(int companyId){
        companyRepository.delete(companyRepository.getById(1));
    }
}
