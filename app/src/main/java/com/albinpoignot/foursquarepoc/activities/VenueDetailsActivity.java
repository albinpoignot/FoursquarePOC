package com.albinpoignot.foursquarepoc.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.albinpoignot.foursquarepoc.R;
import com.albinpoignot.foursquarepoc.models.Venue;
import com.albinpoignot.foursquarepoc.network.listeners.GetVenuesListener;
import com.albinpoignot.foursquarepoc.services.VenueAsyncTask;

/**
 * Created by Albin POIGNOT on 15/10/15.
 */
public class VenueDetailsActivity extends Activity implements GetVenuesListener
{
	public static final String VENUE_ID_TAG = "VenueDetailsActivity.venueId";

	private Venue currentVenue;

	private TextView txtName;
	private TextView txtLocation;
	private TextView txtDescription;
	private TextView txtUrl;
	private TextView txtHours;
	private TextView txtPrice;
	private TextView txtRating;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_venue_details);

		txtName = (TextView)findViewById(R.id.venue_details_name);
		txtLocation = (TextView)findViewById(R.id.venue_details_location);
		txtDescription = (TextView)findViewById(R.id.venue_details_description);
		txtUrl = (TextView)findViewById(R.id.venue_details_url);
		txtHours = (TextView)findViewById(R.id.venue_details_hours);
		txtPrice = (TextView)findViewById(R.id.venue_details_price);
		txtRating = (TextView)findViewById(R.id.venue_details_rating);
	}

	@Override
	protected void onResume()
	{
		super.onResume();

		if(currentVenue != null)
		{
			setViewsContent();
		}
		else
		{
			Intent intent = getIntent();
			if(intent != null)
			{
				String currentVenueId = intent.getStringExtra(VENUE_ID_TAG);

				VenueAsyncTask asyncTask = new VenueAsyncTask(this);
				asyncTask.execute(currentVenueId);
			}
		}
	}

	@Override
	public void onVenueReceived(Venue venue)
	{
		currentVenue = venue;
		setViewsContent();
	}

	private void setViewsContent()
	{
		if(currentVenue != null)
		{
			if(currentVenue.getName() != null)
			{
				txtName.setText(currentVenue.getName());
			}

			if(currentVenue.getLocation() != null)
			{
				txtLocation.setText(currentVenue.getLocation().getAddress());
			}

			if(currentVenue.getDescription() != null)
			{
				txtDescription.setText(currentVenue.getDescription());
			}

			if(currentVenue.getUrl() != null)
			{
				txtUrl.setText(currentVenue.getUrl());
			}

			if(currentVenue.getHours() != null)
			{
				txtHours.setText(currentVenue.getHours().getStatus());
			}

			if(currentVenue.getPrice() != null)
			{
				txtPrice.setText(currentVenue.getPrice().getMessage());
			}

			if(currentVenue.getRating() != null)
			{
				txtRating.setText(String.format("%.1f", currentVenue.getRating()));
			}
		}
	}
}
