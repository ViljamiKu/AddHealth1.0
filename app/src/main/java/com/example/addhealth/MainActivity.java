package com.example.addhealth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Askelmittari, jossa käytetty valmista pohjaa sekä muokattu omaan käyttätarkoitukseen.
 * @author Viljami Kutvonen
 * @author Tihomir RAdeff https://www.youtube.com/watch?v=CNGMWnmldaU (askelmittarin sensorit)
 *
 *  version 1.0 6.5.2020
 */
public class MainActivity extends AppCompatActivity implements SensorEventListener { // impelements & sensorEventListener ottaa käyttöön puhelimen sensorin
    private Button button;  //nappulan alustus BMI-activityyn
    private Button button2; //nappulan alustus Steps-activityyn

    TextView tv_steps;      //text view kenttä askelmäärän näyttämistä varten
    SensorManager sensorManager; //hallitsee sensoria

    boolean running = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_steps = (TextView) findViewById(R.id.textView2); //ohjaa askelten tulostamisen textView2:een

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE); //hakee puhelimen sensorin(?)

        button = (Button) findViewById(R.id.button);                //ensimmäisestä nappulasta päästään BMI-activityyn
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBmiActivity();
            }
        });
        button2 = (Button) findViewById(R.id.button2);              //toisesta nappulasta päästään STEPS-listviewiin
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStepsActivity();
            }
        });
    }
    public void openBmiActivity(){                                              //avaa BMI-acitivityn
        Intent intent = new Intent(this, BmiActivity.class);
        startActivity(intent);
    }

    public void openStepsActivity(){                                            //avaa STEPS-listviewin
        Intent intent2 = new Intent(this, StepsActivity.class);
        startActivity(intent2);
    }




    //askelmittarin sensoritoiminta
    @Override
    protected void onResume() {
        super.onResume();
        running = true;
        Sensor countSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);                  //käyttää defaultsensoria
        if(countSensor !=null) {                                                                        //kun sensori lukee askelia niin lisää askelmääriä
            sensorManager.registerListener(this, countSensor, SensorManager.SENSOR_DELAY_UI);
        } else {                                                                                        //jos laite ei havaitse sensoria, tekee toast ilmoituksen "Sensoria ei löydy"
            Toast.makeText(this, "Sensoria ei löydy!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        running = false;
        // sensorManager.unregisterListener(this);
    }
    @Override
    public void onSensorChanged(SensorEvent event) {
        if(running) {                                               //kun askelmäärä muuttuu, tulostaa määrättyyn paikkaan askelten arvon
            tv_steps.setText(String.valueOf(event.values[0]));
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
