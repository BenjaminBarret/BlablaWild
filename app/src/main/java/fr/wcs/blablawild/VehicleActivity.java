package fr.wcs.blablawild;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class VehicleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle);

        //Récupération du Spinner déclaré dans le fichier main.xml de res/layout
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.vehicles_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
                spinner.setAdapter(adapter);

        final Button buttonSendVehicle = findViewById(R.id.button_acceptVehicle);
        final EditText model = findViewById(R.id.editText_Model);
        final EditText brand = findViewById(R.id.editText_Brand);
        final EditText hours = findViewById(R.id.editText_Hours);
        final EditText km = findViewById(R.id.editText_Km);
        final EditText speed = findViewById(R.id.editText_Speed);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {


                switch (pos) {

                    case 0:
                        buttonSendVehicle.setEnabled(false);
                        hours.setVisibility(view.GONE);
                        km.setVisibility(view.GONE);
                        speed.setVisibility(view.GONE);
                        break;

                    case 1:
                        buttonSendVehicle.setEnabled(true);
                        km.setVisibility(view.VISIBLE);
                        hours.setVisibility(view.GONE);

                        buttonSendVehicle.setOnClickListener(new View.OnClickListener() {


                            @Override
                            public void onClick(View view) {


                                String modelString = model.getText().toString();
                                String brandString = brand.getText().toString();
                                String kmString = km.getText().toString();
                                int kmValue = Integer.valueOf(kmString);

                                VehicleCar car = new VehicleCar(modelString, brandString, kmValue);

                                Toast.makeText(VehicleActivity.this, car.getDescription(), Toast.LENGTH_SHORT).show();
                            }
                        });

                        break;

                    case 2:
                        buttonSendVehicle.setEnabled(true);
                        km.setVisibility(view.GONE);
                        hours.setVisibility(view.VISIBLE);

                        buttonSendVehicle.setOnClickListener(new View.OnClickListener() {


                            @Override
                            public void onClick(View view) {


                                String modelString = model.getText().toString();
                                String brandString = brand.getText().toString();
                                String hoursString = hours.getText().toString();
                                int hoursValue = Integer.valueOf(hoursString);

                                VehicleBoat boat = new VehicleBoat(modelString, brandString, hoursValue);

                                Toast.makeText(VehicleActivity.this, boat.getDescription(), Toast.LENGTH_SHORT).show();
                            }
                        });

                        break;

                    case 3:
                        buttonSendVehicle.setEnabled(true);
                        km.setVisibility(view.GONE);
                        hours.setVisibility(view.GONE);
                        speed.setVisibility(view.VISIBLE);

                        buttonSendVehicle.setOnClickListener(new View.OnClickListener() {


                            @Override
                            public void onClick(View view) {


                                String modelString = model.getText().toString();
                                String brandString = brand.getText().toString();
                                String speedString = speed.getText().toString();
                                int speedValue = Integer.valueOf(speedString);

                                VehiclePlane plane = new VehiclePlane(modelString, brandString, speedValue);

                                Toast.makeText(VehicleActivity.this, plane.getDescription(), Toast.LENGTH_SHORT).show();
                            }
                        });

                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }


}
