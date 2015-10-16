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

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Location location = (Location) o;

        if (address != null ? !address.equals(location.address) : location.address != null)
            return false;
        if (distance != null ? !distance.equals(location.distance) : location.distance != null)
            return false;
        if (city != null ? !city.equals(location.city) : location.city != null) return false;
        if (country != null ? !country.equals(location.country) : location.country != null)
            return false;
        if (longitude != null ? !longitude.equals(location.longitude) : location.longitude != null)
            return false;
        return !(latitude != null ? !latitude.equals(location.latitude) : location.latitude != null);

    }

    @Override
    public int hashCode()
    {
        int result = address != null ? address.hashCode() : 0;
        result = 31 * result + (distance != null ? distance.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        return result;
    }

    @Override
    public String toString()
    {
        return "Location{" +
                "address='" + address + '\'' +
                ", distance=" + distance +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }
}
