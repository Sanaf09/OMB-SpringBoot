package com.cg.movie.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cg.movie.dto.MovieDetails;
import com.cg.movie.dto.ScreenDetails;
import com.cg.movie.entities.Movies;
import com.cg.movie.entities.Screens;

@Component
public class TheaterUtil {
	private MovieDetails toDetails(Movies movie) {
		return new MovieDetails(movie.getMovieId(), movie.getMovieName(), movie.getMovieDirector(),
				movie.getMovieLength(), movie.getMovieReleaseDate(), movie.getMovieLanguage(), movie.getMovieGenre());
	}

	public List<MovieDetails> toDetails(Collection<Movies> movies) {
		List<MovieDetails> detailList = new ArrayList<>();
		for (Movies movie : movies) {
			MovieDetails details = toDetails(movie);
			System.out.println(details);
			detailList.add(details);
		}
		return detailList;
	}

	public ScreenDetails toDetails(Screens screen) {
		return new ScreenDetails(screen.getScreenId(), screen.getScreenName(), screen.getMovieEndDate(),
				screen.getShowID());
	}
}
