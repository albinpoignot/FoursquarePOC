package com.albinpoignot.foursquarepoc.network.entities;

import com.albinpoignot.foursquarepoc.models.LightPlace;

import java.util.List;

/**
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
