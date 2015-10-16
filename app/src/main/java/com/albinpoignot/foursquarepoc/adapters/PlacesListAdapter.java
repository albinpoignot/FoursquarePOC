package com.albinpoignot.foursquarepoc.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.albinpoignot.foursquarepoc.R;
import com.albinpoignot.foursquarepoc.models.LightPlace;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Albin on 14/10/2015.
 */
public class PlacesListAdapter extends BaseAdapter
{
    private LayoutInflater inflater;
    private List<LightPlace> lightPlaces;

    public PlacesListAdapter(Context context)
    {
        this.inflater = LayoutInflater.from(context);
        this.lightPlaces = new ArrayList<>();
    }

    public void setLightPlaces(List<LightPlace> lightPlaces)
    {
        this.lightPlaces.clear();
        this.lightPlaces.addAll(lightPlaces);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return lightPlaces.size();
    }

    @Override
    public Object getItem(int position) {
        return lightPlaces.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ViewHolder holder;

        if (convertView == null)
        {
            convertView = inflater.inflate(R.layout.list_item_light_place, null);

            holder = new ViewHolder();
            holder.txtName = (TextView) convertView.findViewById(R.id.venue_name);
            holder.txtDistance = (TextView) convertView.findViewById(R.id.venue_distance);
            holder.txtCategories = (TextView) convertView.findViewById(R.id.venue_categories);

            convertView.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) convertView.getTag();
        }

        LightPlace place = lightPlaces.get(position);

        holder.txtName.setText(place.getName());

        if(place.getLocation() != null && place.getLocation().getDistance() != null)
        {
            holder.txtDistance.setText(place.getLocation().getDistance());
            holder.txtDistance.setVisibility(View.VISIBLE);
        }
        else
        {
            holder.txtDistance.setVisibility(View.GONE);
        }

		String placeCategory = place.getCategory();
        if(placeCategory != null && !placeCategory.isEmpty())
        {
            holder.txtCategories.setText(placeCategory);
            holder.txtDistance.setVisibility(View.VISIBLE);
        }
        else
        {
            holder.txtDistance.setVisibility(View.GONE);
        }

        return convertView;
    }

    private static class ViewHolder
    {
        public TextView txtName;
        public TextView txtDistance;
        public TextView txtCategories;
    }
}
