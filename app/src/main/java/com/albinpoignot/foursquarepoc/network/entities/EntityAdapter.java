package com.albinpoignot.foursquarepoc.network.entities;

import com.albinpoignot.foursquarepoc.models.LightPlace;
import com.albinpoignot.foursquarepoc.models.Location;
import com.albinpoignot.foursquarepoc.models.Place;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Albin POIGNOT on 15/10/15.
 */
public class EntityAdapter
{
	private EntityAdapter() { }

	public static List<LightPlace> adapt(List<FoursquareCompactVenue> foursquareCompactVenues)
	{
		List<LightPlace> lightPlaces = new ArrayList<>();
		for(FoursquareCompactVenue foursquareCompactVenue : foursquareCompactVenues)
		{
			lightPlaces.add(adapt(foursquareCompactVenue));
		}
		return lightPlaces;
	}
	public static LightPlace adapt(FoursquareCompactVenue foursquareCompactVenue)
	{
		LightPlace lightPlace = new LightPlace();

		List<FoursquareCategory> categoryList = foursquareCompactVenue.getCategories();
		String categoryToUse = "";
		if(categoryList != null && categoryList.size() > 0)
		{
			categoryToUse = categoryList.get(0).getName();
		}

		lightPlace.setCategory(categoryToUse);
		lightPlace.setId(foursquareCompactVenue.getId());
		lightPlace.setLocation(adapt(foursquareCompactVenue.getLocation()));
		lightPlace.setName(foursquareCompactVenue.getName());

		return lightPlace;
	}

	public static Place adapt(FoursquareVenue foursquareVenue)
	{
		Place place = new Place();

		List<FoursquareCategory> categoryList = foursquareVenue.getCategories();
		String categoryToUse;
		if(categoryList != null && categoryList.size() > 0)
		{
			categoryToUse = categoryList.get(0).getName();
		}
		else
		{
			categoryToUse = "";
		}
		place.setCategory(categoryToUse);

		place.setId(foursquareVenue.getId());
		place.setLocation(adapt(foursquareVenue.getLocation()));
		place.setName(foursquareVenue.getName());

		place.setDescription(foursquareVenue.getDescription());

		String priceToUse;
		if(foursquareVenue.getPrice() != null)
		{
			priceToUse = foursquareVenue.getPrice().getMessage();
		}
		else
		{
			priceToUse = "";
		}
		place.setPrice(priceToUse);


		place.setRating(foursquareVenue.getRating());

		String statusToUse;
		if(foursquareVenue.getHours() != null)
		{
			statusToUse = foursquareVenue.getHours().getStatus();
		}
		else
		{
			statusToUse = "";
		}
		place.setStatus(statusToUse);

		place.setUrl(foursquareVenue.getUrl());

		return place;
	}

	public static Location adapt(FoursquareLocation foursquareLocation)
	{
		Location location = new Location();
		location.setAddress(foursquareLocation.getAddress());
		location.setCity(foursquareLocation.getCity());
		location.setCountry(foursquareLocation.getCountry());
		location.setDistance(foursquareLocation.getDistance());
		location.setPostalCode(foursquareLocation.getPostalCode());
		location.setState(foursquareLocation.getState());

		return location;
	}
}
