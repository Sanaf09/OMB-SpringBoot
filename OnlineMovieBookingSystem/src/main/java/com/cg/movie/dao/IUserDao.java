package com.cg.movie.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.movie.entities.Customer;


public interface IUserDao extends JpaRepository<Customer, Integer> {

}
