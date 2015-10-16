package com.albinpoignot.foursquarepoc.network.listeners;

import com.albinpoignot.foursquarepoc.models.Place;

/**
 * Listener called by GetPlaceService
 * Created by Albin on 15/10/2015.
 */
public interface GetPlaceListener extends GenericServiceListener
{
    /**
     * Called when a result is received
     *
     * @param place the Place received
     */
    void onPlaceReceived(Place place);
}
