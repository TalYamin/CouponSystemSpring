package com.CouponSystemSpring;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.CouponSystemSpring.model.Company;
import com.CouponSystemSpring.model.Coupon;
import com.CouponSystemSpring.model.CouponType;
import com.CouponSystemSpring.model.Customer;
import com.CouponSystemSpring.repository.CompanyRepository;



@SpringBootApplication
@ComponentScan({ "com.CouponSystemSpring" })
public class CouponSystemSpringApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(CouponSystemSpringApplication.class, args);
		
		/* Company Model Test */
		Company company = new Company(5432, "Lenovo", "Lenovo5432", "lenovo@gmail.com");
		System.err.println(company);
		Customer customer = new Customer(111, "Peleg Yamin", "Peleg111");
		System.err.println(customer);
		Coupon coupon = new Coupon(21, "Karting", "31/12/2019", 5, CouponType.SPORTS, "Karting for couple", 500.5,
				"https://icarexperience.ca/wp-content/uploads/2016/03/Vignette_karting_hp.jpg");
		System.err.println(coupon);
		
		
		/* Company Repository Test */
//		CompanyRepository companyRepository = applicationContext.getBean(CompanyRepository.class);
//		companyRepository.save(company);
//		company.setCompanyEmail("officelenovo@gmail.com");
//		companyRepository.save(company);
//		Company companyToSee = companyRepository.findById(company.getCompanyId()).get();
//		System.err.println(companyToSee);
//		Company company2 = new Company(4321, "Asus", "Asus4321", "asus@gmail.com");
//		companyRepository.save(company2);
//		List<Company> companies = companyRepository.findAll();
//		System.err.println("The Companies are: " + companies);
		
		
		/* Coupon Repository Test */
		
		
		
		applicationContext.close();
	
	}

}
