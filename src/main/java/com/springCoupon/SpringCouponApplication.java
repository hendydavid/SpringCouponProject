package com.springCoupon;

import com.springCoupon.Entities.Company;
import com.springCoupon.Services.CompanyService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.AbstractXmlApplicationContext;

import java.time.LocalDate;
import java.util.stream.Stream;

public class SpringCouponApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = SpringApplication.run(SpringCouponApplication.class, args);

        CompanyService companyService = ctx.getBean(CompanyService.class);

//        companyService.saveCompany(Company.builder().companyName("david").email("david@").password("770898")
//                .dateCreated(LocalDate.now()).build());

//        System.out.println(companyService.isCompanyNameExist("alex"));
//        System.out.println(companyService.isCompanyNameExist("david"));

//        System.out.println(companyService.companyLoginCheck("ales@", "12456"));
//        System.out.println();
//        System.out.println(companyService.companyLoginCheck("ales@", "12gr456"));
//        System.out.println(companyService.companyLoginCheck("alecdsss@", "12456"));
//       companyService.updateCompanyInfo("ales@", "freg");
        companyService.deleteCompany(1);

    }


}
