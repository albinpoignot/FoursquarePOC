package com.albinpoignot.foursquarepoc.network.clients;

import com.albinpoignot.foursquarepoc.models.LightPlace;
import com.albinpoignot.foursquarepoc.network.entities.FoursquareResponse;
import com.albinpoignot.foursquarepoc.network.entities.VenueResponseContent;
import com.albinpoignot.foursquarepoc.network.entities.VenueSearchResponseContent;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * A client to request the FoursquareVenue part of the Foursquare's API
 * Created by Albin on 14/10/2015.
 */
public interface VenueClient
{

    @GET("/venues/search")
    void searchNearestVenues(@Query("near")String near, @Query("limit")Integer limit, @Query("categoryId")String categoryId, Callback<FoursquareResponse<VenueSearchResponseContent>> callback);

    @GET("/venues/{id}")
    void getVenue(@Path("id")String id, Callback<FoursquareResponse<VenueResponseContent>> callback);
}
