package com.albinpoignot.foursquarepoc.network.listeners;

import com.albinpoignot.foursquarepoc.models.LightPlace;

import java.util.List;

/**
 * Listener called by SearchPlacesService
 * Created by Albin on 14/10/2015.
 */
public interface SearchPlacesServiceListener extends GenericServiceListener
{
    /**
     * Called when a result is received
     *
     * @param lightPlaceList the list of LightPlaces received
     */
    void onPlacesReceived(List<LightPlace> lightPlaceList);
}
