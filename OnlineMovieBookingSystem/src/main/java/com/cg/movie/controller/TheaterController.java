package com.cg.movie.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.movie.dto.MovieDetails;
import com.cg.movie.dto.ScreenDetails;
import com.cg.movie.entities.Movies;
import com.cg.movie.entities.Screens;
import com.cg.movie.service.ITheaterService;
import com.cg.movie.util.TheaterUtil;

@RestController
@RequestMapping("/theater")
@Validated
public class TheaterController {
	@Autowired
	private ITheaterService tservice;
	
	@Autowired
	private TheaterUtil tUtil;
	
	@GetMapping("/searchByMovieName/{name}")
	public List<MovieDetails> fetchMovieByName(@PathVariable("name") String movieName,HttpServletRequest request) {
		System.out.println("cntrlr fetch name: " + movieName);
		List<Movies> movies = tservice.findByName(movieName);
		List<MovieDetails> response = tUtil.toDetails(movies);
		System.out.println("by name details: " + response);
		return response;
	}
	

	@GetMapping("/searchByScreenId/{id}")
	public ScreenDetails fetchScreen(@PathVariable("id") Integer screenId,HttpServletRequest request) {
		System.out.println("cntrlr fetch id: " + screenId);
		Screens screen = tservice.findById(screenId);
		ScreenDetails details = tUtil.toDetails(screen);
		System.out.println("details: " + details);
		return details;
	}
}
