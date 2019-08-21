package com.CouponSystemSpring.repository;

import java.time.LocalDate;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CouponSystemSpring.model.Coupon;
import com.CouponSystemSpring.model.CouponType;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long> {
	
	public List<Coupon> findAllByCompanyCompanyId(long companyId); 
	
	public List<Coupon> findAllByCompanyCompanyIdAndType(long companyId, CouponType typeName);
	
	public List<Coupon> findAllByCompanyCompanyIdAndPrice(long companyId, double priceTop);
	
	public List<Coupon> findAllByCompanyCompanyIdAndEndDate(long companyId, LocalDate untilDate);
	
	public long deleteByCompanyCompanyId(long companyId);
	
	public boolean existsByTitle (String title);
	
	public boolean existsByCouponIdAndCompanyCompanyId(long couponId, long companyId);
}
