package com.albinpoignot.foursquarepoc.models;

import java.util.List;

/**
 * Created by Albin on 14/10/2015.
 */
public class Location {

    private String address;

    private Integer distance;

    private String postalCode;

    private String city;

    private String state;

    private String country;

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public Integer getDistance()
	{
		return distance;
	}

	public void setDistance(Integer distance)
	{
		this.distance = distance;
	}

	public String getPostalCode()
	{
		return postalCode;
	}

	public void setPostalCode(String postalCode)
	{
		this.postalCode = postalCode;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getState()
	{
		return state;
	}

	public void setState(String state)
	{
		this.state = state;
	}

	public String getCountry()
	{
		return country;
	}

	public void setCountry(String country)
	{
		this.country = country;
	}
}
