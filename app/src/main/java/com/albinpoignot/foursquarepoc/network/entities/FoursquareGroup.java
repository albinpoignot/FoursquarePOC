package com.albinpoignot.foursquarepoc.network.entities;

import java.util.List;

/**
 * Created by Albin POIGNOT on 16/10/15.
 */
public class FoursquareGroup
{
	private List<FoursquarePhotoItem> items;

	public List<FoursquarePhotoItem> getItems()
	{
		return items;
	}

	public void setItems(List<FoursquarePhotoItem> items)
	{
		this.items = items;
	}
}
