package com.cg.movie.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.movie.dao.ILoginDao;
import com.cg.movie.dao.IUserDao;
import com.cg.movie.dto.UserDetails;
import com.cg.movie.entities.Customer;
import com.cg.movie.entities.Show;
import com.cg.movie.exception.NotLoggedInException;
import com.cg.movie.exception.ShowNotFoundException;
import com.cg.movie.exception.CustomerAlreadyExistsException;
import com.cg.movie.exception.CustomerNotFoundException;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserDao userDao;
	@Autowired
	private ILoginDao lDao;


	@Override
	public Customer registerNewUser(Customer cust) {
		boolean exists = cust.getCustomerId() != null && userDao.existsById(cust.getCustomerId());
		if (exists) {
			throw new CustomerAlreadyExistsException("student already exists for id=" + cust.getCustomerId());
		}
		cust = userDao.save(cust);
		System.out.println("returning saved stud: " + cust);
		return cust;
	}

	@Override
	public String login(UserDetails userDetails) {//front end
		String role = "";
		Optional<UserDetails> op = lDao.findById(userDetails.getUsername());// do not accept null pointers
        if(!op.isPresent()){
            throw new NotLoggedInException("No User found for username="+userDetails.getUsername());
        }
		UserDetails uDetails = op.get();//getting from db
		if(!userDetails.getPassword().equals(uDetails.getPassword())) {
            throw new NotLoggedInException("Authentification failed for password="+userDetails.getPassword());
		}
		role = uDetails.getUserRole();//from db
		return role;
		
	}
///////////////////////////////////////////////
	public Customer findById(Integer id) {
		System.out.println("id: "+id);
        Optional<Customer> optional = userDao.findById(id);
        if(!optional.isPresent()){
        	System.out.println("***error***");
            throw new CustomerNotFoundException("Show not found for id="+id);
        }
        Customer cust=optional.get();
        System.out.println("Customer: "+ cust);
        return cust;
	}

}
