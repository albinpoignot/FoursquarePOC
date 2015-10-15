package com.albinpoignot.foursquarepoc.network.entities;

import com.albinpoignot.foursquarepoc.models.Venue;

import java.util.List;

/**
 * Created by Albin on 15/10/2015.
 */
public class VenueResponseContent
{
    private Venue venue;

    public Venue getVenue()
    {
        return venue;
    }

    public void setVenue(Venue venue)
    {
        this.venue = venue;
    }
}
