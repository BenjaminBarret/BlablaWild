package fr.wcs.blablawild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ItinerarySearchActivity extends AppCompatActivity {

    public static String EXTRA_DESTINATION = "EXTRA_DESTINATION";
    public static String EXTRA_DEPARTURE = "EXTRA_DEPARTURE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_search);

        Button buttonSearch = findViewById(R.id.button_search);

        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText editDeparture = findViewById(R.id.editText_departure);
                EditText editDestination = findViewById(R.id.editText_destination);
                EditText editDate = findViewById(R.id.editText_date);

                String departureValue = editDeparture.getText().toString();
                String destinationValue = editDestination.getText().toString();
                String dateValue = editDate.getText().toString();

                if((editDestination.length() == 0) || (editDeparture.length() == 0)){
                    Toast.makeText(ItinerarySearchActivity.this, "Error - Departure or Destination empty", Toast.LENGTH_SHORT).show();
                }

                else{
                        Intent goToItineraryListActivity = new Intent(ItinerarySearchActivity.this, ItineraryListActivity.class);
                        goToItineraryListActivity.putExtra(EXTRA_DESTINATION, destinationValue);
                        goToItineraryListActivity.putExtra(EXTRA_DEPARTURE, departureValue);
                        ItinerarySearchActivity.this.startActivity(goToItineraryListActivity);
                }

            }
        });

    }


}
