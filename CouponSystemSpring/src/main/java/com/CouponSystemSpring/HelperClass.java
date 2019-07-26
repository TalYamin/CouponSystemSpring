package com.CouponSystemSpring;

import javax.transaction.Transactional;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.CouponSystemSpring.model.Company;
import com.CouponSystemSpring.repository.CompanyRepository;
import com.CouponSystemSpring.repository.CouponRepository;

public class HelperClass implements ApplicationContextAware {
	
	private ApplicationContext applicationContext;

	
	
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException{
		this.applicationContext = applicationContext;
	}

	@Transactional
	public void removeCompany(CompanyRepository companyRepository, CouponRepository couponRepository, Company company) {
			couponRepository.deleteAllByCompanyCompanyId(company.getCompanyId());
			companyRepository.delete(company);
		
	}

}
