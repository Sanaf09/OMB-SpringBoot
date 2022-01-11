package com.cg.movie.service;

import com.cg.movie.dto.UserDetails;
import com.cg.movie.entities.Customer;

public interface IUserService {

	Customer registerNewUser(Customer cust);

	String login(UserDetails userDetails);

}
