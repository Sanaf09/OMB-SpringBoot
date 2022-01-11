package com.cg.movie.service;

import java.util.List;

import com.cg.movie.entities.Show;

public interface IShowService {
	List<Show> findByName(String showName);

	List<Show> findAll();

	}
