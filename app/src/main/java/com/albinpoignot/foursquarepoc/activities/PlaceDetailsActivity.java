package com.albinpoignot.foursquarepoc.activities;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.albinpoignot.foursquarepoc.R;
import com.albinpoignot.foursquarepoc.models.Place;
import com.albinpoignot.foursquarepoc.network.listeners.GetPlaceListener;
import com.albinpoignot.foursquarepoc.services.GetPlaceService;

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

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_venue_details);

		txtName = (TextView) findViewById(R.id.venue_details_name);
		txtCategory = (TextView) findViewById(R.id.venue_details_type);
		txtLocation = (TextView) findViewById(R.id.venue_details_location);
		txtDescription = (TextView) findViewById(R.id.venue_details_description);
		txtUrl = (TextView) findViewById(R.id.venue_details_url);
		txtStatus = (TextView) findViewById(R.id.venue_details_hours);
		txtPrice = (TextView) findViewById(R.id.venue_details_price);
		txtRating = (TextView) findViewById(R.id.venue_details_rating);
		btnGoTo = (Button) findViewById(R.id.venue_details_goto);
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

		btnGoTo.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				if(currentPlace != null && currentPlace.getLocation() != null)
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
			String naValue = getResources().getString(R.string.activity_details_na);

			String nameValue = naValue;
			String categoryValue = naValue;
			String locationValue = naValue;
			String descriptionValue = naValue;
			String urlValue = naValue;
			String statusValue = naValue;
			String priceValue = naValue;
			String ratingValue = naValue;

			if (currentPlace.getName() != null && !currentPlace.getName().isEmpty())
			{
				nameValue = currentPlace.getName();
			}

			if(currentPlace.getCategory() != null && !currentPlace.getCategory().isEmpty())
			{
				categoryValue = currentPlace.getCategory();
			}

			if (currentPlace.getLocation() != null && currentPlace.getLocation().getAddress() != null
					&& !currentPlace.getLocation().getAddress().isEmpty())
			{
				locationValue = currentPlace.getLocation().getAddress();

				if(currentPlace.getLocation().getLatitude() != null && currentPlace.getLocation().getLongitude() != null)
				{
					btnGoTo.setClickable(true);
				}
				else
				{
					btnGoTo.setClickable(false);
				}
			}

			if (currentPlace.getDescription() != null && !currentPlace.getDescription().isEmpty())
			{
				descriptionValue = currentPlace.getDescription();
			}

			if (currentPlace.getUrl() != null && !currentPlace.getUrl().isEmpty())
			{
				urlValue = currentPlace.getUrl();
			}

			if (currentPlace.getStatus() != null && !currentPlace.getStatus().isEmpty())
			{
				statusValue = currentPlace.getStatus();
			}

			if (currentPlace.getPrice() != null && !currentPlace.getPrice().isEmpty())
			{
				priceValue = currentPlace.getPrice();
			}

			if (currentPlace.getRating() != null)
			{
				ratingValue = String.format("%.1f", currentPlace.getRating());
			}


			txtName.setText(nameValue);
			txtCategory.setText(categoryValue);
			txtLocation.setText(locationValue);
			txtDescription.setText(descriptionValue);
			txtUrl.setText(urlValue);
			txtStatus.setText(statusValue);
			txtPrice.setText(priceValue);
			txtRating.setText(ratingValue);

		}
	}
}
