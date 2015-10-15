package com.albinpoignot.foursquarepoc.network;

import com.albinpoignot.foursquarepoc.models.Venue;

/**
 * Created by Albin on 15/10/2015.
 */
public interface GetVenuesListener
{
    void onVenueReceived(Venue venue);
}
