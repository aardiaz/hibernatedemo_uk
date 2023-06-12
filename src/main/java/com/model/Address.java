package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "address_tbl")
public class Address {
 
	   @Id   //PK
	   @GeneratedValue
	  private int id;
	  private String country;
	  private String city;
	  private String state;
	  
	public Address() {}
	  
	public Address(int id, String country, String city, String state) {
		this.id = id;
		this.country = country;
		this.city = city;
		this.state = state;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
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

	@Override
	public String toString() {
		return "Address [id=" + id + ", country=" + country + ", city=" + city + ", state=" + state + "]";
	}
	  
	  
	
}
