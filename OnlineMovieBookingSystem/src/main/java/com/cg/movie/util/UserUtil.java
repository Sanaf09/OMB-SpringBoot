package com.cg.movie.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cg.movie.dto.CustomerDetails;
import com.cg.movie.entities.Customer;

@Component
public class UserUtil {

	public CustomerDetails toDetails(Customer cust) {
		return new CustomerDetails(cust.getCustomerId(), cust.getCustomerName(), cust.getPassword(),
				cust.getDateOfBirth(), cust.getCustomerContact());

	}

	public List<CustomerDetails> toDetails(Collection<Customer> customers) {
		List<CustomerDetails> detailList = new ArrayList<>();
		for (Customer customer : customers) {
			CustomerDetails details = toDetails(customer);
			System.out.println(details);
			detailList.add(details);
		}
		return detailList;
	}
}
