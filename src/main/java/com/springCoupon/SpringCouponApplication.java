package com.springCoupon;

import com.springCoupon.Entities.Company;
import com.springCoupon.Entities.Coupon;
import com.springCoupon.Entities.Customer;
import com.springCoupon.Services.AdminService;
import com.springCoupon.Services.CompanyService;
import com.springCoupon.Services.CustomerService;
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
        CustomerService customerService = ctx.getBean(CustomerService.class);
        AdminService adminService = ctx.getBean(AdminService.class);



//        companyService.getByMaxPrice(145).forEach(System.out::println);
//        System.out.println(companyService.loginCheck("email4", "password4"));
//        System.out.println(companyService.getCompanyId());


//        Company company = companyService.getCompany(6).get();
//        companyService.deleteCompany(company);


//        for (int i = 1; i <= 300; i++) {
//            int id = new Random().nextInt(299) + 1;
//            Company company = companyService.getCompany(id).get();
//            Coupon coupon = getCoupon(i, company);
//            couponService.saveCoupon(coupon);
//        }
//        Coupon coupon = couponService.getCoupon(260);
//        System.out.println(coupon);
//        Company company = companyService.getCompany(250).get();
//        companyService.deleteCompany(company);

//        for (int i = 1; i <= 300; i++) {
//
//            Customer customer = customerService.getCustomer(i).get();
//
//            for (int y = 1; y <= 10; y++) {
//                int id = new Random().nextInt(299) + 1;
//                Coupon coupon = couponService.getCoupon(id);
//                customer.addCoupon(coupon);
//                customerService.saveCustomer(customer);
//
//            }

    }


    public static Company getCompany(int i) {

        int year = new Random().nextInt(22) + 2000;
        int month = new Random().nextInt(11) + 1;
        int day = new Random().nextInt(27) + 1;
        int hour = new Random().nextInt(23) + 1;
        int minute = new Random().nextInt(58) + 1;
        int price = new Random().nextInt(239) + 1;
        int categoryId = new Random().nextInt(9) + 1;
        int amount = new Random().nextInt(499) + 1;


        Company company = Company.builder().companyName("company" + i).password("password" + i).email("email" + i)
                .dateCreated(LocalDateTime.of(year, month, day, hour, minute)).build();
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
        int price = new Random().nextInt(239) + 1;
        int categoryId = new Random().nextInt(9) + 1;
        int amount = new Random().nextInt(499) + 1;


        Coupon coupon = Coupon.builder().couponName("couponName " + i).amount(amount)
                .categoryId(categoryId).description("description" + i)
                .price(price).imageURL("imageUrl" + i).startDate(LocalDateTime.now())
                .endDate(LocalDateTime.of(year, month, day, hour, minute)).company(company).build();

        //  coupon.getCompany().addCoupon(coupon);
        return coupon;
    }


}



