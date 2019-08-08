package com.CouponSystemSpring.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Component
@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Company {
	
	@Id
	@Basic(optional = false)
	@Column(nullable = false)
	private @NonNull long companyId;
	
	@Basic(optional = false)
	@Column(nullable = false)
	private @NonNull String companyName;
	
	@Basic(optional = false)
	@Column(nullable = false)
	private @NonNull String companyPassword;
	
	@Basic(optional = false)
	@Column(nullable = false)
	private @NonNull String companyEmail;
	
	@ToString.Exclude
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
	private List<Coupon> coupons = new ArrayList<Coupon>();

}
