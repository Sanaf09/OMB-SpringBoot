package com.cg.movie.dto;

import java.time.LocalDate;

public class ScreenDetails {
	Integer screenId;
	String screenName; // 1,2,3
	LocalDate movieEndDate;
	Integer showID;

	public ScreenDetails() {
		
	}

	public ScreenDetails(Integer screenId, String screenName, LocalDate movieEndDate, Integer showID) {
		super();
		this.screenId = screenId;
		this.screenName = screenName;
		this.movieEndDate = movieEndDate;
		this.showID = showID;
	}

	@Override
	public String toString() {
		return "ScreenDetails [screenId=" + screenId + ", screenName=" + screenName + ", movieEndDate=" + movieEndDate
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

}
