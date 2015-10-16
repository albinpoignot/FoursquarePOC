package com.albinpoignot.foursquarepoc.activities;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.albinpoignot.foursquarepoc.R;
import com.albinpoignot.foursquarepoc.models.Place;
import com.albinpoignot.foursquarepoc.network.listeners.GetPlaceListener;
import com.albinpoignot.foursquarepoc.network.services.GetPlaceService;
import com.squareup.picasso.Picasso;

import java.util.Locale;

/**
 * Created by Albin POIGNOT on 15/10/15.
 */
public class PlaceDetailsActivity extends Activity implements GetPlaceListener
{
	public static final String VENUE_ID_TAG = "PlaceDetailsActivity.venueId";

	private Place currentPlace;

	private TextView txtName;

	private TextView txtCategory;

	private TextView txtLocation;

	private TextView txtDescription;

	private TextView txtUrl;

	private TextView txtStatus;

	private TextView txtPrice;

	private TextView txtRating;

	private Button btnGoTo;

	private ImageView imgPhoto;

	private ProgressBar progressBar;

	private ViewGroup contentLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_place_details);

		txtName = (TextView) findViewById(R.id.place_details_name);
		txtCategory = (TextView) findViewById(R.id.place_details_type);
		txtLocation = (TextView) findViewById(R.id.place_details_location);
		txtDescription = (TextView) findViewById(R.id.place_details_description);
		txtUrl = (TextView) findViewById(R.id.place_details_url);
		txtStatus = (TextView) findViewById(R.id.place_details_hours);
		txtPrice = (TextView) findViewById(R.id.place_details_price);
		txtRating = (TextView) findViewById(R.id.place_details_rating);
		btnGoTo = (Button) findViewById(R.id.place_details_goto);
		imgPhoto = (ImageView) findViewById(R.id.place_details_photo);
		progressBar = (ProgressBar) findViewById(R.id.place_details_progress);
		contentLayout = (ViewGroup) findViewById(R.id.place_details_content_layout);

		ActionBar actionBar = getActionBar();
		if(actionBar != null)
		{
			actionBar.setDisplayHomeAsUpEnabled(true);
		}
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

				hideContent();

				GetPlaceService getPlaceService = new GetPlaceService(this);
				getPlaceService.getPlace(currentPlaceId);
			}
		}

		btnGoTo.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				if (currentPlace != null && currentPlace.getLocation() != null)
				{
					String address = currentPlace.getLocation().getAddress();
					address = address.concat(currentPlace.getLocation().getCity());
					address = address.concat(currentPlace.getLocation().getCountry());

					String uri = String.format(Locale.ENGLISH, "geo:%f,%f?q=%s(%s)", currentPlace.getLocation().getLatitude(), currentPlace.getLocation().getLongitude(), address, currentPlace.getName());
					Uri uriParsed = Uri.parse(uri);
					Intent intent = new Intent(Intent.ACTION_VIEW, uriParsed);
					startActivity(intent);
				}
			}
		});
	}

	private void setViewsContent()
	{
		if (currentPlace != null)
		{
			if (currentPlace.getName() != null)
			{
				txtName.setText(currentPlace.getName());
			}

			if(currentPlace.getCategory() != null)
			{
				txtCategory.setText(currentPlace.getCategory());
			}

			if (currentPlace.getLocation() != null && currentPlace.getLocation().getAddress() != null)
			{
				txtLocation.setText(currentPlace.getLocation().getAddress());

				if(currentPlace.getLocation().getLatitude() != null && currentPlace.getLocation().getLongitude() != null)
				{
					btnGoTo.setClickable(true);
				}
				else
				{
					btnGoTo.setClickable(false);
				}
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
				txtStatus.setText(currentPlace.getStatus());
			}

			if (currentPlace.getPrice() != null)
			{
				txtPrice.setText(currentPlace.getPrice());
			}

			if (currentPlace.getRating() != null)
			{
				txtRating.setText(String.format("%.1f", currentPlace.getRating()));
			}

			if(currentPlace.getPictureUrl() != null)
			{
				Picasso.with(this)
						.load(currentPlace.getPictureUrl())
						.into(imgPhoto);
			}

			showContent();
		}
	}

	private void hideContent()
	{
		progressBar.setVisibility(View.VISIBLE);
		contentLayout.setVisibility(View.GONE);
		btnGoTo.setVisibility(View.GONE);
	}

	private void showContent()
	{
		progressBar.setVisibility(View.GONE);
		contentLayout.setVisibility(View.VISIBLE);
		btnGoTo.setVisibility(View.VISIBLE);
	}
}
