package com.CouponSystemSpring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CouponSystemSpring.model.Coupon;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long> {
	
	public List<Coupon> findAllByCouponId(long couponId);
	
	public List<Coupon> findAllByCouponIdAndType(long couponId, String typeName);
	
	public List<Coupon> findAllByCouponIdAndPrice(long couponId, double priceTop);
	
	public List<Coupon> findAllByCouponIdAndEndDate(long couponId, String untilDate);
}
