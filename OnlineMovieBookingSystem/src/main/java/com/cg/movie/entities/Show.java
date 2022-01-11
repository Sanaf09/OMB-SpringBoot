package com.cg.movie.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "show_try")
public class Show {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer showId;
	@Column(name = "showName")
	private String showName; // morning,evening
	@Column(name = "date")
	private LocalDate showDate; // 15th dec
	@Column(name = "time")
	private String showTime; // 3:30
	@Column(name = "movieName")
	private String movieName;
	@Column(name = "theaterName")
	private String theaterName;
	@Column(name = "screenName")
	private String screenName;


	public Show() {
		
	}


	public Show(Integer showId, String showName, LocalDate showDate, String showTime, String movieName,
			String theaterName, String screenName) {
		super();
		this.showId = showId;
		this.showName = showName;
		this.showDate = showDate;
		this.showTime = showTime;
		this.movieName = movieName;
		this.theaterName = theaterName;
		this.screenName = screenName;
	}


	public Show(String showName, LocalDate showDate, String showTime, String movieName, String theaterName,
			String screenName) {
		this.showName = showName;
		this.showDate = showDate;
		this.showTime = showTime;
		this.movieName = movieName;
		this.theaterName = theaterName;
		this.screenName = screenName;	}


	@Override
	public String toString() {
		return "Show [showId=" + showId + ", showName=" + showName + ", showDate=" + showDate + ", showTime=" + showTime
				+ ", movieName=" + movieName + ", theaterName=" + theaterName + ", screenName=" + screenName + "]";
	}


	public Integer getShowId() {
		return showId;
	}


	public void setShowId(Integer showId) {
		this.showId = showId;
	}


	public String getShowName() {
		return showName;
	}


	public void setShowName(String showName) {
		this.showName = showName;
	}


	public LocalDate getShowDate() {
		return showDate;
	}


	public void setShowDate(LocalDate showDate) {
		this.showDate = showDate;
	}


	public String getShowTime() {
		return showTime;
	}


	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}


	public String getMovieName() {
		return movieName;
	}


	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}


	public String getTheaterName() {
		return theaterName;
	}


	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}


	public String getScreenName() {
		return screenName;
	}


	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	
}
