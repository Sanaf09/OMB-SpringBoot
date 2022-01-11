package com.cg.movie.dto;

import java.time.LocalDate;

public class ShowDetails {
	private Integer showId;
	private String showName; // morning,evening
	private LocalDate showDate; // 15th dec
	private String showTime; // 3:30
	private String movieName;
	private String theaterName;
	private String screenName;

	public ShowDetails() {
	}

	public ShowDetails(Integer showId, String showName, LocalDate showDate, String showTime, String movieName,
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

	@Override
	public String toString() {
		return "ShowDetails [showId=" + showId + ", showName=" + showName + ", showDate=" + showDate + ", showTime="
				+ showTime + ", movieName=" + movieName + ", theaterName=" + theaterName + ", screenName=" + screenName
				+ "]";
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
