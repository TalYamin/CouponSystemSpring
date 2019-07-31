package com.CouponSystemSpring;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.CouponSystemSpring.model.Company;
import com.CouponSystemSpring.model.Coupon;
import com.CouponSystemSpring.model.CouponType;
import com.CouponSystemSpring.repository.CompanyRepository;
import com.CouponSystemSpring.repository.CouponRepository;
import com.CouponSystemSpring.service.AdminService;
import com.CouponSystemSpring.service.AdminServiceImpl;

@SpringBootApplication
@ComponentScan({ "com.CouponSystemSpring" })
public class CouponSystemSpringApplication {

	public static void main(String[] args) throws Exception{
		ConfigurableApplicationContext applicationContext = SpringApplication.run(CouponSystemSpringApplication.class,
				args);

		// /* Company Model Test */
		// Company company = new Company(5432, "Lenovo", "Lenovo5432",
		// "lenovo@gmail.com");
		// System.err.println(company);
		// Customer customer = new Customer(111, "Peleg Yamin", "Peleg111");
		// System.err.println(customer);
		// Coupon coupon = new Coupon(21, "Karting", "31/12/2019", 5, CouponType.SPORTS,
		// "Karting for couple", 500.5,
		// "https://icarexperience.ca/wp-content/uploads/2016/03/Vignette_karting_hp.jpg");
		// System.err.println(coupon);
		//
		// /* Company Repository Test */
		// CompanyRepository companyRepository =
		// applicationContext.getBean(CompanyRepository.class);
		// companyRepository.save(company);
		// company.setCompanyEmail("officelenovo@gmail.com");
		// companyRepository.save(company);
		// Company companyToSee =
		// companyRepository.findById(company.getCompanyId()).get();
		// System.err.println(companyToSee);
		// Company company2 = new Company(4321, "Asus", "Asus4321", "asus@gmail.com");
		// companyRepository.save(company2);
		// List<Company> companies = companyRepository.findAll();
		// System.err.println("The Companies are: " + companies);
		// companyRepository.delete(company);
		// List<Company> companies2 = companyRepository.findAll();
		// System.err.println("The Companies are: " + companies2);
		//
		// /* Coupon Repository Test */
		// CouponRepository couponRepository =
		// applicationContext.getBean(CouponRepository.class);
		// couponRepository.save(coupon);
		// coupon.setPrice(999.5);
		// couponRepository.save(coupon);
		// Coupon couponToSee = couponRepository.findById(coupon.getCouponId()).get();
		// System.err.println(couponToSee);
		// Coupon coupon2 = new Coupon(22, "BBB", "31/12/2019", 10,
		// CouponType.RESTAURANTS, "Bear and Hamburger", 70.9,
		// "https://img.mako.co.il/2018/05/10/GALIABBB_i.jpg");
		// couponRepository.save(coupon2);
		// List<Coupon> coupons = couponRepository.findAll();
		// System.err.println("The coupons are" + coupons);
		// List<Coupon> coupons2 = couponRepository.findAllByCouponId(21);
		// System.err.println("The coupon list by coupon id:" + coupon2);
		// Coupon coupon3 = new Coupon(24, "Goons", "30/10/2019", 12,
		// CouponType.RESTAURANTS, "Family Pizza", 65.4,
		// "https://lh3.googleusercontent.com/p/AF1QipMHRbrkD5FglAreY6ZtKzZYBeee-t4OsmupQNKn=s1600-w1280-h1280");
		// couponRepository.save(coupon3);
		// List<Coupon> coupons3 = couponRepository.findAllByCouponIdAndType(24,
		// CouponType.RESTAURANTS);
		// System.err.println("The coupon list by id and type: " + coupons3);
		// List<Coupon>couponsList = new ArrayList<Coupon>();
		// couponsList.add(coupon);
		// company.setCoupons(couponsList);
		// companyRepository.save(company);
		// couponRepository.save(coupon);
		// System.out.println(company.getCoupons());

		CompanyRepository companyRepository = applicationContext.getBean(CompanyRepository.class);
		CouponRepository couponRepository = applicationContext.getBean(CouponRepository.class);

		System.err.println("**************** Saving Company");
		Company company = new Company(5432, "Lenovo", "Lenovo5432", "lenovo@gmail.com");
		companyRepository.save(company);
		Company company2 = new Company(4321, "Asus", "Asus4321", "asus@gmail.com");
		companyRepository.save(company2);
		
		System.err.println("**************** adding coupons");
		Coupon coupon = new Coupon(21, "Karting", "31/12/2019", 5, CouponType.SPORTS, "Karting for couple", 500.5,
				"https://icarexperience.ca/wp-content/uploads/2016/03/Vignette_karting_hp.jpg");
		coupon.setCompany(company);
		couponRepository.save(coupon);
		Coupon coupon2 = new Coupon(22, "BBB", "31/12/2019", 10,
				CouponType.RESTAURANTS, "Bear and Hamburger", 70.9, "https://img.mako.co.il/2018/05/10/GALIABBB_i.jpg");
		coupon2.setCompany(company);
		couponRepository.save(coupon2);
		Coupon coupon3 = new Coupon(24, "Goons", "30/10/2019", 12,
				CouponType.RESTAURANTS, "Family Pizza", 65.4,
				"https://lh3.googleusercontent.com/p/AF1QipMHRbrkD5FglAreY6ZtKzZYBeee-t4OsmupQNKn=s1600-w1280-h1280");
		coupon3.setCompany(company2);
		couponRepository.save(coupon3);
//		List<Coupon>couponsList = couponRepository.findAllByCompanyCompanyId(5432);
//		System.err.println(couponsList);
//		List<Coupon>couponsListType = couponRepository.findAllByCompanyCompanyIdAndType(5432, CouponType.RESTAURANTS);
//		System.err.println(couponsListType);
		List<Coupon>couponsList = couponRepository.findAllByCompanyCompanyIdAndEndDate(5432 ,LocalDate.of(2019, 12, 31));
		System.err.println(couponsList);
		
		Company company3 = new Company(4321, "Asus", "Asus4321", "asus@gmail.com");
		AdminService adminService = applicationContext.getBean(AdminServiceImpl.class);
		adminService.addCompany(company3);
		
//		HelperClass helperClass = new HelperClass();
//		helperClass.removeCompany(companyRepository, couponRepository, company2);
		
		

	}

}
