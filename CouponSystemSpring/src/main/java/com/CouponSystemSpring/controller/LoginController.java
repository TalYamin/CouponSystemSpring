package com.CouponSystemSpring.controller;


import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CouponSystemSpring.model.LoginUser;
import com.CouponSystemSpring.model.Session;
import com.CouponSystemSpring.model.Tokens;
import com.CouponSystemSpring.service.CouponClient;
import com.CouponSystemSpring.utils.ClientTypeConverter;
import com.CouponSystemSpring.utils.CouponSystem;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Resource
	private Tokens tokens;

	@Resource
	private CouponSystem couponSystem;

	@PostMapping
	public ResponseEntity<String> login(@RequestBody LoginUser loginUser) {

		Session session = new Session();
		CouponClient couponClient = null;
		String token = UUID.randomUUID().toString();
		long lastAccessed = System.currentTimeMillis();

		try {
			couponClient = couponSystem.login(loginUser.getUsername(), loginUser.getPassword(),
					ClientTypeConverter.convertStringToType(loginUser.getClientType()));
			session.setCouponClient(couponClient);
			session.setLastAccessed(lastAccessed);
			tokens.getTokensMap().put(token, session);
			return new ResponseEntity<>(token, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}