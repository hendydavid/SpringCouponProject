package com.springCoupon;

import com.springCoupon.Entities.Company;
import com.springCoupon.Entities.Coupon;
import com.springCoupon.Entities.Customer;
import com.springCoupon.Services.CompanyService;
import com.springCoupon.Services.CouponService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

@SpringBootApplication
public class SpringCouponApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = SpringApplication.run(SpringCouponApplication.class, args);

        CompanyService companyService = ctx.getBean(CompanyService.class);
        CouponService couponService = ctx.getBean(CouponService.class);

        Company company = getCompany(1);
        companyService.saveCompany(company);
        Coupon coupon = getCoupon(1, company);
        //    company.addCoupon(coupon);
        couponService.saveCoupon(new Coupon("d", "c", company, 100, 100.0, 1,"bg"));


    }


    public static Company getCompany(int i) {
        Company company = Company.builder().companyName("company" + i).password("password" + i).email("email" + i).build();
        return company;
    }

    public static Customer getCustomer(int i) {
        return Customer.builder().email("email" + i).password("password" + i).firstName("firstName" + i).lastName("lastName" + i).build();

    }

    public static Coupon getCoupon(int i, Company company) {

        int year = new Random().nextInt(22) + 2000;
        int month = new Random().nextInt(11) + 1;
        int day = new Random().nextInt(27) + 1;
        int hour = new Random().nextInt(23) + 1;
        int minute = new Random().nextInt(58) + 1;


        Coupon coupon = Coupon.builder().couponName("couponName " + i).amount(new Random().nextInt(150) + 10)
                .categoryId(new Random().nextInt(9) + 1).description("description" + i)
                .price(new Random().nextInt() + 1.5).imageURL("imageUrl" + i)
                .endDate(LocalDateTime.of(year, month, day, hour, minute)).company(company).build();

        //  coupon.getCompany().addCoupon(coupon);
        return coupon;
    }


}



