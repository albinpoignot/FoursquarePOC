package com.albinpoignot.foursquarepoc.models;

/**
 * Entity storing full details about a place
 * Created by Albin on 14/10/2015.
 */
public class Place extends LightPlace
{
    /**
     * The description of the place
     */
    private String description;

    /**
     * The URL of the place's web site
     */
    private String url;

    /**
     * The status of the place (open or close)
     */
    private String status;

    /**
     * The price range of the place
     */
    private String price;

    /**
     * The rating of the place
     */
    private Float rating;

    /**
     * The URL of picture about the place
     */
    private String pictureUrl;

    public String getDescription()
    {
        return description;
    }

    public String getPictureUrl()
    {
        return pictureUrl;
    }

    public String getPrice()
    {
        return price;
    }

    public Float getRating()
    {
        return rating;
    }

    public String getStatus()
    {
        return status;
    }

    public String getUrl()
    {
        return url;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public void setPictureUrl(String pictureUrl)
    {
        this.pictureUrl = pictureUrl;
    }

    public void setPrice(String price)
    {
        this.price = price;
    }

    public void setRating(Float rating)
    {
        this.rating = rating;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }
}
