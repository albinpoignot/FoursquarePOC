package com.albinpoignot.foursquarepoc.services;

import android.os.AsyncTask;

import com.albinpoignot.foursquarepoc.models.Venue;
import com.albinpoignot.foursquarepoc.network.FoursquareServiceGenerator;
import com.albinpoignot.foursquarepoc.network.listeners.GetVenuesListener;
import com.albinpoignot.foursquarepoc.network.clients.VenueClient;
import com.albinpoignot.foursquarepoc.network.entities.VenueResponseContent;


/**
 * Created by Albin on 15/10/2015.
 */
public class VenueAsyncTask extends AsyncTask<String, Void, Venue>
{
    GetVenuesListener listener;

    public VenueAsyncTask(GetVenuesListener listener)
    {
        this.listener = listener;
    }

    @Override
    protected Venue doInBackground(String... params)
    {
        VenueClient venueClient = FoursquareServiceGenerator.createService(VenueClient.class);

        String id;
        if(params.length > 0)
        {
            id = params[0];
        }
        else
        {
            id = "";
        }

        VenueResponseContent venueResponseContent = venueClient.getVenue(id).getResponseField();
        return venueResponseContent.getVenue();
    }

    @Override
    protected void onPostExecute(Venue venue)
    {
        if(listener != null)
        {
            listener.onVenueReceived(venue);
        }
    }
}
