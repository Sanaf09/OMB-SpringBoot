package com.cg.movie.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.movie.dto.CreateMovieRequest;
import com.cg.movie.dto.CreateScreenRequest;
import com.cg.movie.dto.CreateShowRequest;
import com.cg.movie.dto.CreateTheaterRequest;
import com.cg.movie.dto.MovieDetails;
import com.cg.movie.dto.ScreenDetails;
import com.cg.movie.dto.ShowDetails;
import com.cg.movie.dto.TheaterDetails;
import com.cg.movie.entities.Movies;
import com.cg.movie.entities.Screens;
import com.cg.movie.entities.Show;
import com.cg.movie.entities.Theater;
import com.cg.movie.exception.AuthorizationException;
import com.cg.movie.exception.MovieNotFoundException;
import com.cg.movie.exception.NotLoggedInException;
import com.cg.movie.exception.ScreenNotFoundException;
import com.cg.movie.exception.ShowNotFoundException;
import com.cg.movie.exception.TheaterNotFoundException;
import com.cg.movie.service.IAdminService;
import com.cg.movie.util.AdminUtil;

@RestController
@RequestMapping("/admin")
@Validated
public class AdminController {
	@Autowired
	private IAdminService aService;

	@Autowired
	private AdminUtil aUtil;

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/addTheater")
	public TheaterDetails addTheater(@RequestBody @Valid CreateTheaterRequest requestData, HttpServletRequest request) {
		String role = (String) request.getSession().getAttribute("role");
		System.out.println("Role = " + role);
		if (role == null) {
			throw new NotLoggedInException("You have not logged in as admin.");
		}
		TheaterDetails details = null;
		if (role.equals("admin")) {

			System.out.println("It is working ......req data: " + requestData);
			Theater theater = new Theater(requestData.getTheaterName(), requestData.getTheaterCity(),
					requestData.getManagerName(), requestData.getManagerContact());
			System.out.println("Theater came: " + theater);
			theater = aService.addTheater(theater);
			details = aUtil.toDetails(theater);
		} else {
			throw new AuthorizationException("Please login as ADMIN to add theater.");
		}
		return details;
	}

