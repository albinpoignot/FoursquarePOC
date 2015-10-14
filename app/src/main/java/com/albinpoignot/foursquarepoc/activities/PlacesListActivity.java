package com.albinpoignot.foursquarepoc.activities;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.albinpoignot.foursquarepoc.R;
import com.albinpoignot.foursquarepoc.adapters.NearestVenuesAdapter;
import com.albinpoignot.foursquarepoc.models.CompactVenue;
import com.albinpoignot.foursquarepoc.network.NearestVenuesListener;
import com.albinpoignot.foursquarepoc.services.NearestVenuesAsyncTask;

import java.util.List;

public class PlacesListActivity extends ListActivity implements NearestVenuesListener
{
    private NearestVenuesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places_list);

        adapter = new NearestVenuesAdapter(this);
        setListAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        NearestVenuesAsyncTask asyncTask = new NearestVenuesAsyncTask(this);
        asyncTask.execute("Chicago, IL");
    }

    @Override
    public void onNearestVenuesReceived(List<CompactVenue> compactVenueList)
    {
        adapter.setCompactVenues(compactVenueList);
    }
}
