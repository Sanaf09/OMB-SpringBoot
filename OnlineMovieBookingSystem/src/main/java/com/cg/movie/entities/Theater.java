package com.cg.movie.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "theater_try")
@NamedQuery(name="Theater.findByCityName",
query="SELECT show FROM Show show WHERE show.showName = ?1")
public class Theater {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	Integer theaterId;
	@Column(name = "theaterName")
	String theaterName; // PVR
	@Column(name = "theaterCity")
	String theaterCity; // mumbai
	@Column(name = "managerName")
	String managerName;
	@Column(name = "managerContact")
	String managerContact;

	@OneToMany(mappedBy = "theater", cascade = CascadeType.ALL)
	private Set<Movies> movies = new HashSet<>();
	
	@OneToMany(mappedBy = "theater", cascade = CascadeType.ALL)
	private Set<Screens> screen = new HashSet<>();

	public Theater() {

	}

	public Theater(Integer theaterId, String theaterName, String theaterCity, String managerName, String managerContact,
			Set<Movies> movies, Set<Screens> screen) {
		super();
		this.theaterId = theaterId;
		this.theaterName = theaterName;
		this.theaterCity = theaterCity;
		this.managerName = managerName;
		this.managerContact = managerContact;
		this.movies = movies;
		this.screen = screen;
	}

	public Theater(Integer theaterId, String theaterName, String theaterCity, String managerName,
			String managerContact) {
		super();
		this.theaterId = theaterId;
		this.theaterName = theaterName;
		this.theaterCity = theaterCity;
		this.managerName = managerName;
		this.managerContact = managerContact;
	}

	public Theater(String theaterName, String theaterCity, String managerName, String managerContact) {
		this.theaterName = theaterName;
		this.theaterCity = theaterCity;
		this.managerName = managerName;
		this.managerContact = managerContact;
	}

	@Override
	public String toString() {
		return "Theater [theaterId=" + theaterId + ", theaterName=" + theaterName + ", theaterCity=" + theaterCity
				+ ", managerName=" + managerName + ", managerContact=" + managerContact + "]";
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

	public Set<Movies> getMovies() {
		return movies;
	}

	public void setMovies(Set<Movies> movies) {
		this.movies = movies;
	}

	public Set<Screens> getScreen() {
		return screen;
	}

	public void setScreen(Set<Screens> screen) {
		this.screen = screen;
	}

}
