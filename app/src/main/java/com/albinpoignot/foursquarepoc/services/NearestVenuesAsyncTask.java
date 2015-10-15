package com.albinpoignot.foursquarepoc.services;

import android.os.AsyncTask;

import com.albinpoignot.foursquarepoc.models.CompactVenue;
import com.albinpoignot.foursquarepoc.network.FoursquareServiceGenerator;
import com.albinpoignot.foursquarepoc.network.listeners.NearestVenuesListener;
import com.albinpoignot.foursquarepoc.network.clients.VenueClient;
import com.albinpoignot.foursquarepoc.network.entities.VenueSearchResponseContent;

import java.util.List;

/**
 * Created by Albin on 14/10/2015.
 */
public class NearestVenuesAsyncTask extends AsyncTask<String, Void, List<CompactVenue>>
{
    // TODO Ensure this is the best way to do it
    NearestVenuesListener listener;

    public NearestVenuesAsyncTask(NearestVenuesListener listener)
    {
        this.listener = listener;
    }

    @Override
    protected List<CompactVenue> doInBackground(String... params)
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
        return venueSearchResponseContent.getCompactVenues();
    }

    @Override
    protected void onPostExecute(List<CompactVenue> compactVenueList)
    {
        if(listener != null)
        {
            listener.onNearestVenuesReceived(compactVenueList);
        }
    }
}
