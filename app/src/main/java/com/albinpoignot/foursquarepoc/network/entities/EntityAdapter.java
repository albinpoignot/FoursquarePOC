package com.albinpoignot.foursquarepoc.network.entities;

import com.albinpoignot.foursquarepoc.models.LightPlace;
import com.albinpoignot.foursquarepoc.models.Location;
import com.albinpoignot.foursquarepoc.models.Place;

import java.util.ArrayList;
import java.util.List;

/**
 * Utils class handling conversion from Foursquare entities to models
 * Created by Albin POIGNOT on 15/10/15.
 */
public class EntityAdapter
{
    /**
     * Venue's picture wanted size. This value will be used to generate picture URL
     */
    public static final String VENUE_PICTURE_SIZE = "300x300";

    private EntityAdapter()
    {
    }

    /**
     * Convert a list of FoursquareCompactVenue to a list of LightPlace entities
     *
     * @param foursquareCompactVenues the list of FoursquareCompactVenue to convert
     * @return a list of LightPlace entities. The list is empty if the FoursquareCompactVenue was empty
     */
    public static List<LightPlace> adapt(List<FoursquareCompactVenue> foursquareCompactVenues)
    {
        List<LightPlace> lightPlaces = new ArrayList<>();
        for (FoursquareCompactVenue foursquareCompactVenue : foursquareCompactVenues)
        {
            lightPlaces.add(adapt(foursquareCompactVenue));
        }
        return lightPlaces;
    }

    /**
     * Convert a FoursquareCompactVenue to a LightPlace entity
     *
     * @param foursquareCompactVenue the FoursquareCompactVenue to convert
     * @return a LightPlace entity
     */
    public static LightPlace adapt(FoursquareCompactVenue foursquareCompactVenue)
    {
        LightPlace lightPlace = new LightPlace();

        List<FoursquareCategory> categoryList = foursquareCompactVenue.getCategories();
        if (categoryList != null && categoryList.size() > 0)
        {
            lightPlace.setCategory(categoryList.get(0).getName());
        }

        lightPlace.setId(foursquareCompactVenue.getId());
        lightPlace.setName(foursquareCompactVenue.getName());

        return lightPlace;
    }

    /**
     * Convert a FoursquareVenue to a Place entity
     *
     * @param foursquareVenue the FoursquareVenue to convert
     * @return a Place entity
     */
    public static Place adapt(FoursquareVenue foursquareVenue)
    {
        Place place = new Place();

        // We use the first category
        List<FoursquareCategory> categoryList = foursquareVenue.getCategories();
        if (categoryList != null && categoryList.size() > 0)
        {
            place.setCategory(categoryList.get(0).getName());
        }

        place.setId(foursquareVenue.getId());
        place.setLocation(adapt(foursquareVenue.getLocation()));
        place.setName(foursquareVenue.getName());

        place.setDescription(foursquareVenue.getDescription());

        if (foursquareVenue.getPrice() != null)
        {
            place.setPrice(foursquareVenue.getPrice().getMessage());
        }

        place.setRating(foursquareVenue.getRating());

        if (foursquareVenue.getHours() != null)
        {
            place.setStatus(foursquareVenue.getHours().getStatus());
        }

        place.setUrl(foursquareVenue.getUrl());

        if (foursquareVenue.getPhotos() != null)
        {
            FoursquarePhotos photos = foursquareVenue.getPhotos();
            if (photos.getGroups() != null && photos.getGroups().size() > 0)
            {
                FoursquareGroup group = photos.getGroups().get(0);

                if (group.getItems() != null && group.getItems().size() > 0)
                {
                    FoursquarePhotoItem photoItem = group.getItems().get(0);
                    photoItem.getPrefix();

                    // According to Foursquare API documentation, the picture URL is a concatenation
                    // of prefix + wanted size + suffix
                    String url = photoItem.getPrefix() + VENUE_PICTURE_SIZE + photoItem.getSuffix();
                    place.setPictureUrl(url);

                }
            }
        }

        return place;
    }

    /**
     * Convert a FoursquareLocation to a Location entity
     *
     * @param foursquareLocation the FoursquareLocation to convert
     * @return a Location entity
     */
    public static Location adapt(FoursquareLocation foursquareLocation)
    {
        Location location = new Location();
        location.setAddress(foursquareLocation.getAddress());
        location.setCity(foursquareLocation.getCity());
        location.setCountry(foursquareLocation.getCountry());
        location.setDistance(foursquareLocation.getDistance());
        location.setLatitude(foursquareLocation.getLat());
        location.setLongitude(foursquareLocation.getLng());

        return location;
    }
}
