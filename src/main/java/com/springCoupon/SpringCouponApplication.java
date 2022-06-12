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

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class SpringCouponApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = SpringApplication.run(SpringCouponApplication.class, args);

        CompanyService companyService = ctx.getBean(CompanyService.class);
        CustomerService customerService = ctx.getBean(CustomerService.class);
        AdminService adminService = ctx.getBean(AdminService.class);
        customerService.setCustomerId(6);
        customerService.saveByCoupon(34);


//        customerService.deleteCustomerCoupon();

//        customerService.deleteCustomerCoupon();


//        customerService.addPurchase(231);


        //    customerService.addPurchase(234);


//        customerService.setCustomerId(28);
//        customerService.addPurchase(12);

//        for (int i = 1; i <= 300; i++) {
//            adminService.addCompany(getCompany(i));
//        }

//        for (int i = 1; i <= 300; i++) {
//            adminService.AddCustomer(getCustomer(i));
//        }

//        for (int i = 4; i <= 5; i++) {
//            int companyId = 71;  //new Random().nextInt(299) + 1;
//            Company company = new Company();
//            company.setCompanyId(companyId);
//            companyService.setCompanyId(companyId);
//            Coupon coupon = getCoupon(i, company);
//            try {
//                companyService.addCoupon(coupon);
//            } catch (CompanyException e) {
//                e.getException();
//            }
//
//
//        }

//        Customer customer = adminService.getOneCustomer(233);
//        Coupon coupon = new Coupon();
//        coupon.setCouponId(213);
//        coupon.addCustomer(customer);
//        adminService.rakLivdok(coupon);


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

    public static List<?> getSomething(int oneToThree) {

        switch (oneToThree) {

            case 1:
                return new ArrayList<String>();
            case 2:
                return new ArrayList<Integer>();
            case 3:
                return new ArrayList<Coupon>();
            default:
                return new ArrayList<Company>();

        }

    }


}



