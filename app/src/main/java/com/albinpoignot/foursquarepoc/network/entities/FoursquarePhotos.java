package com.albinpoignot.foursquarepoc.network.entities;

import java.util.List;

/**
 * Created by Albin POIGNOT on 16/10/15.
 */
public class FoursquarePhotos
{
	private List<FoursquareGroup> groups;

	public List<FoursquareGroup> getGroups()
	{
		return groups;
	}

	public void setGroups(List<FoursquareGroup> groups)
	{
		this.groups = groups;
	}
}
