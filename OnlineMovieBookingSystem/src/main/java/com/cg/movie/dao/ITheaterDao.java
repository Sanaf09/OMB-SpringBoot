package com.cg.movie.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.movie.entities.Theater;


@Repository
public interface ITheaterDao extends JpaRepository<Theater, Integer>{
	@Query("from Theater where theaterCity=:theaterCity")
	List<Theater> findByCityName( @Param("theaterCity")String theaterCity);
}
