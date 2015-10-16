package com.albinpoignot.foursquarepoc.network.entities;

/**
 * Entity storing information on a picture about a Foursquare venue
 * Created by Albin POIGNOT on 16/10/15.
 */
public class FoursquarePhotoItem
{
    private String id;

    private String prefix;

    private String suffix;

    private Integer width;

    private Integer weight;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getPrefix()
    {
        return prefix;
    }

    public void setPrefix(String prefix)
    {
        this.prefix = prefix;
    }

    public String getSuffix()
    {
        return suffix;
    }

    public void setSuffix(String suffix)
    {
        this.suffix = suffix;
    }

    public Integer getWidth()
    {
        return width;
    }

    public void setWidth(Integer width)
    {
        this.width = width;
    }

    public Integer getWeight()
    {
        return weight;
    }

    public void setWeight(Integer weight)
    {
        this.weight = weight;
    }
}
