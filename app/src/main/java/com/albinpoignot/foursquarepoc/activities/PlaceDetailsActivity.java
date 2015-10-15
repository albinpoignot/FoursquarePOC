package com.albinpoignot.foursquarepoc.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.albinpoignot.foursquarepoc.R;
import com.albinpoignot.foursquarepoc.models.Place;
import com.albinpoignot.foursquarepoc.network.listeners.GetPlaceListener;
import com.albinpoignot.foursquarepoc.services.GetPlaceService;

/**
 * Created by Albin POIGNOT on 15/10/15.
 */
public class PlaceDetailsActivity extends Activity implements GetPlaceListener
{
	public static final String VENUE_ID_TAG = "PlaceDetailsActivity.venueId";

	private Place currentPlace;

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

		txtName = (TextView) findViewById(R.id.venue_details_name);
		txtLocation = (TextView) findViewById(R.id.venue_details_location);
		txtDescription = (TextView) findViewById(R.id.venue_details_description);
		txtUrl = (TextView) findViewById(R.id.venue_details_url);
		txtHours = (TextView) findViewById(R.id.venue_details_hours);
		txtPrice = (TextView) findViewById(R.id.venue_details_price);
		txtRating = (TextView) findViewById(R.id.venue_details_rating);
	}

	@Override
	public void onError(Integer resId)
	{
		Toast.makeText(this, resId, Toast.LENGTH_LONG).show();
		finish();
	}

	@Override
	public void onPlaceReceived(Place place)
	{
		currentPlace = place;
		setViewsContent();
	}

	@Override
	protected void onResume()
	{
		super.onResume();

		if (currentPlace != null)
		{
			setViewsContent();
		}
		else
		{
			Intent intent = getIntent();
			if (intent != null)
			{
				String currentPlaceId = intent.getStringExtra(VENUE_ID_TAG);

				GetPlaceService getPlaceService = new GetPlaceService(this);
				getPlaceService.getPlace(currentPlaceId);
			}
		}
	}

	private void setViewsContent()
	{
		if (currentPlace != null)
		{
			if (currentPlace.getName() != null)
			{
				txtName.setText(currentPlace.getName());
			}

			if (currentPlace.getLocation() != null)
			{
				txtLocation.setText(currentPlace.getLocation().getAddress());
			}

			if (currentPlace.getDescription() != null)
			{
				txtDescription.setText(currentPlace.getDescription());
			}

			if (currentPlace.getUrl() != null)
			{
				txtUrl.setText(currentPlace.getUrl());
			}

			if (currentPlace.getStatus() != null)
			{
				txtHours.setText(currentPlace.getStatus());
			}

			if (currentPlace.getPrice() != null)
			{
				txtPrice.setText(currentPlace.getPrice());
			}

			if (currentPlace.getRating() != null)
			{
				txtRating.setText(String.format("%.1f", currentPlace.getRating()));
			}
		}
	}
}
