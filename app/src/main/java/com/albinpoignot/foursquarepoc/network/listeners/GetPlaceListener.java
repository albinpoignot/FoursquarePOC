package com.albinpoignot.foursquarepoc.network.listeners;

import com.albinpoignot.foursquarepoc.models.Place;

/**
 * Created by Albin on 15/10/2015.
 */
public interface GetPlaceListener extends GenericServiceListener
{
    void onPlaceReceived(Place place);
}