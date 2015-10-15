package com.albinpoignot.foursquarepoc.models;

/**
 * Created by Albin on 14/10/2015.
 */
public class Venue extends CompactVenue
{
    private String description;

    private String url;

    private Hour hours;

    private Integer price;

    private Integer rating;

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public Hour getHours()
    {
        return hours;
    }

    public void setHours(Hour hours)
    {
        this.hours = hours;
    }

    public Integer getPrice()
    {
        return price;
    }

    public void setPrice(Integer price)
    {
        this.price = price;
    }

    public Integer getRating()
    {
        return rating;
    }

    public void setRating(Integer rating)
    {
        this.rating = rating;
    }
}
