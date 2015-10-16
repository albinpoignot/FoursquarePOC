package com.albinpoignot.foursquarepoc.network.entities;

/**
 * Fully detailed Foursquare place
 * Created by Albin on 14/10/2015.
 */
public class FoursquareVenue extends FoursquareCompactVenue
{
	private String description;

	private String url;

	private FoursquareHour hours;

	private FoursquarePrice price;

	private Float rating;

	private FoursquarePhotos photos;

	private FoursquareLocation location;

	public FoursquareLocation getLocation()
	{
		return location;
	}

	public void setLocation(FoursquareLocation location)
	{
		this.location = location;
	}

	public String getDescription()
	{
		return description;
	}

	public FoursquareHour getHours()
	{
		return hours;
	}

	public FoursquarePhotos getPhotos()
	{
		return photos;
	}

	public FoursquarePrice getPrice()
	{
		return price;
	}

	public Float getRating()
	{
		return rating;
	}

	public String getUrl()
	{
		return url;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public void setHours(FoursquareHour hours)
	{
		this.hours = hours;
	}

	public void setPhotos(FoursquarePhotos photos)
	{
		this.photos = photos;
	}

	public void setPrice(FoursquarePrice price)
	{
		this.price = price;
	}

	public void setRating(Float rating)
	{
		this.rating = rating;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}
}
