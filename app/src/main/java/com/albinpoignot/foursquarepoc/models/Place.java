package com.albinpoignot.foursquarepoc.models;

/**
 * Created by Albin on 14/10/2015.
 */
public class Place extends LightPlace
{
	private String description;

	private String url;

	private String status;

	private String price;

	private Float rating;

	private String pictureUrl;

	public String getDescription()
	{
		return description;
	}

	public String getPictureUrl()
	{
		return pictureUrl;
	}

	public String getPrice()
	{
		return price;
	}

	public Float getRating()
	{
		return rating;
	}

	public String getStatus()
	{
		return status;
	}

	public String getUrl()
	{
		return url;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public void setPictureUrl(String pictureUrl)
	{
		this.pictureUrl = pictureUrl;
	}

	public void setPrice(String price)
	{
		this.price = price;
	}

	public void setRating(Float rating)
	{
		this.rating = rating;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}
}
