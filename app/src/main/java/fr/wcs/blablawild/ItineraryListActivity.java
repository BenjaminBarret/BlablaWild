package fr.wcs.blablawild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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

        setTitle(departure + " >> " + destination);
    }
}
