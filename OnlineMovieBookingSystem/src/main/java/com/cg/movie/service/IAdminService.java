package com.cg.movie.service;

import com.cg.movie.entities.Movies;
import com.cg.movie.entities.Screens;
import com.cg.movie.entities.Show;
import com.cg.movie.entities.Theater;

public interface IAdminService {
	Theater addTheater(Theater theater);

	Theater deleteTheater(Integer theaterId);

	Movies addMovie(Movies movies);

	Movies deleteMovie(Integer theaterId);

	Screens addScreen(Screens screen);

	Screens deleteScreen(Integer screenId);

	Show addShow(Show show);

	Show deleteShow(Integer showId);

}
