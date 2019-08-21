package com.CouponSystemSpring;

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
import com.CouponSystemSpring.service.CompanyServiceImpl;

@SpringBootApplication
@ComponentScan({ "com.CouponSystemSpring" })
public class CouponSystemSpringApplication {

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(CouponSystemSpringApplication.class,
				args);

//		 /* Company Model Test */
		 Company company = new Company(5432, "Lenovo", "Lenovo5432",
		 "lenovo@gmail.com");
//		 System.err.println(company);
//		 Customer customer = new Customer(111, "Peleg Yamin", "Peleg111");
//		 System.err.println(customer);
//		 Coupon coupon = new Coupon(21, "Karting", "31/12/2019", 5, CouponType.SPORTS,
//		 "Karting for couple", 500.5,
//		 "https://icarexperience.ca/wp-content/uploads/2016/03/Vignette_karting_hp.jpg");
//		 System.err.println(coupon);
		
		 /* Company Repository Test */
//		 CompanyRepository companyRepository =
//		 applicationContext.getBean(CompanyRepository.class);
//		 companyRepository.save(company);
//		 company.setCompanyEmail("officelenovo@gmail.com");
//		 companyRepository.save(company);
//		 Company companyToSee =
//		 companyRepository.findById(company.getCompanyId()).get();
//		 System.err.println(companyToSee);
//		 Company company2 = new Company(4321, "Asus", "Asus4321", "asus@gmail.com");
//		 companyRepository.save(company2);
//		 List<Company> companies = companyRepository.findAll();
//		 System.err.println("The Companies are: " + companies);
//		 companyRepository.delete(company);
//		 List<Company> companies2 = companyRepository.findAll();
//		 System.err.println("The Companies are: " + companies2);
		
		 /* Coupon Repository Test */
//		 CouponRepository couponRepository =
//		 applicationContext.getBean(CouponRepository.class);
//		 couponRepository.save(coupon);
//		 coupon.setPrice(999.5);
//		 couponRepository.save(coupon);
//		 Coupon couponToSee = couponRepository.findById(coupon.getCouponId()).get();
//		 System.err.println(couponToSee);
//		 Coupon coupon2 = new Coupon(22, "BBB", "31/12/2019", 10,
//		 CouponType.RESTAURANTS, "Bear and Hamburger", 70.9,
//		 "https://img.mako.co.il/2018/05/10/GALIABBB_i.jpg");
//		 couponRepository.save(coupon2);
//		 List<Coupon> coupons = couponRepository.findAll();
//		 System.err.println("The coupons are" + coupons);
//		 Coupon coupon3 = new Coupon(24, "Goons", "30/10/2019", 12,
//		 CouponType.RESTAURANTS, "Family Pizza", 65.4,
//		 "https://lh3.googleusercontent.com/p/AF1QipMHRbrkD5FglAreY6ZtKzZYBeee-t4OsmupQNKn=s1600-w1280-h1280");
//		 couponRepository.save(coupon3);
//		 List<Coupon>couponsList = new ArrayList<Coupon>();
//		 couponsList.add(coupon);
//		 company.setCoupons(couponsList);
//		 companyRepository.save(company);
//		 couponRepository.save(coupon);
//		 System.out.println(company.getCoupons());

		// CompanyRepository companyRepository =
		// applicationContext.getBean(CompanyRepository.class);
		// CouponRepository couponRepository =
		// applicationContext.getBean(CouponRepository.class);
		//
		// System.err.println("**************** Saving Company");
	//	Company company = new Company(5432, "Lenovo", "Lenovo5432", "lenovo@gmail.com");
		// companyRepository.save(company);
		// Company company2 = new Company(4321, "Asus", "Asus4321", "asus@gmail.com");
		// companyRepository.save(company2);
		//
		// System.err.println("**************** adding coupons");
		// Coupon coupon = new Coupon(21, "Karting", "31/12/2019", 5, CouponType.SPORTS,
		// "Karting for couple", 500.5,
		// "https://icarexperience.ca/wp-content/uploads/2016/03/Vignette_karting_hp.jpg");
		// coupon.setCompany(company);
		// couponRepository.save(coupon);
		// Coupon coupon2 = new Coupon(22, "BBB", "31/12/2019", 10,
		// CouponType.RESTAURANTS, "Bear and Hamburger", 70.9,
		// "https://img.mako.co.il/2018/05/10/GALIABBB_i.jpg");
		// coupon2.setCompany(company);
		// couponRepository.save(coupon2);
		// Coupon coupon3 = new Coupon(24, "Goons", "30/10/2019", 12,
		// CouponType.RESTAURANTS, "Family Pizza", 65.4,
		// "https://lh3.googleusercontent.com/p/AF1QipMHRbrkD5FglAreY6ZtKzZYBeee-t4OsmupQNKn=s1600-w1280-h1280");
		// coupon3.setCompany(company2);
		// couponRepository.save(coupon3);
		// List<Coupon>couponsList = couponRepository.findAllByCompanyCompanyId(5432);
		// System.err.println(couponsList);
		// List<Coupon>couponsListType =
		// couponRepository.findAllByCompanyCompanyIdAndType(5432,
		// CouponType.RESTAURANTS);
		// System.err.println(couponsListType);
		// List<Coupon>couponsList =
		// couponRepository.findAllByCompanyCompanyIdAndEndDate(5432 ,LocalDate.of(2019,
		// 12, 31));
		// System.err.println(couponsList);
		//
		// Company company3 = new Company(4321, "Asus", "Asus4321", "asus@gmail.com");
		// AdminService adminService =
		// applicationContext.getBean(AdminServiceImpl.class);
		// adminService.addCompany(company3);

