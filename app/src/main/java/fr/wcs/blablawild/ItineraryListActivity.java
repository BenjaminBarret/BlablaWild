package fr.wcs.blablawild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import static fr.wcs.blablawild.ItinerarySearchActivity.EXTRA_DEPARTURE;
import static fr.wcs.blablawild.ItinerarySearchActivity.EXTRA_DESTINATION;

public class ItineraryListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_list);

        Intent intItineraryListActivity = getIntent();
        String departure = intItineraryListActivity.getStringExtra(EXTRA_DEPARTURE);
        String destination = intItineraryListActivity.getStringExtra(EXTRA_DESTINATION);

        ListView listTrip = findViewById(R.id.list_trip);
        ArrayList<TripModel> results = new ArrayList<>();

        setTitle(departure + " >> " + destination);

        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy-hh:mm");

        try {
            results.add(new TripModel("Eric", "Cartman", date.parse("21/02/2017-15:30"), 15));
            results.add(new TripModel("Stan", "Marsh", date.parse("21/02/2017-16:00"), 20));
            results.add(new TripModel("Kenny", "Broflovski", date.parse("21/02/2017-16:30"), 16));
            results.add(new TripModel("Kyle", "McCormick", date.parse("21/02/2017-17:00"), 40));
            results.add(new TripModel("Wendy", "Testaburger", date.parse("21/02/2017-17:30"), 20));
        } catch (ParseException e) {
        }
        TriAdapter adapter = new TriAdapter(this, results);
        listTrip.setAdapter(adapter);

    }
}

