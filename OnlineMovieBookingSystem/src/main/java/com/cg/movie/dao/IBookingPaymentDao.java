package com.cg.movie.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.movie.entities.Payment;

@Repository
public interface IBookingPaymentDao extends JpaRepository<Payment, Integer>{

}
