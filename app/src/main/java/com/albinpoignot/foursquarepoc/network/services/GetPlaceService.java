package com.albinpoignot.foursquarepoc.network.services;

import com.albinpoignot.foursquarepoc.R;
import com.albinpoignot.foursquarepoc.models.Place;
import com.albinpoignot.foursquarepoc.network.FoursquareClientGenerator;
import com.albinpoignot.foursquarepoc.network.clients.VenueClient;
import com.albinpoignot.foursquarepoc.network.entities.EntityAdapter;
import com.albinpoignot.foursquarepoc.network.entities.FoursquareResponse;
import com.albinpoignot.foursquarepoc.network.entities.FoursquareVenue;
import com.albinpoignot.foursquarepoc.network.entities.VenueResponseContent;
import com.albinpoignot.foursquarepoc.network.listeners.GetPlaceListener;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Albin POIGNOT on 15/10/15.
 */
public class GetPlaceService extends BaseService implements Callback<FoursquareResponse<VenueResponseContent>>
{
	private GetPlaceListener getPlaceListener;

	public GetPlaceService(GetPlaceListener listener)
	{
		this.getPlaceListener = listener;
	}

	public void getPlace(String id)
	{
		VenueClient venueClient = FoursquareClientGenerator.createClient(VenueClient.class);
		venueClient.getVenue(id, this);
	}

	@Override
	public void success(FoursquareResponse<VenueResponseContent> venueResponseContentFoursquareResponse, Response response)
	{
		if(getPlaceListener != null)
		{
			VenueResponseContent responseContent = venueResponseContentFoursquareResponse.getResponseField();
			if(responseContent != null)
			{
				FoursquareVenue foursquareVenue = responseContent.getVenue();
				if(foursquareVenue != null)
				{
					Place place = EntityAdapter.adapt(foursquareVenue);
					getPlaceListener.onPlaceReceived(place);
				}
				else
				{
					getPlaceListener.onError(R.string.place_not_found);
				}
			}
			else
			{
				getPlaceListener.onError(R.string.place_not_found);
			}

		}
	}

	@Override
	public void failure(RetrofitError error)
	{
		getPlaceListener.onError(getErrorResourceId(error.getKind()));
	}
}
