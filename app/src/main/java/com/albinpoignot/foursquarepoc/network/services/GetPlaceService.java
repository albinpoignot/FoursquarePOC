package com.albinpoignot.foursquarepoc.network.services;

import com.albinpoignot.foursquarepoc.R;
import com.albinpoignot.foursquarepoc.models.Place;
import com.albinpoignot.foursquarepoc.network.FoursquareClientGenerator;
import com.albinpoignot.foursquarepoc.network.clients.FoursquareVenueClient;
import com.albinpoignot.foursquarepoc.network.entities.EntityAdapter;
import com.albinpoignot.foursquarepoc.network.entities.FoursquareResponse;
import com.albinpoignot.foursquarepoc.network.entities.FoursquareVenue;
import com.albinpoignot.foursquarepoc.network.entities.VenueResponseContent;
import com.albinpoignot.foursquarepoc.network.listeners.GetPlaceListener;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Service used to get fully detailed Places.
 * Created by Albin POIGNOT on 15/10/15.
 */
public class GetPlaceService extends BaseService implements Callback<FoursquareResponse<VenueResponseContent>>
{
    /**
     * The listener to call after the operation
     */
    private GetPlaceListener getPlaceListener;

    /**
     * Constructor
     *
     * @param listener the listener that will be called
     */
    public GetPlaceService(GetPlaceListener listener)
    {
        this.getPlaceListener = listener;
    }

    /**
     * Get a Place
     *
     * @param id the id of the Place
     */
    public void getPlace(String id)
    {
        FoursquareVenueClient foursquareVenueClient = FoursquareClientGenerator.createClient(FoursquareVenueClient.class);
        foursquareVenueClient.getVenue(id, this);
    }

    @Override
    public void success(FoursquareResponse<VenueResponseContent> venueResponseContentFoursquareResponse, Response response)
    {
        if (getPlaceListener != null)
        {
            VenueResponseContent responseContent = venueResponseContentFoursquareResponse.getResponseField();
            if (responseContent != null)
            {
                FoursquareVenue foursquareVenue = responseContent.getVenue();
                if (foursquareVenue != null)
                {
                    Place place = EntityAdapter.adapt(foursquareVenue);
                    getPlaceListener.onPlaceReceived(place);
                }
                else
                {
                    getPlaceListener.onError(ServiceError.NOT_FOUND);
                }
            }
            else
            {
                getPlaceListener.onError(ServiceError.NOT_FOUND);
            }

        }
    }

    @Override
    public void failure(RetrofitError error)
    {
        getPlaceListener.onError(getInternalError(error.getKind()));
    }
}
