package com.CouponSystemSpring.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.CouponSystemSpring.exception.AmountException;
import com.CouponSystemSpring.exception.CouponExistsException;
import com.CouponSystemSpring.exception.EndDatePassedException;
import com.CouponSystemSpring.model.Company;
import com.CouponSystemSpring.model.Coupon;
import com.CouponSystemSpring.repository.CompanyRepository;
import com.CouponSystemSpring.repository.CouponRepository;
import com.CouponSystemSpring.utils.DateConverterUtil;
import com.CouponSystemSpring.utils.ServiceStatus;

@Service
public class CompanyServiceImpl implements CompanyService, CouponClient {

	@Resource
	private CompanyRepository companyRepository;

	@Resource
	private CouponRepository couponRepository;

	private ClientType clientType = ClientType.COMPANY;

	@Resource
	private ServiceStatus serviceStatus;

	@Resource
	private Company company;

	public CompanyServiceImpl() {

	}
	
	public CompanyServiceImpl(Company company) {
		this.company = company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Transactional
	@Override
	public ServiceStatus addCoupon(Coupon coupon) throws Exception {

		try {

			if (coupon.getAmount() < 1) {
				throw new AmountException(
						"Company failed to add coupon - wrong amount: 0, couponId: ", coupon.getAmount(), coupon.getCouponId());
			}

			if (coupon.getEndDate().isBefore(LocalDate.now())) {
				throw new EndDatePassedException("Company failed to add coupon - the end date already passed. ",
						DateConverterUtil.DateStringFormat(coupon.getEndDate()), coupon.getCouponId(),
						this.company.getCompanyId());
			}

			if (couponRepository.existsByTitle(coupon.getTitle())) {
				throw new CouponExistsException("Company failed to add coupon - this coupon already exists. ",
						coupon.getTitle(), this.company.getCompanyId());
			}

			// id of company near coupon
			
			couponRepository.save(coupon);
			List<Coupon>couponsList = this.company.getCoupons();
			couponsList.add(coupon);
			this.company.setCoupons(couponsList);
			companyRepository.save(this.company);
			System.out.println("Company " + this.company.getCompanyName() + " added new coupon: " + coupon.getCouponId());
			serviceStatus.setSuccess(true);
			serviceStatus.setMessage("success, Company " + this.company.getCompanyName() + " added new coupon: " + coupon.getCouponId());
			return serviceStatus;
			
		} catch (AmountException e) {
			System.err.println(e.getMessage());
			serviceStatus.setSuccess(false);
			serviceStatus.setMessage(e.getMessage());
		} catch (EndDatePassedException e) {
			System.err.println(e.getMessage());
			serviceStatus.setSuccess(false);
			serviceStatus.setMessage(e.getMessage());
		} catch (CouponExistsException e) {
			System.err.println(e.getMessage());
			serviceStatus.setSuccess(false);
			serviceStatus.setMessage(e.getMessage());
		} catch (Exception e) {
			throw new Exception("Company failed to add coupon. couponId: " + coupon.getCouponId());
		}

		return serviceStatus;
	}

	@Transactional
	@Override
	public ServiceStatus removeCoupon(long couponId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public ServiceStatus updateCoupon(long couponId, String newEndDate, double newPrice) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public Company getCompany() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public Coupon getCoupon(long couponId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public List<Coupon> getAllCoupons() throws Exception {
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
	public List<Coupon> getAllCouponsByDate(String untilDate) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CouponClient login(String name, String password, ClientType clientType) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
