package com.albinpoignot.foursquarepoc.network.entities;

import com.albinpoignot.foursquarepoc.models.CompactVenue;

import java.util.List;

/**
 * Created by Albin on 14/10/2015.
 */
public class VenueSearchResponseContent {

    private List<CompactVenue> venues;

    public List<CompactVenue> getCompactVenues() {
        return venues;
    }

    public void setCompactVenues(List<CompactVenue> compactVenues) {
        this.venues = compactVenues;
    }
}
