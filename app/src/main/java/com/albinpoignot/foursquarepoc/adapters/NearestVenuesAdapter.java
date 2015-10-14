package com.albinpoignot.foursquarepoc.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.albinpoignot.foursquarepoc.R;
import com.albinpoignot.foursquarepoc.models.CompactVenue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Albin on 14/10/2015.
 */
public class NearestVenuesAdapter extends BaseAdapter
{
    private Context context;
    private List<CompactVenue> compactVenues;

    public NearestVenuesAdapter(Context context)
    {
        this.context = context;
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
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        convertView= inflater.inflate(R.layout.list_item_compact_venue, null);

        TextView txtName=(TextView)convertView.findViewById(R.id.venue_name);
        TextView txtLocation=(TextView)convertView.findViewById(R.id.venue_location);

        txtName.setText(compactVenues.get(position).getName());
        txtLocation.setText(compactVenues.get(position).getLocation().getAddress());

        return convertView;
    }
}
