package com.CouponSystemSpring.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

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

}
