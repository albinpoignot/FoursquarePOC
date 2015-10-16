package com.albinpoignot.foursquarepoc.activities;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.albinpoignot.foursquarepoc.R;
import com.albinpoignot.foursquarepoc.adapters.PlacesListAdapter;
import com.albinpoignot.foursquarepoc.models.LightPlace;
import com.albinpoignot.foursquarepoc.network.listeners.SearchPlacesServiceListener;
import com.albinpoignot.foursquarepoc.network.services.SearchPlacesService;
import com.albinpoignot.foursquarepoc.network.services.ServiceError;

import java.util.List;

/**
 * Activity showing a list of places
 * Created by Albin POIGNOT on 15/10/15.
 */
public class PlacesListActivity extends ListActivity implements SearchPlacesServiceListener
{
    /**
     * The address we are looking places around. Storing it here just in the context of this POC.
     */
    private static final String ADDRESS = "45.533887, -73.620208";

    /**
     * The list's adapter
     */
    private PlacesListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places_list);

        adapter = new PlacesListAdapter(this);
        setListAdapter(adapter);

        SearchPlacesService searchPlacesService = new SearchPlacesService(this);
        searchPlacesService.getNearestFoodPlaces(ADDRESS);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id)
    {
        super.onListItemClick(l, v, position, id);

        LightPlace place = (LightPlace) adapter.getItem(position);

        Intent intent = new Intent(this, PlaceDetailsActivity.class);
        intent.putExtra(PlaceDetailsActivity.VENUE_ID_TAG, place.getId());
        startActivity(intent);
    }


    @Override
    public void onPlacesReceived(List<LightPlace> lightPlaceList)
    {
        adapter.setLightPlaces(lightPlaceList);
    }

    @Override
    public void onError(ServiceError serviceError)
    {
        Integer resId;
        switch (serviceError)
        {
            case NETWORK_ERROR:
                resId = R.string.service_error_http_error;
                break;
            case NO_NETWORK_ERROR:
                resId = R.string.service_error_no_connection;
                break;
            default:
                resId = R.string.service_error_unknown_error;
                break;
        }
        Toast.makeText(this, resId, Toast.LENGTH_LONG).show();
    }
}
