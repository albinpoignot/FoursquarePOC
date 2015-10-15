package com.albinpoignot.foursquarepoc.services;

import android.os.AsyncTask;

import com.albinpoignot.foursquarepoc.models.LightPlace;
import com.albinpoignot.foursquarepoc.network.FoursquareServiceGenerator;
import com.albinpoignot.foursquarepoc.network.entities.EntityAdapter;
import com.albinpoignot.foursquarepoc.network.listeners.NearestVenuesListener;
import com.albinpoignot.foursquarepoc.network.clients.VenueClient;
import com.albinpoignot.foursquarepoc.network.entities.VenueSearchResponseContent;

import java.util.List;

/**
 * Created by Albin on 14/10/2015.
 */
public class NearestPlacesAsyncTask extends AsyncTask<String, Void, List<LightPlace>>
{
    // TODO Ensure this is the best way to do it
    NearestVenuesListener listener;

    public NearestPlacesAsyncTask(NearestVenuesListener listener)
    {
        this.listener = listener;
    }

    @Override
    protected List<LightPlace> doInBackground(String... params)
    {
        VenueClient venueClient = FoursquareServiceGenerator.createService(VenueClient.class);

        String address;
        if(params.length > 0)
        {
            address = params[0];
        }
        else
        {
            address = "";
        }

		String categoryId = "4d4b7105d754a06374d81259";

        VenueSearchResponseContent venueSearchResponseContent = venueClient.searchNearestVenues(address, 10, categoryId).getResponseField();
        return EntityAdapter.adapt(venueSearchResponseContent.getCompactVenues());
    }

    @Override
    protected void onPostExecute(List<LightPlace> lightPlaceList)
    {
        if(listener != null)
        {
            listener.onNearestVenuesReceived(lightPlaceList);
        }
    }
}
