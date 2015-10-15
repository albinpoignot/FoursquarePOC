package com.albinpoignot.foursquarepoc.network.entities;

import com.albinpoignot.foursquarepoc.models.Place;

/**
 * Created by Albin on 15/10/2015.
 */
public class VenueResponseContent
{
    private FoursquareVenue venue;

    public FoursquareVenue getVenue()
    {
        return venue;
    }

    public void setVenue(FoursquareVenue venue)
    {
        this.venue = venue;
    }
}
