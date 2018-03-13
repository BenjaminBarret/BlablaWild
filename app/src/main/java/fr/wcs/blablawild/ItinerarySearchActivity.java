package fr.wcs.blablawild;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class ItinerarySearchActivity extends AppCompatActivity {

    public static String EXTRA_DESTINATION = "EXTRA_DESTINATION";
    public static String EXTRA_DEPARTURE = "EXTRA_DEPARTURE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_search);

        Button buttonSearch = findViewById(R.id.button_search);



        final Calendar myCalendar = Calendar.getInstance();

        final EditText editDate= (EditText) findViewById(R.id.editText_date);
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            private void updateLabel() {
                String myFormat = "MM/dd/yy"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.FRANCE);

                editDate.setText(sdf.format(myCalendar.getTime()));
            }

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

        editDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(ItinerarySearchActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

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
