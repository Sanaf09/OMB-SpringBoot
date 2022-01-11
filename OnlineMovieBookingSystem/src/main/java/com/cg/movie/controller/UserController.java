package com.cg.movie.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.movie.dto.CustomerDetails;
import com.cg.movie.dto.RegisterCutomerRequest;
import com.cg.movie.dto.TheaterDetails;
import com.cg.movie.dto.UserDetails;
import com.cg.movie.entities.Customer;
import com.cg.movie.exception.AuthorizationException;
import com.cg.movie.exception.NotLoggedInException;
import com.cg.movie.service.IUserService;
import com.cg.movie.util.UserUtil;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {
	@Autowired
	private IUserService userService;

	@Autowired
	private UserUtil userUtil;

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/addCustomer")
	public CustomerDetails add(@RequestBody @Valid RegisterCutomerRequest requestData, HttpServletRequest request) { // @RequestBody - accessing all
		String role = (String) request.getSession().getAttribute("role");
		System.out.println("Role = " + role);
		if (role == null) {
			throw new NotLoggedInException("You have not logged in as Customer.");
		}
		CustomerDetails details = null;
		if (role.equals("customer")) {																		// the fields in
																							// cerateEmpRequest,
		System.out.println("req data: " + requestData);
		Customer customer = new Customer(requestData.getCustomerName(), requestData.getPassword(),
				requestData.getDateOfBirth(), requestData.getCustomerContact());
		System.out.println("customer came: " + customer);
		customer = userService.registerNewUser(customer);
		details = userUtil.toDetails(customer);}
		else {
			throw new AuthorizationException("Please login as CUSTOMER to add theater.");
		}
		return details;
	}

	@ResponseStatus(HttpStatus.ACCEPTED)
	@PostMapping("/login")
	public String login(@RequestBody UserDetails userDetails, HttpServletRequest request) {
		HttpSession session = request.getSession();
		System.out.println(session);
		String role = userService.login(userDetails);//from db
		session.setAttribute("user", userDetails.getUsername());
		session.setAttribute("role", role);
		return "You have successfully logged in as : " + role;
	}

	@ResponseStatus(HttpStatus.ACCEPTED)
	@PostMapping("/logout")
	public String logout(@RequestBody UserDetails userDetails, HttpServletRequest request) {
		HttpSession session = request.getSession();
		System.out.println(session);
		Enumeration<String> attrNames = session.getAttributeNames();
		while (attrNames.hasMoreElements()) {
			String name = (String) attrNames.nextElement();
			System.out.println(name);
			String uName = (String) session.getAttribute(name);
			System.out.println(uName);
			if (uName.equals(userDetails.getUsername())) {
				System.out.println("invalidating session..." + uName);
				session.invalidate();
			}
		}
		return "You have successfully logged out " + userDetails.getUsername();
	}
}
