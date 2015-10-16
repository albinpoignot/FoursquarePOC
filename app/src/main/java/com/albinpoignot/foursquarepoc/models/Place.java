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

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Place place = (Place) o;

        if (description != null ? !description.equals(place.description) : place.description != null)
            return false;
        if (url != null ? !url.equals(place.url) : place.url != null) return false;
        if (status != null ? !status.equals(place.status) : place.status != null) return false;
        if (price != null ? !price.equals(place.price) : place.price != null) return false;
        if (rating != null ? !rating.equals(place.rating) : place.rating != null) return false;
        return !(pictureUrl != null ? !pictureUrl.equals(place.pictureUrl) : place.pictureUrl != null);

    }

    @Override
    public int hashCode()
    {
        int result = super.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        result = 31 * result + (pictureUrl != null ? pictureUrl.hashCode() : 0);
        return result;
    }

    @Override
    public String toString()
    {
        return "Place{" +
                "description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", status='" + status + '\'' +
                ", price='" + price + '\'' +
                ", rating=" + rating +
                ", pictureUrl='" + pictureUrl + '\'' +
                '}';
    }
}
