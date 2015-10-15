package com.albinpoignot.foursquarepoc.network.listeners;

import com.albinpoignot.foursquarepoc.models.LightPlace;

import java.util.List;

import retrofit.Callback;

/**
 * Created by Albin on 14/10/2015.
 */
public interface SearchPlacesServiceListener extends GenericServiceListener
{
    void onPlacesReceived(List<LightPlace> lightPlaceList);
}
