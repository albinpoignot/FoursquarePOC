package com.albinpoignot.foursquarepoc.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.albinpoignot.foursquarepoc.R;
import com.albinpoignot.foursquarepoc.models.Category;
import com.albinpoignot.foursquarepoc.models.CompactVenue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Albin on 14/10/2015.
 */
public class NearestVenuesAdapter extends BaseAdapter
{
    private LayoutInflater inflater;
    private List<CompactVenue> compactVenues;

    public NearestVenuesAdapter(Context context)
    {
        this.inflater = LayoutInflater.from(context);
        this.compactVenues = new ArrayList<>();
    }

    public void setCompactVenues(List<CompactVenue> compactVenues)
    {
        this.compactVenues.clear();
        this.compactVenues.addAll(compactVenues);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return compactVenues.size();
    }

    @Override
    public Object getItem(int position) {
        return compactVenues.get(position);
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
            convertView = inflater.inflate(R.layout.list_item_compact_venue, null);

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

        CompactVenue venue = compactVenues.get(position);

        holder.txtName.setText(venue.getName());

        if(venue.getLocation() != null && venue.getLocation().getDistance() != null)
        {
            holder.txtDistance.setText(venue.getLocation().getDistance());
            holder.txtDistance.setVisibility(View.VISIBLE);
        }
        else
        {
            holder.txtDistance.setVisibility(View.GONE);
        }

        if(venue.getCategories() != null && venue.getCategories().size() > 0)
        {
            holder.txtCategories.setText(venue.getCategories().get(0).getName());
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
