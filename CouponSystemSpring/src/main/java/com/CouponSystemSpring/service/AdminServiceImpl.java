package com.CouponSystemSpring.service;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.CouponSystemSpring.exception.CompanyExistsException;
import com.CouponSystemSpring.model.Company;
import com.CouponSystemSpring.model.Customer;
import com.CouponSystemSpring.repository.CompanyRepository;
import com.CouponSystemSpring.repository.CustomerRepository;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
public class AdminServiceImpl implements AdminService, CouponClient {

	@Resource
	private CompanyRepository companyRepository;

	@Resource
	private CustomerRepository customerRepository;

	private ClientType clientType = ClientType.ADMIN;

	private String exceptionMessage;

	@Override
	@Transactional
	public String addCompany(Company company) throws Exception {

		
		// need to check ID too cause it is save so it recognize it as update
		//companyRepository.existsById(id);
		
		
		try {
			if (companyRepository.findByCompanyName(company.getCompanyName()) != null) {
				throw new CompanyExistsException("Admin failed to add company - this company already exists: ",
						company.getCompanyName());
			} else {
				companyRepository.save(company);
				System.out.println("Admin added new company: " + company.getCompanyId());
				return "success, Admin added new company: " + company.getCompanyId();
			}

		} catch (CompanyExistsException e) {
			System.err.println(e.getMessage());
			exceptionMessage = e.getMessage();
		} catch (Exception e) {
			throw new Exception("Admin failed to add company. companyId: " + company.getCompanyId());
		}
		return exceptionMessage;
	}

	@Override
	@Transactional
	public String removeCompany(long companyId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public String updateCompany(long companyId, String newCompanyPassword, String newCompanyEmail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<Company> getAllCompanies() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Company getCompany(long companyId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public String addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public String removeCustomer(long customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public String updateCustomer(long customerId, String newCustomerPassword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Customer getCustomer(long customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CouponClient login(String name, String password, ClientType clientType) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
