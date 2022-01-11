package com.cg.movie.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "movies_try")
public class Movies {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	Integer movieId;
	@Column(name = "movieName")
	String movieName;
	@Column(name = "movieDirector")
	String movieDirector;
	@Column(name = "movieLength")
	int movieLength;
	@Column(name = "movieReleaseDate")
	LocalDate movieReleaseDate;
	@Column(name = "language")
	String movieLanguage;
	@Column(name = "genre")
	String movieGenre;

	@ManyToOne
	@JoinColumn(name = "theater_id")
	private Theater theater;

	public Movies() {

	}

	public Movies(Integer movieId, String movieName, String movieDirector, int movieLength, LocalDate movieReleaseDate,
			String movieLanguage, String movieGenre) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieDirector = movieDirector;
		this.movieLength = movieLength;
		this.movieReleaseDate = movieReleaseDate;
		this.movieLanguage = movieLanguage;
		this.movieGenre = movieGenre;
	}

	public Movies(String movieName, String movieDirector, int movieLength, LocalDate movieReleaseDate,
			String movieLanguage, String movieGenre) {
		this.movieName = movieName;
		this.movieDirector = movieDirector;
		this.movieLength = movieLength;
		this.movieReleaseDate = movieReleaseDate;
		this.movieLanguage = movieLanguage;
		this.movieGenre = movieGenre;
	}

	@Override
	public String toString() {
		return "Movies [movieId=" + movieId + ", movieName=" + movieName + ", movieDirector=" + movieDirector
				+ ", movieLength=" + movieLength + ", movieReleaseDate=" + movieReleaseDate + ", movieLanguage="
				+ movieLanguage + ", movieGenre=" + movieGenre + "]";
	}

	public Integer getMovieId() {
		return movieId;
	}

	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieDirector() {
		return movieDirector;
	}

	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
	}

	public int getMovieLength() {
		return movieLength;
	}

	public void setMovieLength(int movieLength) {
		this.movieLength = movieLength;
	}

	public LocalDate getMovieReleaseDate() {
		return movieReleaseDate;
	}

	public void setMovieReleaseDate(LocalDate movieReleaseDate) {
		this.movieReleaseDate = movieReleaseDate;
	}

	public String getMovieLanguage() {
		return movieLanguage;
	}

	public void setMovieLanguage(String movieLanguage) {
		this.movieLanguage = movieLanguage;
	}

	public String getMovieGenre() {
		return movieGenre;
	}

	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}

	public Theater getTheater() {
		return theater;
	}

	public void setTheater(Theater theater) {
		this.theater = theater;
	}

}
