package com.springCoupon.Services;

import com.springCoupon.Entities.Coupon;
import com.springCoupon.exception.CouponSystemException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CompanyService extends MainService {

    private int companyId = 1;

    public boolean loginCheck(String email, String password) {

        if (companyRepository.findByEmailAndPassword(email, password).isPresent()) {
            companyId = companyRepository.findByEmailAndPassword(email, password).get().getCompanyId();
            return true;
        }
        return false;
    }

    public List<Coupon> getCouponOfCompany(int companyId) {
        return couponRepository.findByCompany_id(companyId);
    }

    public List<Coupon> findByCompanyIdAndCategoryId(int categoryId, int companyId) {

        return couponRepository.findByCompanyIdAndCategoryId(categoryId, companyId);
    }

    public Coupon addCoupon(Coupon coupon) throws CouponSystemException {
        if (!isCouponExistByName(coupon)) {
            coupon.setCompany(companyRepository.getById(companyId));
            return couponRepository.save(coupon);
        } else if (isCouponExistByName(coupon)) {
            int companyId = couponRepository.findByCouponName(coupon.getCouponName()).get().getCompany().getCompanyId();
            if (companyId == this.companyId) {
                System.out.println("this name already in use");
                throw new CouponSystemException("the same name belongs to the same company");
            }

        }
        coupon.setCompany(companyRepository.getById(companyId));
        return couponRepository.save(coupon);
    }

    public void deletedCoupon(Coupon coupon) {

        if (!isCouponExistByName(coupon)) {
            System.out.println("this coupons is not exist");
        } else {
            System.out.println("deleted");
            couponRepository.deleteById(coupon.getCouponId());
        }
    }

    public void updateCouponPrice(Coupon coupon, int price)  {

        if (!isCouponExistByName(coupon)) {
            System.out.println("this coupons is not exist");
            return;
        }

        coupon.setPrice(price);
        couponRepository.save(coupon);

    }

    public String getCompanyDetails() {
        return companyRepository.findById(companyId).toString();
    }

    public List<Coupon> getByMaxPrice(int price) {
        return couponRepository.getCouponByMaxPrice(price, companyId);
    }

    public List<Coupon> getCouponBetweenByDate(LocalDateTime start, LocalDateTime end) {
        return couponRepository.GetCouponBetweenByDate(start, end, companyId);
    }

    private boolean isCouponExistByName(Coupon coupon) {
        String name = coupon.getCouponName();
        return couponRepository.findByCouponName(name).isPresent();
    }

    public void setCompanyId(int company_Id) {
        companyId = company_Id;
    }

    public int getCompanyId() {
        return this.companyId;
    }

}
