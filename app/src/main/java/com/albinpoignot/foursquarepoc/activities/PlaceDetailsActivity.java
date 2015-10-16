package com.albinpoignot.foursquarepoc.activities;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
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
import com.albinpoignot.foursquarepoc.network.services.ServiceError;
import com.squareup.picasso.Picasso;

import java.util.Locale;

/**
 * Activity showing the details of a place
 * Created by Albin POIGNOT on 15/10/15.
 */
public class PlaceDetailsActivity extends Activity implements GetPlaceListener
{
    /**
     * Tag used to pass place's id via Intent
     */
    public static final String VENUE_ID_TAG = "PlaceDetailsActivity.venueId";

    /**
     * The place to display
     */
    private Place currentPlace;

    /**
     * UI Component holding the name of the place
     */
    private TextView txtName;

    /**
     * UI Component holding the category of the place
     */
    private TextView txtCategory;

    /**
     * UI Component holding the location of the place
     */
    private TextView txtLocation;

    /**
     * UI Component holding the description of the place
     */
    private TextView txtDescription;

    /**
     * UI Component holding the URL of the place
     */
    private TextView txtUrl;

    /**
     * UI Component holding the open status of the place
     */
    private TextView txtStatus;

    /**
     * UI Component holding the price range of the place
     */
    private TextView txtPrice;

    /**
     * UI Component holding the rating of the place
     */
    private TextView txtRating;

    /**
     * Button to see the place on an external map
     */
    private Button btnGoTo;

    /**
     * UI Component holding the photo of the place
     */
    private ImageView imgPhoto;

    /**
     * Loading progress indicator
     */
    private ProgressBar progressBar;

    /**
     * UI Component holding all the views that holds the place details
     */
    private ViewGroup contentLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_details);

        // Bind the views
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

        // Enable the "up" button to go back
        ActionBar actionBar = getActionBar();
        if (actionBar != null)
        {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // Defines the action for the button to show a map
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
            case NOT_FOUND:
                resId = R.string.service_error_not_found;
                break;
            default:
                resId = R.string.service_error_unknown_error;
                break;
        }
        Toast.makeText(this, resId, Toast.LENGTH_LONG).show();
        finish();
    }

    @Override
    public void onPlaceReceived(Place place)
    {
        currentPlace = place;
        setViewsContent();
        showContent();
    }

    @Override
    protected void onResume()
    {
        super.onResume();

        // Get the place to display from network or display the one we already got
        if (currentPlace == null)
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
        else
        {
            setViewsContent();
            showContent();
        }
    }

    /**
     * Set the details of the place in the Views.
     */
    private void setViewsContent()
    {
        if (currentPlace != null)
        {
            txtName.setText(currentPlace.getName());
            txtCategory.setText(currentPlace.getCategory());
            txtDescription.setText(currentPlace.getDescription());
            txtUrl.setText(currentPlace.getUrl());
            txtStatus.setText(currentPlace.getStatus());
            txtPrice.setText(currentPlace.getPrice());

            if (currentPlace.getRating() != null)
            {
                txtRating.setText(String.format("%.1f", currentPlace.getRating()));
            }

            if (currentPlace.getLocation() != null)
            {
                txtLocation.setText(currentPlace.getLocation().getAddress());

                if (currentPlace.getLocation().getLatitude() != null && currentPlace.getLocation().getLongitude() != null)
                {
                    btnGoTo.setClickable(true);
                }
                else
                {
                    btnGoTo.setClickable(false);
                }
            }

            if (currentPlace.getPictureUrl() != null)
            {
                Picasso.with(this)
                        .load(currentPlace.getPictureUrl())
                        .into(imgPhoto);
            }
        }
    }

    /**
     * Hides the content Views and shows the progress bar
     */
    private void hideContent()
    {
        progressBar.setVisibility(View.VISIBLE);
        contentLayout.setVisibility(View.GONE);
        btnGoTo.setVisibility(View.GONE);
    }

    /**
     * Shows the content Views and hides the progress bar
     */
    private void showContent()
    {
        progressBar.setVisibility(View.GONE);
        contentLayout.setVisibility(View.VISIBLE);
        btnGoTo.setVisibility(View.VISIBLE);
    }
}
