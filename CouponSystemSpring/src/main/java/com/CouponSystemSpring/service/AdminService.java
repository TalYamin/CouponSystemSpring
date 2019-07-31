package com.CouponSystemSpring.service;

import java.util.List;

import com.CouponSystemSpring.model.Company;
import com.CouponSystemSpring.model.Customer;

public interface AdminService {

	public String addCompany(Company company) throws Exception;

	public String removeCompany(long companyId)throws Exception ;

	public String updateCompany(long companyId, String newCompanyPassword, String newCompanyEmail) throws Exception;

	public List<Company> getAllCompanies() throws Exception;
	
	public Company getCompany(long companyId) throws Exception;
	
	public String addCustomer(Customer customer) throws Exception;
	
	public String removeCustomer(long customerId) throws Exception;
	
	public String updateCustomer(long customerId, String newCustomerPassword) throws Exception;
	
	public List<Customer> getAllCustomers() throws Exception;
	
	public Customer getCustomer(long customerId) throws Exception;
	
	
	
}
