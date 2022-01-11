package com.cg.movie.service;

import java.util.List;

import com.cg.movie.entities.Movies;
import com.cg.movie.entities.Screens;

public interface ITheaterService {
	List<Movies> findByName(String movieName);

	Screens findById(Integer screenId);
}
