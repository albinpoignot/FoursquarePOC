package com.albinpoignot.foursquarepoc.activities;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.albinpoignot.foursquarepoc.R;
import com.albinpoignot.foursquarepoc.adapters.NearestVenuesAdapter;
import com.albinpoignot.foursquarepoc.models.LightPlace;
import com.albinpoignot.foursquarepoc.network.listeners.SearchPlacesServiceListener;
import com.albinpoignot.foursquarepoc.services.SearchPlacesService;

import java.util.List;

public class PlacesListActivity extends ListActivity implements SearchPlacesServiceListener
{
    private NearestVenuesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places_list);

        adapter = new NearestVenuesAdapter(this);
        setListAdapter(adapter);

		SearchPlacesService searchPlacesService = new SearchPlacesService(this);
		searchPlacesService.getNearestFoodPlaces("45.533887, -73.620208");
    }

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id)
	{
		super.onListItemClick(l, v, position, id);

		LightPlace venue = (LightPlace)adapter.getItem(position);

		Intent intent = new Intent(this, PlaceDetailsActivity.class);
		intent.putExtra(PlaceDetailsActivity.VENUE_ID_TAG, venue.getId());
		startActivity(intent);
	}


	@Override
	public void onPlacesReceived(List<LightPlace> lightPlaceList)
	{
		adapter.setLightPlaces(lightPlaceList);
	}

	@Override
	public void onError(Integer resId)
	{
		Toast.makeText(this, resId, Toast.LENGTH_LONG).show();
	}
}
