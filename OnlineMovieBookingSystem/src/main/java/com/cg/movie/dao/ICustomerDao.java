package com.cg.movie.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.movie.entities.Booking;

public interface ICustomerDao extends JpaRepository<Booking, Integer> {
	

}