		// couponRepository.deleteByCompanyCompanyId(5432);
		// companyRepository.delete(company2);

		// HelperClass helperClass = new HelperClass();
		// helperClass.removeCompany(companyRepository, couponRepository, company2);

		// AdminService adminService = new AdminServiceImpl();

		// CompanyRepository companyRepository =
		// applicationContext.getBean(CompanyRepository.class);
		// Company companyToUpdate = companyRepository.getOne((long) 4321);
		// companyToUpdate.setCompanyPassword("Asus1234");
		// companyRepository.save(companyToUpdate);

		// AdminService adminService = new AdminServiceImpl();
		// adminService.updateCompany(1, "a", "a");

		/** Updating Something **/
		 Company company2 = new Company(4321, "Asus", "Asus4321", "asus@gmail.com");
		// Company company = companyRepository.findById((long) 4321).get();
		// company.setCompanyPassword("Asus4321");
		// companyRepository.save(company);

		/** Admin Service Test **/
		AdminService adminService = applicationContext.getBean(AdminServiceImpl.class);
		adminService.addCompany(company2);
		// System.out.println(adminService.addCompany(new Company(9999, "Acer",
		// "Acer9999", "info@acer.com")));
		// System.out.println(adminService.removeCompany(9999));
		// System.out.println(adminService.updateCompany(4321, "Asus1234",
		// "info@asus.com"));
		// adminService.getAllCompanies();
		// adminService.getCompany(9876);
		// System.out.println(adminService.addCustomer(new Customer(314, "Tal Yamin",
		// "Tal313")));
		// System.out.println(adminService.addCustomer(new Customer(456, "Ofek Mesika",
		// "Ofek456")));
		// System.out.println(adminService.removeCustomer(456));
		// System.out.println(adminService.updateCustomer(4567, "456Ofek"));
		// adminService.getAllCustomers();
		// adminService.getCustomer(456);
		// adminService.getCompany(4321);

//		adminService.addCompany(company);
		
		/***/
		CompanyServiceImpl companyService = applicationContext.getBean(CompanyServiceImpl.class);
		companyService.setCompany(company);
		
		CompanyServiceImpl companyService2 = applicationContext.getBean(CompanyServiceImpl.class);
		companyService2.setCompany(company2);
		
		System.out.println(companyService2
				.addCoupon(new Coupon(21, "Karting", "31/12/2019", 5, CouponType.SPORTS, "Karting for couple", 500.5,
						"https://icarexperience.ca/wp-content/uploads/2016/03/Vignette_karting_hp.jpg")));

//		CompanyRepository companyRepository = applicationContext.getBean(CompanyRepository.class);
//		Company company2 = companyRepository.findById((long) 5432).get();
//		System.err.println(	company2.getCoupons());
		
		
		/** New Issue - another company can remove coupon that not belongs it*/
		
		System.err.println(companyService.getCompany());
		System.err.println(companyService2.getCompany());
//		System.out.println(companyService.removeCoupon(21));
		
//		company2 = companyRepository.findById((long) 5432).get();
//		System.err.println(	company2.getCoupons());
		
//		CouponRepository couponRepository  = applicationContext.getBean(CouponRepository.class);
//		couponRepository.deleteById((long) 21);
		
//		System.err.println(couponRepository.existsByCouponIdAndCompanyCompanyId(22, 5432));
		
//		IncomeRepository incomeRepository = applicationContext.getBean(IncomeRepository.class);
//		incomeRepository.save(new Income("Dell", 9876, LocalDate.now(), IncomeType.COMPANY_NEW_COUPON,100));
//		System.out.println(incomeRepository.findAllByClientId(9876));
		// applicationContext.close();

	}

}
