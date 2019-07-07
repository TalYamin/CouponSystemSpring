package com.CouponSystemSpring.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company {
	
	@Id
	@Basic(optional = false)
	@Column(nullable = false)
	private long companyId;
	
	@Basic(optional = false)
	@Column(nullable = false)
	private String companyName;
	
	@Basic(optional = false)
	@Column(nullable = false)
	private String companyPassword;
	
	@Basic(optional = false)
	@Column(nullable = false)
	private String companyEmail;

}
