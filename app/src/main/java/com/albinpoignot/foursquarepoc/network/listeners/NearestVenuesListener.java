package com.albinpoignot.foursquarepoc.network.listeners;

import com.albinpoignot.foursquarepoc.models.LightPlace;

import java.util.List;

/**
 * Created by Albin on 14/10/2015.
 */
public interface NearestVenuesListener {
    void onNearestVenuesReceived(List<LightPlace> lightPlaceList);
}
