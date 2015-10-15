package com.albinpoignot.foursquarepoc.network.entities;

/**
 * Created by Albin on 14/10/2015.
 */
public class FoursquareVenue extends FoursquareCompactVenue
{
    private String description;

    private String url;

    private FoursquareHour hours;

    private FoursquarePrice price;

    private Float rating;

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

    public FoursquareHour getHours()
    {
        return hours;
    }

    public void setHours(FoursquareHour hours)
    {
        this.hours = hours;
    }

    public FoursquarePrice getPrice()
    {
        return price;
    }

    public void setPrice(FoursquarePrice price)
    {
        this.price = price;
    }

    public Float getRating()
    {
        return rating;
    }

    public void setRating(Float rating)
    {
        this.rating = rating;
    }
}
