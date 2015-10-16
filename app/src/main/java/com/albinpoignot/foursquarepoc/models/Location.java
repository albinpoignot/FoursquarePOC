package com.albinpoignot.foursquarepoc.models;

/**
 * Entity storing information about location of a place
 * Created by Albin on 14/10/2015.
 */
public class Location
{
    /**
     * The address of the place
     */
    private String address;

    /**
     * The distance of the place from the original given point
     */
    private Integer distance;

    /**
     * The city of the place
     */
    private String city;

    /**
     * The country of the place
     */
    private String country;

    /**
     * The longitude of the place
     */
    private Float longitude;

    /**
     * The latitude of the place
     */
    private Float latitude;

    public String getAddress()
    {
        return address;
    }

    public String getCity()
    {
        return city;
    }

    public String getCountry()
    {
        return country;
    }

    public Integer getDistance()
    {
        return distance;
    }

    public Float getLatitude()
    {
        return latitude;
    }

    public Float getLongitude()
    {
        return longitude;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public void setDistance(Integer distance)
    {
        this.distance = distance;
    }

    public void setLatitude(Float latitude)
    {
        this.latitude = latitude;
    }

    public void setLongitude(Float longitude)
    {
        this.longitude = longitude;
    }
}
