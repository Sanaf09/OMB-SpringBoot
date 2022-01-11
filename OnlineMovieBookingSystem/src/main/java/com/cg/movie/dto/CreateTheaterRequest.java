package com.cg.movie.dto;

public class CreateTheaterRequest {
	Integer theaterId;
	String theaterName; // PVR
	String theaterCity; // mumbai
	String managerName;
	String managerContact;

	@Override
	public String toString() {
		return "CreateTheaterRequest [theaterId=" + theaterId + ", theaterName=" + theaterName + ", theaterCity="
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

}
