package com.CouponSystemSpring.service;


import static org.hamcrest.CoreMatchers.nullValue;

import java.awt.Image;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.CouponSystemSpring.exception.IncomeControllerException;
import com.CouponSystemSpring.model.Income;
import com.CouponSystemSpring.repository.IncomeRepository;
import com.CouponSystemSpring.utils.ServiceStatus;

@Service
public class IncomeServiceImpl implements IncomeService {

	@Resource
	private IncomeRepository incomeRepository;

	@Resource
	private ServiceStatus serviceStatus;

	@Override
	public ServiceStatus storeIncome(Income income) throws Exception {

		try {
			incomeRepository.save(income);
			serviceStatus.setSuccess(true);
			serviceStatus.setMessage("Success, Income was stored: " + income);
			System.out.println("Success, Income was stored: " + income);
			return serviceStatus;
		} catch (Exception e) {
			throw new Exception("Failed to store income");
		}
	}

	@Override
	public List<Income> viewAllIncome() throws Exception {
		try {

			List<Income> incomes = incomeRepository.findAll();
			System.out.println(incomes);
			return incomes;

		} catch (Exception e) {
			throw new Exception("failed to view all incomes");
		}
	}

	@Override
	public List<Income> viewIncomeByCustomer(long customerId) throws Exception {

		try {

			List<Income> incomesByCustomer = incomeRepository.findAllByClientId(customerId);
			System.out.println(incomesByCustomer);
			return incomesByCustomer;

		} catch (Exception e) {
			throw new Exception("failed to view all incomes by customer: " + customerId);
		}
	}

	@Override
	public List<Income> viewIncomeByCompany(long companyId) throws Exception {

		try {

			List<Income> incomesByCompany = incomeRepository.findAllByClientId(companyId);
			System.out.println(incomesByCompany);
			return incomesByCompany;

		} catch (Exception e) {
			throw new Exception("failed to view all incomes by company: " + companyId);
		}
	}

}
