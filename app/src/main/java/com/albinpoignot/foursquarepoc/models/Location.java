package com.albinpoignot.foursquarepoc.models;

/**
 * Created by Albin on 14/10/2015.
 */
public class Location
{

	private String address;

	private Integer distance;

	private String postalCode;

	private String city;

	private String state;

	private String country;

	private Float longitude;

	private Float latitude;

	public String getAddress()
	{
		return address;
	}

	public String getCity()
	{
		return city;
	}

	public String getCountry()
	{
		return country;
	}

	public Integer getDistance()
	{
		return distance;
	}

	public Float getLatitude()
	{
		return latitude;
	}

	public Float getLongitude()
	{
		return longitude;
	}

	public String getPostalCode()
	{
		return postalCode;
	}

	public String getState()
	{
		return state;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public void setCountry(String country)
	{
		this.country = country;
	}

	public void setDistance(Integer distance)
	{
		this.distance = distance;
	}

	public void setLatitude(Float latitude)
	{
		this.latitude = latitude;
	}

	public void setLongitude(Float longitude)
	{
		this.longitude = longitude;
	}

	public void setPostalCode(String postalCode)
	{
		this.postalCode = postalCode;
	}

	public void setState(String state)
	{
		this.state = state;
	}
}
