package com.CouponSystemSpring.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.CouponSystemSpring.exception.ObjectNotFoundException;
import com.CouponSystemSpring.model.Company;
import com.CouponSystemSpring.model.Coupon;
import com.CouponSystemSpring.model.Customer;
import com.CouponSystemSpring.repository.CompanyRepository;
import com.CouponSystemSpring.repository.CouponRepository;
import com.CouponSystemSpring.repository.CustomerRepository;
import com.CouponSystemSpring.utils.ServiceStatus;

@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CustomerServiceImpl implements CustomerService, CouponClient {

	@Resource
	private CustomerRepository customerRepository;

	@Resource
	private CouponRepository couponRepository;

	private ClientType clientType = ClientType.CUSTOMER;

	@Resource
	private ServiceStatus serviceStatus;

	private Customer customer;

	public CustomerServiceImpl() {

	}

	public CustomerServiceImpl(Customer customer) {
		this.customer = customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Transactional
	@Override
	public Customer getCustomer() throws Exception {
		try {

			if (!customerRepository.existsById(this.customer.getCustomerId())) {
				throw new ObjectNotFoundException("customer does not exist in system", this.customer.getCustomerId(),
						this.clientType, this.customer.getCustomerId());
			}

			Customer customer = customerRepository.findById(this.customer.getCustomerId()).get();
			return customer;

		} catch (ObjectNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (Exception e) {
			throw new Exception(
					"Cusstomer failed to get customer details. customerId: " + this.customer.getCustomerId());
		}
		return null;
	}

	@Transactional
	@Override
	public ServiceStatus purchaseCoupon(long couponId) throws Exception {
		try {
			
			if (!couponRepository.existsById(couponId)) {
				throw new ObjectNotFoundException("couponId does not exist in system. ", this.customer.getCustomerId(),
						this.clientType, couponId);
			}
			
			Coupon newCoupon = couponRepository.findById(couponId).get();
			
			Map<Long, Customer> customers = couponRepository.findById(couponId).get().getCustomers();
			customers.put(this.customer.getCustomerId(), this.customer);
			newCoupon.setCustomers(customers);
			couponRepository.save(newCoupon);
			
			Map<Long, Coupon> coupons = customerRepository.findById(this.customer.getCustomerId()).get().getCoupons();
			coupons.put(couponId, newCoupon);
			this.customer.setCoupons(coupons);
			customerRepository.save(this.customer);
			couponRepository.save(newCoupon);
			
			newCoupon.setAmount(newCoupon.getAmount() - 1);
			couponRepository.save(newCoupon);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return serviceStatus;
	}

	@Transactional
	@Override
	public List<Coupon> getAllPurchases() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public List<Coupon> getAllCouponsByType(String typeName) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public List<Coupon> getAllCouponsByPrice(double priceTop) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public List<Coupon> getAllCouponsList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public CouponClient login(String name, String password, ClientType clientType) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
