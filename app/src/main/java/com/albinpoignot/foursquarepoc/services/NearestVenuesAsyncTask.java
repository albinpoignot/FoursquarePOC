package com.albinpoignot.foursquarepoc.services;

import android.os.AsyncTask;
import android.util.Log;

import com.albinpoignot.foursquarepoc.models.CompactVenue;
import com.albinpoignot.foursquarepoc.network.FoursquareServiceGenerator;
import com.albinpoignot.foursquarepoc.network.NearestVenuesListener;
import com.albinpoignot.foursquarepoc.network.VenueClient;
import com.albinpoignot.foursquarepoc.network.entities.VenueSearchResponse;

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
        
        VenueSearchResponse compactVenuesList = venueClient.searchNearestVenues(address);

        return compactVenuesList.getResponseField().getCompactVenues();
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
