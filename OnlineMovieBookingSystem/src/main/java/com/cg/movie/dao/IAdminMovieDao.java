package com.cg.movie.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.movie.entities.Movies;

public interface IAdminMovieDao extends JpaRepository<Movies, Integer>{

}
