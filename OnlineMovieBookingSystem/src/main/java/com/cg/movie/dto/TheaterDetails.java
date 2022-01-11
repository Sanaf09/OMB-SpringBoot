package com.cg.movie.dto;

import java.util.HashSet;
import java.util.Set;

import com.cg.movie.entities.Movies;
import com.cg.movie.entities.Screens;

public class TheaterDetails {
	Integer theaterId;
	String theaterName; // PVR
	String theaterCity; // mumbai
	String managerName;
	String managerContact;
	private Set<Screens> screen = new HashSet<>();
	private Set<Movies> movies = new HashSet<>();

	public TheaterDetails() {

	}

	public TheaterDetails(Integer theaterId, String theaterName, String theaterCity, String managerName,
			String managerContact) {
		super();
		this.theaterId = theaterId;
		this.theaterName = theaterName;
		this.theaterCity = theaterCity;
		this.managerName = managerName;
		this.managerContact = managerContact;
	}

	public TheaterDetails(Integer theaterId, String theaterName, String theaterCity, String managerName,
			String managerContact, Set<Screens> screen, Set<Movies> movies) {
		super();
		this.theaterId = theaterId;
		this.theaterName = theaterName;
		this.theaterCity = theaterCity;
		this.managerName = managerName;
		this.managerContact = managerContact;
		this.screen = screen;
		this.movies = movies;
	}

	@Override
	public String toString() {
		return "TheaterDetails [theaterId=" + theaterId + ", theaterName=" + theaterName + ", theaterCity="
				+ theaterCity + ", managerName=" + managerName + ", managerContact=" + managerContact + "]";
	}

	public Integer getTheaterId() {
		return theaterId;
	}

	public void setTheaterId(Integer theaterId) {
		this.theaterId = theaterId;
	}

	public String getTheaterName() {
		return theaterName;
	}

	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}

	public String getTheaterCity() {
		return theaterCity;
	}

	public void setTheaterCity(String theaterCity) {
		this.theaterCity = theaterCity;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerContact() {
		return managerContact;
	}

	public void setManagerContact(String managerContact) {
		this.managerContact = managerContact;
	}

	public Set<Screens> getScreen() {
		return screen;
	}

	public void setScreen(Set<Screens> screen) {
		this.screen = screen;
	}

	public Set<Movies> getMovies() {
		return movies;
	}

	public void setMovies(Set<Movies> movies) {
		this.movies = movies;
	}

}
