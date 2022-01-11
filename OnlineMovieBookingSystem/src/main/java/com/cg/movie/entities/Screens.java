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
@Table(name = "screens_try")
public class Screens {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	Integer screenId;
	@Column(name = "screenName")
	String screenName; // 1,2,3
	@Column(name = "movieEndDate")
	LocalDate movieEndDate;
	@Column(name = "showId")
	Integer showID;

	@ManyToOne
	@JoinColumn(name = "theater_id")
	private Theater theater;

	public Screens() {

	}

	public Screens(Integer screenId, String screenName, LocalDate movieEndDate, Integer showID) {
		super();
		this.screenId = screenId;
		this.screenName = screenName;
		this.movieEndDate = movieEndDate;
		this.showID = showID;
	}

	public Screens(String screenName, LocalDate movieEndDate, Integer showID) {
		this.screenName = screenName;
		this.movieEndDate = movieEndDate;
		this.showID = showID;	}

	@Override
	public String toString() {
		return "Screens [screenId=" + screenId + ", screenName=" + screenName + ", movieEndDate=" + movieEndDate
				+ ", showID=" + showID + "]";
	}

	public Integer getScreenId() {
		return screenId;
	}

	public void setScreenId(Integer screenId) {
		this.screenId = screenId;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public LocalDate getMovieEndDate() {
		return movieEndDate;
	}

	public void setMovieEndDate(LocalDate movieEndDate) {
		this.movieEndDate = movieEndDate;
	}

	public Integer getShowID() {
		return showID;
	}

	public void setShowID(Integer showID) {
		this.showID = showID;
	}

	public Theater getTheater() {
		return theater;
	}

	public void setTheater(Theater theater) {
		this.theater = theater;
	}

	
	

	

}
