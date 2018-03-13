package fr.wcs.blablawild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import static fr.wcs.blablawild.ItinerarySearchActivity.RESULTSEARCH;

public class ItineraryListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_list);

        SearchModel searchModelList = getIntent().getExtras().getParcelable(RESULTSEARCH);


        ListView listTrip = findViewById(R.id.list_trip);
        ArrayList<TripModel> results = new ArrayList<>();

        setTitle(searchModelList.getDeparture() + " >> " + searchModelList.getDestination());
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy-hh:mm");
        Toast.makeText(this, searchModelList.getDate(), Toast.LENGTH_SHORT).show();

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

