package com.albinpoignot.foursquarepoc.network.entities;

import java.util.List;

/**
 * Foursquare lightly detailed venue
 * Created by Albin on 14/10/2015.
 */
public class FoursquareCompactVenue
{
    protected String id;

	protected String name;

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

    public List<FoursquareCategory> getCategories()
    {
        return categories;
    }

}
