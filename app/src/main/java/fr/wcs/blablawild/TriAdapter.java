package fr.wcs.blablawild;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


/**
 * Created by wilder on 09/03/18.
 */

public class TriAdapter extends ArrayAdapter<TripModel> {

    public TriAdapter(Context context, ArrayList<TripModel> trips) {
        super(context, 0, trips);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        TripModel trip = getItem(position);


        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_trip, parent, false);
        }
        // Lookup view for data population
        TextView firstname = (TextView) convertView.findViewById(R.id.textView_firstname);
        TextView lastname = (TextView) convertView.findViewById(R.id.textView_lastname);
        TextView date = (TextView) convertView.findViewById(R.id.textView_dateHeure);
        TextView price = (TextView) convertView.findViewById(R.id.textView_price);
        // Populate the data into the template view using the data object
        firstname.setText(trip.getFirstname());
        lastname.setText(trip.getLastname());
        SimpleDateFormat dateHeure = new SimpleDateFormat("dd-MM-yyyy-hh:mm");
        String dateString = dateHeure.format(trip.getDate());
        date.setText(dateString);
        String priceString = String.valueOf(trip.getPrice());
        price.setText(priceString);
        // Return the completed view to render on screen
        return convertView;
    }

}
