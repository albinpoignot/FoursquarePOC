package com.albinpoignot.foursquarepoc.network.entities;

/**
 * Foursquare's response holder
 * Created by Albin on 14/10/2015.
 */
public class FoursquareResponse<T>
{
    private T response;

    public T getResponseField()
    {
        return response;
    }

    public void setResponseField(T venueSearchResponseContent)
    {
        this.response = venueSearchResponseContent;
    }
}
