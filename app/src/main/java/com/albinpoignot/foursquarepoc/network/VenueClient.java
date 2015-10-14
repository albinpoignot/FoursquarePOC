package com.albinpoignot.foursquarepoc.network;

import com.albinpoignot.foursquarepoc.network.entities.VenueSearchResponse;

import retrofit.http.GET;
import retrofit.http.Query;

/**
 * A client to request the Venue part of the Foursquare's API
 * Created by Albin on 14/10/2015.
 */
public interface VenueClient
{

    @GET("/venues/search")
    VenueSearchResponse searchNearestVenues(@Query("near")String near);

}
