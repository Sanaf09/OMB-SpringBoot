package com.cg.movie.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.movie.entities.Movies;

@Repository
public interface IMovieDao extends JpaRepository<Movies, Integer> {
	@Query("from Movies where movieName=:movieName")
	List<Movies> findByName(@Param("movieName") String movieName);
}
