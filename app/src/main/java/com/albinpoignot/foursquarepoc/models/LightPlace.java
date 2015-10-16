package com.albinpoignot.foursquarepoc.models;

/**
 * Entity storing basic information about a place.
 * Created by Albin on 14/10/2015.
 */
public class LightPlace
{
	/**
	 * The ID of the place
	 */
    protected String id;

	/**
	 * The name of the place
	 */
	protected String name;

	/**
	 * The location of the place
	 */
	protected Location location;

	/**
	 * The category of the place
	 */
	protected String category;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Location getLocation()
	{
		return location;
	}

	public void setLocation(Location location)
	{
		this.location = location;
	}

	public String getCategory()
	{
		return category;
	}

	public void setCategory(String category)
	{
		this.category = category;
	}
}
