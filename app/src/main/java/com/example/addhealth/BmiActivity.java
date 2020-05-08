package com.example.addhealth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * BMI-laskuri luokka jossa kaavat ja nappulat painoindeksiä varten.
 * @author Viljami Kutvonen
 *
 * version 1.0 6.5.2020
 *
 * Tällä sivulla yksinkertainen BMI-laskuri
 */
public class BmiActivity extends AppCompatActivity {
    /**
     * Alhaalla määritetty EditText kentät
     * BMI tulos
     * Nappulat
     */

    private EditText editWeight, editHeight;
    private TextView tv_result;
    private Button button, button2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        /**
         * //alla haetaan info -nappula ja avataan info activity
         */
        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openInfoActivity();
            }
        });

        /**
         * määritellään painon EditText -kenttä
         * määritellään pituuden EditText -kenttä
         * määritellään tulosnäkymä -kenttä
         */
        editWeight = (EditText)findViewById(R.id.et_weight);
        editHeight = (EditText)findViewById(R.id.et_height);
        tv_result = (TextView)findViewById(R.id.tv_result);
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                bmi();
            }
        });

    }

    /**
     * avataan Info activity
     */
    public void openInfoActivity() {
        Intent intent = new Intent(this, Activity3.class);
        startActivity(intent);
    }

    /**
     *  alla määritellään painoindeksin muuttujat sekä lasketaan painoindeksi
     */

    private void bmi() {
        float a,b,c;
        a = Float.parseFloat(editHeight.getText().toString()) / 100;
        b = Float.parseFloat(editWeight.getText().toString());
        c = b / (a * a);
        tv_result.setText("" + c);



        /**
        * alla hyvin yksinkertainen määrittely painoindeksin arvoista ja tämän lisäksi tulostetaan tulos TOAST:illa
        */
        if (c < 16) {
            Toast.makeText(getApplicationContext(), "Vaikea alipaino", Toast.LENGTH_SHORT).show();
        }
        if ((c >= 16.0) && (c < 17)) {
            Toast.makeText(getApplicationContext(), "Merkittävä alipaino", Toast.LENGTH_SHORT).show();
        }
        if ((c >= 17) && (c < 18.5)) {
            Toast.makeText(getApplicationContext(), "Lievä alipaino", Toast.LENGTH_SHORT).show();
        }
        if ((c >= 18.5) && (c < 25)) {
            Toast.makeText(getApplicationContext(), "Normaali paino", Toast.LENGTH_SHORT).show();
        }
        if ((c >= 25) && (c < 30)) {
            Toast.makeText(getApplicationContext(), "Lievä ylipaino", Toast.LENGTH_SHORT).show();
        }
        if ((c >= 30) && (c < 35)) {
            Toast.makeText(getApplicationContext(), "Merkittävä ylipaino", Toast.LENGTH_SHORT).show();
        }
        if ((c >= 35) && (c < 40)) {
            Toast.makeText(getApplicationContext(), "Vaikea ylipaino", Toast.LENGTH_SHORT).show();
        }
        if (c >= 40) {
            Toast.makeText(getApplicationContext(), "Vaarallinen ylipaino", Toast.LENGTH_SHORT).show();
        }
    }

}
