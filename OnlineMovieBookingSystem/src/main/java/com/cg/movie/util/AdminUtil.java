package com.cg.movie.util;

import org.springframework.stereotype.Component;

import com.cg.movie.dto.MovieDetails;
import com.cg.movie.dto.ScreenDetails;
import com.cg.movie.dto.ShowDetails;
import com.cg.movie.dto.TheaterDetails;
import com.cg.movie.entities.Movies;
import com.cg.movie.entities.Screens;
import com.cg.movie.entities.Show;
import com.cg.movie.entities.Theater;

@Component
public class AdminUtil {

	public TheaterDetails toDetails(Theater theater) {
		return new TheaterDetails(theater.getTheaterId(), theater.getTheaterName(), theater.getTheaterCity(),
				theater.getManagerName(), theater.getManagerContact());

	}

	public MovieDetails toDetails(Movies movies) {
		return new MovieDetails(movies.getMovieId(), movies.getMovieName(), movies.getMovieDirector(),
				movies.getMovieLength(), movies.getMovieReleaseDate(), movies.getMovieLanguage(),
				movies.getMovieGenre());

	}

	public ScreenDetails toDetails(Screens screen) {

		return new ScreenDetails(screen.getScreenId(), screen.getScreenName(), screen.getMovieEndDate(),
				screen.getShowID());
	}

	public ShowDetails toDetails(Show show) {

		return new ShowDetails(show.getShowId(), show.getShowName(), show.getShowDate(), show.getShowTime(),
				show.getMovieName(), show.getTheaterName(), show.getScreenName());
	}

//	public List<TheaterDetails> toDetails(Collection<Theater> theaters) {
//		List<TheaterDetails> detailList = new ArrayList<>();
//		for (Theater theater : theaters) {
//			TheaterDetails details = toDetails(theater);
//			System.out.println(details);
//			detailList.add(details);
//		}
//		return detailList;
//	}
}
