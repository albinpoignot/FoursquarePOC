package com.albinpoignot.foursquarepoc.network.entities;

/**
 * Created by Albin on 14/10/2015.
 */
public class VenueSearchResponse {

    private VenueSearchResponseContent response;

    public VenueSearchResponseContent getResponseField() {
        return response;
    }

    public void setResponseField(VenueSearchResponseContent venueSearchResponseContent) {
        this.response = venueSearchResponseContent;
    }
}
