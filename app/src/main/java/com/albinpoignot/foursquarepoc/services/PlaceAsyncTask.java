package com.albinpoignot.foursquarepoc.services;

import android.os.AsyncTask;

import com.albinpoignot.foursquarepoc.models.Place;
import com.albinpoignot.foursquarepoc.network.FoursquareServiceGenerator;
import com.albinpoignot.foursquarepoc.network.entities.EntityAdapter;
import com.albinpoignot.foursquarepoc.network.listeners.GetVenuesListener;
import com.albinpoignot.foursquarepoc.network.clients.VenueClient;
import com.albinpoignot.foursquarepoc.network.entities.VenueResponseContent;


/**
 * Created by Albin on 15/10/2015.
 */
public class PlaceAsyncTask extends AsyncTask<String, Void, Place>
{
    GetVenuesListener listener;

    public PlaceAsyncTask(GetVenuesListener listener)
    {
        this.listener = listener;
    }

    @Override
    protected Place doInBackground(String... params)
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
        return EntityAdapter.adapt(venueResponseContent.getVenue());
    }

    @Override
    protected void onPostExecute(Place venue)
    {
        if(listener != null)
        {
            listener.onVenueReceived(venue);
        }
    }
}
