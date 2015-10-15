package com.albinpoignot.foursquarepoc.models;

import java.util.List;

/**
 * Created by Albin on 14/10/2015.
 */
public class CompactVenue
{
    private String id;

    private String name;

    private Location location;

    private List<Category> categories;

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

    public List<Category> getCategories()
    {
        return categories;
    }

    public void setCategories(List<Category> categories)
    {
        this.categories = categories;
    }

    @Override
    public String toString()
    {
        return "CompactVenue{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", location=" + location +
                ", categories=" + categories +
                '}';
    }
}
