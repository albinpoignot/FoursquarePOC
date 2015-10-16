package com.albinpoignot.foursquarepoc.network.services;

import com.albinpoignot.foursquarepoc.models.LightPlace;
import com.albinpoignot.foursquarepoc.network.FoursquareClientGenerator;
import com.albinpoignot.foursquarepoc.network.clients.FoursquareVenueClient;
import com.albinpoignot.foursquarepoc.network.entities.EntityAdapter;
import com.albinpoignot.foursquarepoc.network.entities.FoursquareCompactVenue;
import com.albinpoignot.foursquarepoc.network.entities.FoursquareResponse;
import com.albinpoignot.foursquarepoc.network.entities.VenueSearchResponseContent;
import com.albinpoignot.foursquarepoc.network.listeners.SearchPlacesServiceListener;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Albin POIGNOT on 15/10/15.
 */
public class SearchPlacesService extends BaseService implements Callback<FoursquareResponse<VenueSearchResponseContent>>
{
	private final static String CATEGORY_FOOD = "4d4b7105d754a06374d81259";

	private SearchPlacesServiceListener searchPlacesServiceListener;

	public SearchPlacesService(SearchPlacesServiceListener listener)
	{
		this.searchPlacesServiceListener = listener;
	}

	public void getNearestFoodPlaces(String location)
	{
		FoursquareVenueClient foursquareVenueClient = FoursquareClientGenerator.createClient(FoursquareVenueClient.class);
		foursquareVenueClient.searchNearestVenues(location, 10, CATEGORY_FOOD, this);
	}

	@Override
	public void success(FoursquareResponse<VenueSearchResponseContent> foursquareResponse, Response response)
	{
		if(searchPlacesServiceListener != null)
		{
			VenueSearchResponseContent responseContent = foursquareResponse.getResponseField();
			List<LightPlace> lightPlaces;
			if(responseContent != null)
			{
				List<FoursquareCompactVenue> foursquareCompactVenues = responseContent.getCompactVenues();
				if(foursquareCompactVenues != null)
				{
					 lightPlaces = EntityAdapter.adapt(foursquareCompactVenues);
				}
				else
				{
					lightPlaces = new ArrayList<>();
				}
			}
			else
			{
				lightPlaces = new ArrayList<>();
			}
			searchPlacesServiceListener.onPlacesReceived(lightPlaces);
		}
	}

	@Override
	public void failure(RetrofitError error)
	{
		searchPlacesServiceListener.onError(getErrorResourceId(error.getKind()));
	}
}
