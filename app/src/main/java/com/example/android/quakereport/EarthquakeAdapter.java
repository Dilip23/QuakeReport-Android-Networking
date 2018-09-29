package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by LENOVO on 10-03-2018.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    private static final String LOCATION_SEPERATOR = "of";

    public EarthquakeAdapter(@NonNull Context context, List<Earthquake> earthquakes) {
        super(context,0,earthquakes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listView = convertView;
        if (listView == null){
            listView = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_list_item,parent,false);
        }
//Find earthquake at the position
        Earthquake currentEarthquake = getItem(position);
//Display magnitude and set color
        TextView magnitudeView = (TextView)listView.findViewById(R.id.magnitude);

        String formattedMagnitude = formatMagnitude(currentEarthquake.getmMagnitude());

        magnitudeView.setText(formattedMagnitude);

        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeView.getBackground();

        int magnitudeColor = getMagnitudeColor(currentEarthquake.getmMagnitude());

        magnitudeCircle.setColor(magnitudeColor);
//Get the location from earthquake object
        String earthquakeLocation = currentEarthquake.getmLocation();
        String primaryLocation,locationOffset;

        if(earthquakeLocation.contains(LOCATION_SEPERATOR)){
            String[] parts = earthquakeLocation.split(LOCATION_SEPERATOR);
            locationOffset = parts[0]+LOCATION_SEPERATOR;
            primaryLocation = parts[1];
        }else {
            locationOffset = getContext().getString(R.string.near_the);
            primaryLocation =earthquakeLocation;
        }
//Find location offset view ID and set
        TextView locationOffsetView = (TextView)listView.findViewById(R.id.location_offset);
        locationOffsetView.setText(locationOffset);
        TextView primaryLocationView = (TextView)listView.findViewById(R.id.primary_location);
        primaryLocationView.setText(primaryLocation);
//Set the date in date view
        Date dateObject = new Date(currentEarthquake.getmTimeInMillisecs());
        TextView dateView = (TextView)listView.findViewById(R.id.date);
        String formattedDate = formatDate(dateObject);
        dateView.setText(formattedDate);
//Set time for time view
        TextView timeView = (TextView)listView.findViewById(R.id.time);
        String formattedTime = formatTime(dateObject);
        timeView.setText(formattedTime);
//Return the listView that is now showing all data
        return listView;
    }


    private String formatTime(Date timeView) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(timeView);

    }

    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);

    }

    private int getMagnitudeColor(double v) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(v);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(),magnitudeColorResourceId);
    }

    private String formatMagnitude(double v) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(v);

    }
}
