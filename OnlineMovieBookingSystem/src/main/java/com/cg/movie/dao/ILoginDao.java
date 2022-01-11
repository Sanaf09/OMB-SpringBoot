package com.cg.movie.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.movie.dto.UserDetails;


public interface ILoginDao extends JpaRepository<UserDetails, String>{

	

}
