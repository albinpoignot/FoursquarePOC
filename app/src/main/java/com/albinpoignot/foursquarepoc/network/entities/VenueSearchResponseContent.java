package com.albinpoignot.foursquarepoc.network.entities;

import java.util.List;

/**
 * Foursquare entity holding a Venue list stored in a response
 * Created by Albin on 14/10/2015.
 */
public class VenueSearchResponseContent
{
    private List<FoursquareCompactVenue> venues;

    public List<FoursquareCompactVenue> getCompactVenues() {
        return venues;
    }

    public void setCompactVenues(List<FoursquareCompactVenue> lightPlaces) {
        this.venues = lightPlaces;
    }
}
