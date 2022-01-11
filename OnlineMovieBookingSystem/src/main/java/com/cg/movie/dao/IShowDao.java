package com.cg.movie.dao;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.movie.entities.Show;

@Repository
public interface IShowDao extends JpaRepository<Show, Integer> {

	@Query("from Show where showName=:showName")
	List<Show> findByName(@Param("showName") String showName);

}
