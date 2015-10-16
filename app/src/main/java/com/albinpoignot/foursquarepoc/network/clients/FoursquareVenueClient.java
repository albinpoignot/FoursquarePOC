package com.albinpoignot.foursquarepoc.network.clients;

import com.albinpoignot.foursquarepoc.network.entities.FoursquareResponse;
import com.albinpoignot.foursquarepoc.network.entities.VenueResponseContent;
import com.albinpoignot.foursquarepoc.network.entities.VenueSearchResponseContent;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * A client to request the FoursquareVenue part of the Foursquare's API
 * Created by Albin on 14/10/2015.
 */
public interface FoursquareVenueClient
{

    /**
     * Get the nearest Venues around a given point
     * @param near the point you would like to search around (address or lng/lat)
     * @param limit the limit number or returned venues
     * @param categoryId the ID of the venue's category you are looking for
     * @param callback the callback to call when result is received
     */
    @GET("/venues/search")
    void searchNearestVenues(@Query("near")String near, @Query("limit")Integer limit, @Query("categoryId")String categoryId, Callback<FoursquareResponse<VenueSearchResponseContent>> callback);

    /**
     * Get the details of a particular Venue
     * @param id the ID of the Venue
     * @param callback the callback to call when result is received
     */
    @GET("/venues/{id}")
    void getVenue(@Path("id")String id, Callback<FoursquareResponse<VenueResponseContent>> callback);
}
