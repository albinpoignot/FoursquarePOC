package com.albinpoignot.foursquarepoc.network;

import com.albinpoignot.foursquarepoc.network.entities.FoursquareResponse;
import com.albinpoignot.foursquarepoc.network.entities.VenueResponseContent;
import com.albinpoignot.foursquarepoc.network.entities.VenueSearchResponseContent;

import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * A client to request the Venue part of the Foursquare's API
 * Created by Albin on 14/10/2015.
 */
public interface VenueClient
{

    @GET("/venues/search")
    FoursquareResponse<VenueSearchResponseContent> searchNearestVenues(@Query("near")String near, @Query("limit")Integer limit);

    @GET("/venues/{id}")
    FoursquareResponse<VenueResponseContent> getVenue(@Path("id")String id);
}
