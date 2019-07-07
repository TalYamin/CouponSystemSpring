package com.CouponSystemSpring.model;

import java.time.LocalDate;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.CouponSystemSpring.utils.DateConverterUtil;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Coupon {
	
	@Id
	@Basic(optional = false)
	@Column(nullable = false)
	private long couponId;
	
	@Basic(optional = false)
	@Column(nullable = false)
	private String title; 
	
	@Basic(optional = false)
	@Column(nullable = false)
	private LocalDate startDate;
	
	@Basic(optional = false)
	@Column(nullable = false)
	private LocalDate endDate;
	
	@Basic(optional = false)
	@Column(nullable = false)
	private int amount;
	
	@Basic(optional = false)
	@Column(nullable = false)
	private CouponType type;
	
	@Basic(optional = false)
	@Column(nullable = false)
	private String couponMessage;
	
	@Basic(optional = false)
	@Column(nullable = false)
	private double price;
	
	@Basic(optional = false)
	@Column(nullable = false)
	private String image;
	
	@Basic(optional = false)
	@Column(nullable = false)
	private boolean active;
	
	@Transient
	private String customStartDate;
	
	@Transient
	private String customEndDate;
	
	public Coupon(long couponId, String title, String endDate, int amount, CouponType type, String couponMessage,
			double price, String image) {
		setCouponId(couponId);
		setTitle(title);
		setStartDate(LocalDate.now());
		setEndDate(DateConverterUtil.convertStringDate(endDate));
		setAmount(amount);
		setType(type);
		setCouponMessage(couponMessage);
		setPrice(price);
		setImage(image);
		setActive(true);
	}
	
	@Override
	public String toString() {

		customStartDate = DateConverterUtil.DateStringFormat(this.startDate);
		customEndDate = DateConverterUtil.DateStringFormat(this.endDate);

		return "Coupon [couponId=" + this.getCouponId() + ", title=" + this.getTitle() + ", startDate="
				+ this.customStartDate + ", endDate=" + this.customEndDate + ", amount=" + this.getAmount() + ", type="
				+ this.getType() + ", couponMessage=" + this.getCouponMessage() + ", price=" + this.getPrice()
				+ ", image=" + this.getImage() + ", active=" + this.isActive() + "]";
	}
	

}
