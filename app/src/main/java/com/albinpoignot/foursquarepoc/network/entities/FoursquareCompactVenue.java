package com.albinpoignot.foursquarepoc.network.entities;

import java.util.List;

/**
 * Created by Albin on 14/10/2015.
 */
public class FoursquareCompactVenue
{
    protected String id;

	protected String name;

	protected FoursquareLocation location;

	protected List<FoursquareCategory> categories;

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

    public FoursquareLocation getLocation()
    {
        return location;
    }

    public void setLocation(FoursquareLocation location)
    {
        this.location = location;
    }

    public List<FoursquareCategory> getCategories()
    {
        return categories;
    }

    public void setCategories(List<FoursquareCategory> categories)
    {
        this.categories = categories;
    }

    @Override
    public String toString()
    {
        return "FoursquareCompactVenue{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", location=" + location +
                ", categories=" + categories +
                '}';
    }
}