	@DeleteMapping("/deleteTheater/{theaterid}")
	public TheaterDetails deleteTheater(@PathVariable("theaterid") Integer theaterId, HttpServletRequest request) {
		String role = (String) request.getSession().getAttribute("role");
		System.out.println("Role = " + role);
		if (role == null) {
			throw new NotLoggedInException("You have not logged in as admin.");
		}
		TheaterDetails details = null;

		if (role.equals("admin")) {
			Theater theater = aService.deleteTheater(theaterId);
			System.out.println("Theater came: " + theater);
			if (theater != null) {
				details = aUtil.toDetails(theater);
			} else {
				throw new TheaterNotFoundException("Failed to delete theater.");
			}
		} else {
			throw new AuthorizationException("Please login as ADMIN to add theater.");
		}
		return details;
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/addMovie")
	public MovieDetails addMovie(@RequestBody @Valid CreateMovieRequest requestData, HttpServletRequest request) {

		String role = (String) request.getSession().getAttribute("role");
		System.out.println("Role = " + role);
		if (role == null) {
			throw new NotLoggedInException("You have not logged in as admin.");
		}
		MovieDetails details = null;

		if (role.equals("admin")) {
			System.out.println("req data: " + requestData);
			Movies movies = new Movies(requestData.getMovieName(), requestData.getMovieDirector(),
					requestData.getMovieLength(), requestData.getMovieReleaseDate(), requestData.getMovieLanguage(),
					requestData.getMovieGenre());
			System.out.println("Movie came: " + movies);
			movies = aService.addMovie(movies);
			details = aUtil.toDetails(movies);
		} else {
			throw new AuthorizationException("Please login as ADMIN to add Movie.");
		}
		return details;
	}

	@DeleteMapping("/deleteMovie/{movieId}")
	public MovieDetails deleteMovie(@PathVariable("movieId") Integer movieId, HttpServletRequest request) {
		String role = (String) request.getSession().getAttribute("role");
		System.out.println("Role = " + role);
		if (role == null) {
			throw new NotLoggedInException("You have not logged in as admin.");
		}
		MovieDetails details = null;

		if (role.equals("admin")) {

			Movies movie = aService.deleteMovie(movieId);
			System.out.println("movie came: " + movie);

			if (movie != null) {
				details = aUtil.toDetails(movie);
			} else {
				throw new MovieNotFoundException("Failed to delete movie.");
			}
		} else {
			throw new AuthorizationException("Please login as ADMIN to add Movie.");
		}
		return details;
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/addScreen")
	public ScreenDetails addScreen(@RequestBody @Valid CreateScreenRequest requestData, HttpServletRequest request) {
		String role = (String) request.getSession().getAttribute("role");
		System.out.println("Role = " + role);
		if (role == null) {
			throw new NotLoggedInException("You have not logged in as admin.");
		}
		ScreenDetails details = null;

		if (role.equals("admin")) {
			System.out.println("req data: " + requestData);
			Screens screen = new Screens(requestData.getScreenName(), requestData.getMovieEndDate(),
					requestData.getShowID());
			System.out.println("Screen came: " + screen);
			screen = aService.addScreen(screen);
			details = aUtil.toDetails(screen);
		} else {
			throw new AuthorizationException("Please login as ADMIN to add Movie.");
		}
		return details;
	}

	@DeleteMapping("/deleteScreen/{screenId}")
	public ScreenDetails deleteScreen(@PathVariable("screenId") Integer screenId, HttpServletRequest request) {
		String role = (String) request.getSession().getAttribute("role");
		System.out.println("Role = " + role);
		if (role == null) {
			throw new NotLoggedInException("You have not logged in as admin.");
		}
		ScreenDetails details = null;
		if (role.equals("admin")) {

			Screens screen = aService.deleteScreen(screenId);
			System.out.println("screen came: " + screen);

			if (screen != null) {
				details = aUtil.toDetails(screen);
			} else {
				throw new ScreenNotFoundException("Failed to delete screen.");
			}
		} else {
			throw new AuthorizationException("Please login as ADMIN to add Movie.");

		}
		return details;
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/addShow")
	public ShowDetails addShow(@RequestBody @Valid CreateShowRequest requestData, HttpServletRequest request) {
		String role = (String) request.getSession().getAttribute("role");
		System.out.println("Role = " + role);
		if (role == null) {
			throw new NotLoggedInException("You have not logged in as admin.");
		}
		ShowDetails details = null;

		if (role.equals("admin")) {
			System.out.println("req data: " + requestData);
			Show show = new Show(requestData.getShowName(), requestData.getShowDate(), requestData.getShowTime(),
					requestData.getMovieName(), requestData.getTheaterName(), requestData.getScreenName());
			System.out.println("Show came: " + show);
			show = aService.addShow(show);
			details = aUtil.toDetails(show);
		} else {
			throw new AuthorizationException("Please login as ADMIN to add Movie.");

		}
		return details;
	}

	@DeleteMapping("/deleteShow/{showId}")
	public ShowDetails deleteShow(@PathVariable("showId") Integer showId, HttpServletRequest request) {

		String role = (String) request.getSession().getAttribute("role");
		System.out.println("Role = " + role);
		if (role == null) {
			throw new NotLoggedInException("You have not logged in as admin.");
		}
		ShowDetails details = null;
		if (role.equals("admin")) {

			Show show = aService.deleteShow(showId);
			System.out.println("show came: " + show);

			if (show != null) {
				details = aUtil.toDetails(show);
			} else {
				throw new ShowNotFoundException("Failed to delete show.");
			}
		} else {
			throw new AuthorizationException("Please login as ADMIN to add Movie.");

		}
		return details;
	}

//	@ResponseStatus(HttpStatus.CREATED)
//	@PostMapping("/addTheater")
//	public TheaterDetails addTheater(@RequestBody @Valid CreateTheaterRequest requestData, HttpServletRequest request) {
//		HttpSession session = request.getSession();
//		System.out.println(session);
//		if (session == null) {
//			throw new AuthenticationFailedException("You are not logged in.");
//		}
//		String role = (String) session.getAttribute("role");
//		System.out.println("Role = " + role);
//		TheaterDetails details = null;
//		if (role.equals("admin")) {
//
//			System.out.println("req data: " + requestData);
//			Theater theater = new Theater(requestData.getTheaterName(), requestData.getTheaterCity(),
//					requestData.getManagerName(), requestData.getManagerContact());
//			System.out.println("Theater came: " + theater);
//			theater = aService.addTheater(theater);
//			details = aUtil.toDetails(theater);
//		} else {
//			throw new AuthorizationException("Please login as ADMIN to add theater.");
//		}
//		return details;
//
//	}
}
