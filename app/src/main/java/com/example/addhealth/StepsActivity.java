package com.example.addhealth;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class StepsActivity extends AppCompatActivity {

    /**
     * Yksinkertainen listview jossa kerrotaan askelten suositusmäärät.
     * @author Viljami Kutvonen
     *
     * version 1.0.2020
     */

    ListView stepsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_steps);

        //hyvin simppeli ListView arraylistin kanssa

        stepsList = (ListView)findViewById(R.id.listSteps);

        ArrayList<String> arrayList = new ArrayList<>();

        //kuten näkyy, myös täällä totetus on karu BMI-infon acitivityn lisäksi.
        //tarkoitus oli tosiaan tuoda luokka ListViewiin joka on jaoteltu kolmeen sarakkeeseen
        //mutta appin kaaduttua jouduin tekemään hyvin karun toteutuksen.
        arrayList.add("alle 4999\t\t\t\t\t\t\t\t\t\tEi tarpeeksi liikkumista");
        arrayList.add("5000 - 7499\t\t\t\t\t\t\t\tVähäinen liikkuvuus");
        arrayList.add("7500 - 9999\t\t\t\t\t\t\t\tJonkinlainen liikkuvuus");
        arrayList.add("10 000 - 12 000\t\t\t\t\tSuositeltu liikkuvuus");
        arrayList.add("yli 12 500\t\t\t\t\t\t\t\t\t\tAktiivista liikkumista");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);

        stepsList.setAdapter(arrayAdapter);
    }
}
