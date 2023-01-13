package net.springboot.finalProject.model;

import javax.persistence.Embeddable;
import javax.persistence.Column;

@Embeddable
public class Location {
	
	@Column(name="ADDRESS")
	private String address;
	@Column(name="DISTRICT_NAME")
	private String district;
	@Column(name="CITY_NAME")
	private String city;
	@Column(name="STATE_CITY")
	private String state;
	
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
