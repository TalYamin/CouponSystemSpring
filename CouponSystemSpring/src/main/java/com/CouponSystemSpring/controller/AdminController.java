package com.CouponSystemSpring.controller;


import static org.hamcrest.CoreMatchers.nullValue;

import java.util.List;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;

import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CouponSystemSpring.exception.AdminControllerException;
import com.CouponSystemSpring.exception.InvalidTokenException;
import com.CouponSystemSpring.model.Company;
import com.CouponSystemSpring.model.Customer;
import com.CouponSystemSpring.model.Tokens;
import com.CouponSystemSpring.service.AdminService;
import com.CouponSystemSpring.service.AdminServiceImpl;
import com.CouponSystemSpring.service.ClientType;
import com.CouponSystemSpring.utils.ServiceStatus;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@RestController
@RequestMapping("/admin")
public class AdminController {

	private ServiceStatus serviceStatus;

	@Resource
	private Tokens tokens;

	@Resource
	ApplicationContext ctx;

	public AdminService getAdminService(String token) {
		try {

			if (tokens.getTokensMap().containsKey(token)) {
				AdminService adminService = ctx.getBean(AdminServiceImpl.class);
				return adminService;
			} else {
				throw new InvalidTokenException("Invalid token", token);
			}
		} catch (InvalidTokenException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@PostMapping("/addCompany/{token}")
	public ResponseEntity<ServiceStatus> addCompany(@RequestBody Company company, @PathVariable("token") String token)
			throws Exception {
		try {

			AdminService adminService = getAdminService(token);

			if (adminService == null) {
				serviceStatus.setSuccess(false);
				serviceStatus.setMessage("Invalid token to Admin: " + token);
			}

			serviceStatus = adminService.addCompany(company);
			if (serviceStatus.isSuccess() == true) {
				System.out.println("Company was added in success " + company.getCompanyId());
				ResponseEntity<ServiceStatus> result = new ResponseEntity<>(serviceStatus, HttpStatus.OK);
				return result;
			} else {
				throw new AdminControllerException("Admin failed to add company ", company.getCompanyId(),
						company.getCompanyName(), ClientType.COMPANY.toString());
			}
		} catch (AdminControllerException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<ServiceStatus> badResult = new ResponseEntity<>(serviceStatus, HttpStatus.BAD_REQUEST);
		return badResult;
	}

	// @DeleteMapping("/removeCompany/{companyId}")
	// public ResponseEntity<ServiceStatus> removeCompany(@PathVariable("companyId")
	// long companyId) throws Exception{
	// try {
	// serviceStatus = adminService.removeCompany(companyId);
	// if (serviceStatus.isSuccess() == true) {
	// System.out.println("Company was removed in success " + companyId);
	// ResponseEntity<ServiceStatus> result = new ResponseEntity<>(serviceStatus,
	// HttpStatus.OK);
	// return result;
	// }
	// else {
	// throw new AdminControllerException("Admin failed to remove company " +
	// companyId);
	// }
	// }catch (AdminControllerException e) {
	// System.out.println(e.getMessage());
	// }catch (Exception e) {
	// e.printStackTrace();
	// }
	// ResponseEntity<ServiceStatus> badResult = new ResponseEntity<>(serviceStatus,
	// HttpStatus.BAD_REQUEST);
	// return badResult;
	// }
	//
	// @PostMapping("/updateCompany")
	// public ResponseEntity<ServiceStatus> updateCompany(@RequestBody String
	// jsonString) throws Exception{
	// try {
	// JsonParser parser = new JsonParser();
	// JsonObject obj = parser.parse(jsonString).getAsJsonObject();
	// long companyId = Long.parseLong(obj.get("companyId").getAsString());
	// String newCompanyPassword = obj.get("newCompanyPassword").getAsString();
	// String newCompanyEmail = obj.get("newCompanyEmail").getAsString();
	// serviceStatus = adminService.updateCompany(companyId, newCompanyPassword,
	// newCompanyEmail);
	// if (serviceStatus.isSuccess() == true) {
	// System.out.println("Company was updated in success " + companyId);
	// ResponseEntity<ServiceStatus> result = new ResponseEntity<>(serviceStatus,
	// HttpStatus.OK);
	// return result;
	// }
	// else {
	// throw new AdminControllerException("Admin failed to update company " +
	// companyId);
	// }
	// }catch (AdminControllerException e) {
	// System.out.println(e.getMessage());
	// }catch (Exception e) {
	// e.printStackTrace();
	// }
	// ResponseEntity<ServiceStatus> badResult = new ResponseEntity<>(serviceStatus,
	// HttpStatus.BAD_REQUEST);
	// return badResult;
	// }
	//
	// @GetMapping("/getAllCompanies")
	// public ResponseEntity<List<Company>> getAllCompanies() throws Exception{
	// try {
	// List<Company> companies = adminService.getAllCompanies();
	// if (!companies.isEmpty()) {
	// System.out.println("All companies were returned in success ");
	// ResponseEntity<List<Company>> result = new ResponseEntity<>(companies,
	// HttpStatus.OK);
	// return result;
	// }
	// else {
	// throw new AdminControllerException("Admin failed to get all companies ");
	// }
	// }catch (AdminControllerException e) {
	// System.out.println(e.getMessage());
	// }catch (Exception e) {
	// e.printStackTrace();
	// }
	// return null;
	// }
	//
	// @GetMapping("getCompany/{companyId}")
	// public ResponseEntity<Company> getCompany(@PathVariable("companyId") long
	// companyId) throws Exception{
	// try {
	// Company company = adminService.getCompany(companyId);
	// if (company != null) {
	// System.out.println("company was returned in success " + companyId);
	// ResponseEntity<Company> result = new ResponseEntity<>(company,
	// HttpStatus.OK);
	// return result;
	// }
	// else {
	// throw new AdminControllerException("Admin failed to get company " +
	// companyId);
	// }
	// }catch (AdminControllerException e) {
	// System.out.println(e.getMessage());
	// }catch (Exception e) {
	// e.printStackTrace();
	// }
	// return null;
	// }
	//
	// @PostMapping("/addCustomer")
	// public ResponseEntity<ServiceStatus> addCustomer(@RequestBody Customer
	// customer) throws Exception{
	// try {
	// serviceStatus = adminService.addCustomer(customer);
	// if (serviceStatus.isSuccess() == true) {
	// System.out.println("Customer was added in success " +
	// customer.getCustomerId());
	// ResponseEntity<ServiceStatus> result = new ResponseEntity<>(serviceStatus,
	// HttpStatus.OK);
	// return result;
	// }
	// else {
	// throw new AdminControllerException("Admin failed to add customer ",
	// customer.getCustomerId(), customer.getCustomerName(),
	// ClientType.CUSTOMER.toString());
	// }
	// }catch (AdminControllerException e) {
	// System.out.println(e.getMessage());
	// }catch (Exception e) {
	// e.printStackTrace();
	// }
	// ResponseEntity<ServiceStatus> badResult = new ResponseEntity<>(serviceStatus,
	// HttpStatus.BAD_REQUEST);
	// return badResult;
	// }
	//
	// @DeleteMapping("/removeCustomer/{customerId}")
	// public ResponseEntity<ServiceStatus>
	// removeCustomer(@PathVariable("customerId") long customerId) throws Exception{
	// try {
	// serviceStatus = adminService.removeCustomer(customerId);
	// if (serviceStatus.isSuccess() == true) {
	// System.out.println("Customer was removed in success " + customerId);
	// ResponseEntity<ServiceStatus> result = new ResponseEntity<>(serviceStatus,
	// HttpStatus.OK);
	// return result;
	// }
	// else {
	// throw new AdminControllerException("Admin failed to remove customer " +
	// customerId);
	// }
	// }catch (AdminControllerException e) {
	// System.out.println(e.getMessage());
	// }catch (Exception e) {
	// e.printStackTrace();
	// }
	// ResponseEntity<ServiceStatus> badResult = new ResponseEntity<>(serviceStatus,
	// HttpStatus.BAD_REQUEST);
	// return badResult;
	// }
	//
	// @PostMapping("/updateCustomer")
	// public ResponseEntity<ServiceStatus> updateCustomer(@RequestBody String
	// jsonString) throws Exception{
	// try {
	// JsonParser parser = new JsonParser();
	// JsonObject obj = parser.parse(jsonString).getAsJsonObject();
	// long customerId = Long.parseLong(obj.get("customerId").getAsString());
	// String newCustomerPassword = obj.get("newCustomerPassword").getAsString();
	// serviceStatus = adminService.updateCustomer(customerId, newCustomerPassword);
	// if (serviceStatus.isSuccess() == true) {
	// System.out.println("Customer was updated in success " + customerId);
	// ResponseEntity<ServiceStatus> result = new ResponseEntity<>(serviceStatus,
	// HttpStatus.OK);
	// return result;
	// }
	// else {
	// throw new AdminControllerException("Admin failed to update customer " +
	// customerId);
	// }
	// }catch (AdminControllerException e) {
	// System.out.println(e.getMessage());
	// }catch (Exception e) {
	// e.printStackTrace();
	// }
	// ResponseEntity<ServiceStatus> badResult = new ResponseEntity<>(serviceStatus,
	// HttpStatus.BAD_REQUEST);
	// return badResult;
	// }
	//
	// @GetMapping("/getAllCustomers")
	// public ResponseEntity<List<Customer>> getAllCustomers() throws Exception{
	// try {
	// List<Customer> customers= adminService.getAllCustomers();
	// if (!customers.isEmpty()) {
	// System.out.println("All customers were returned in success ");
	// ResponseEntity<List<Customer>> result = new ResponseEntity<>(customers,
	// HttpStatus.OK);
	// return result;
	// }
	// else {
	// throw new AdminControllerException("Admin failed to get all customers ");
	// }
	// }catch (AdminControllerException e) {
	// System.out.println(e.getMessage());
	// }catch (Exception e) {
	// e.printStackTrace();
	// }
	// return null;
	// }
	//
	// @GetMapping("getCustomer/{customerId}")
	// public ResponseEntity<Customer> getCustomer(@PathVariable("customerId") long
	// customerId) throws Exception{
	// try {
	// Customer customer = adminService.getCustomer(customerId);
	// if (customer != null) {
	// System.out.println("customer was returned in success " + customerId);
	// ResponseEntity<Customer> result = new ResponseEntity<>(customer,
	// HttpStatus.OK);
	// return result;
	// }
	// else {
	// throw new AdminControllerException("Admin failed to get customer " +
	// customerId);
	// }
	// }catch (AdminControllerException e) {
	// System.out.println(e.getMessage());
	// }catch (Exception e) {
	// e.printStackTrace();
	// }
	// return null;
	// }
}
