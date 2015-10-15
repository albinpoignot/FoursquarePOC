package com.albinpoignot.foursquarepoc.models;

import java.util.List;

/**
 * Created by Albin on 14/10/2015.
 */
public class LightPlace
{
    protected String id;

	protected String name;

	protected Location location;

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
