package com.albinpoignot.foursquarepoc.activities;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.albinpoignot.foursquarepoc.R;
import com.albinpoignot.foursquarepoc.adapters.NearestVenuesAdapter;
import com.albinpoignot.foursquarepoc.models.CompactVenue;
import com.albinpoignot.foursquarepoc.network.NearestVenuesListener;
import com.albinpoignot.foursquarepoc.services.NearestVenuesAsyncTask;

import java.util.List;

public class VenuesListActivity extends ListActivity implements NearestVenuesListener
{
    private NearestVenuesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venues_list);

        adapter = new NearestVenuesAdapter(this);
        setListAdapter(adapter);

		NearestVenuesAsyncTask asyncTask = new NearestVenuesAsyncTask(this);
		//asyncTask.execute("7248 Rue Saint-Urbain, Montréal, Canada");
		asyncTask.execute("45.533887, -73.620208");
    }

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id)
	{
		super.onListItemClick(l, v, position, id);

		CompactVenue venue = (CompactVenue)adapter.getItem(position);

		Intent intent = new Intent(this, VenueDetailsActivity.class);
		intent.putExtra(VenueDetailsActivity.VENUE_ID_TAG, venue.getId());
		startActivity(intent);
	}

	@Override
    public void onNearestVenuesReceived(List<CompactVenue> compactVenueList)
    {
        adapter.setCompactVenues(compactVenueList);
    }
}
