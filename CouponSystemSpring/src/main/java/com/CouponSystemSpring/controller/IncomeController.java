package com.CouponSystemSpring.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CouponSystemSpring.exception.IncomeControllerException;
import com.CouponSystemSpring.model.Income;
import com.CouponSystemSpring.service.IncomeService;
import com.CouponSystemSpring.utils.ServiceStatus;

@RestController
@RequestMapping("/income")
public class IncomeController {
	
	private ServiceStatus serviceStatus;
	@Resource
	private IncomeService incomeService;
	
	@PostMapping("/storeIncome")
	public ResponseEntity<ServiceStatus> storeIncome(@RequestBody Income income) throws Exception{
		try {
		serviceStatus = incomeService.storeIncome(income);
		if (serviceStatus.isSuccess() == true) {
			System.out.println("Income was stored in success: " + income);
			ResponseEntity<ServiceStatus> result = new ResponseEntity<>(serviceStatus, HttpStatus.OK);
			return result;
		}
		else {
			throw new IncomeControllerException("Failed to store income", income.getClientId(), income.getClientName());
		}
		}catch (IncomeControllerException e) {
			System.out.println(e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<ServiceStatus> badResult = new ResponseEntity<>(serviceStatus, HttpStatus.BAD_REQUEST);
		return badResult;
	}
	
	@RequestMapping("/viewAllIncome")
	public ResponseEntity<List<Income>> viewAllIncome() throws Exception{
		try {
			List<Income> incomes = incomeService.viewAllIncome();
		if (!incomes.isEmpty()) {
			System.out.println("All Incomes was returned in success: ");
			ResponseEntity<List<Income>> result = new ResponseEntity<>(incomes, HttpStatus.OK);
			return result;
		}
		else {
			throw new IncomeControllerException("Failed to view all incomes");
		}
		}catch (IncomeControllerException e) {
			System.out.println(e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
}
