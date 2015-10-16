package com.albinpoignot.foursquarepoc.network.entities;

import java.util.List;

/**
 * Entity storing information about the location of Foursquare Venue
 * Created by Albin on 14/10/2015.
 */
public class FoursquareLocation
{
    private String address;

    private Float lat;

    private Float lng;

    private Integer distance;

    private String city;

    private String country;

    private List<String> formattedAddress;

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public Float getLat()
    {
        return lat;
    }

    public void setLat(Float lat)
    {
        this.lat = lat;
    }

    public Float getLng()
    {
        return lng;
    }

    public void setLng(Float lng)
    {
        this.lng = lng;
    }

    public Integer getDistance()
    {
        return distance;
    }

    public void setDistance(Integer distance)
    {
        this.distance = distance;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public List<String> getFormattedAddress()
    {
        return formattedAddress;
    }

    public void setFormattedAddress(List<String> formattedAddress)
    {
        this.formattedAddress = formattedAddress;
    }
}
