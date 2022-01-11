package com.cg.movie.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.movie.entities.Theater;

public interface IAdminTheaterDao extends JpaRepository<Theater, Integer>{

	


}
