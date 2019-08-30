package com.CouponSystemSpring.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapKey;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Customer {
	
	@Id
	@Basic(optional = false)
	@Column(nullable = false)
	private @NonNull long customerId;
	
	@Basic(optional = false)
	@Column(nullable = false)
	private @NonNull String customerName;
	
	@Basic(optional = false)
	@Column(nullable = false)
	private @NonNull String customerPassword;
	
	
	@ManyToMany(cascade = { CascadeType.ALL })
	@MapKey(name="couponId")
    @JoinTable(
        name = "Customer_Coupon", 
        joinColumns = { @JoinColumn(name= "customer_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "coupon_id") }
    )
	private Map<Long,Coupon> coupons = new HashMap<>();
	
//	@ToString.Exclude
//	@ManyToMany
//	@MapKey(name="couponId")
//	private Map<Long,Coupon> coupons = new HashMap<>();

}
