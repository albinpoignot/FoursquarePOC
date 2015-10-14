package com.albinpoignot.foursquarepoc.network;

import com.albinpoignot.foursquarepoc.models.CompactVenue;

import java.util.List;

/**
 * Created by Albin on 14/10/2015.
 */
public interface NearestVenuesListener {
    void onNearestVenuesReceived(List<CompactVenue> compactVenueList);
}
