package com.example.addhealth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Yksinkertainen listview jossa kerrotaan painoindeksien arvot.
 * @author Viljami Kutvonen
 *
 * version 1.0 6.5.2020
 */
public class Activity3 extends AppCompatActivity {


    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        //simppeli ListView arrayList kanssa

        listView = (ListView)findViewById(R.id.listbmi);

        ArrayList<String> arrayList = new ArrayList<>();

        //kuten näkyy totetus on todella karu \t kanssa. Tarkoitus oli tehdä erilliset sarakkeet, mutta en saanut toimimaan
        arrayList.add("Vaikea alipaino\t\t\t\t\t\t\t\t\t\t\t\t\t< 16");
        arrayList.add("Merkittävä alipaino\t\t\t\t\t\t\t\t\t\t16 - 17");
        arrayList.add("Lievä alipaino\t\t\t\t\t\t\t\t\t\t\t\t\t\t17 - 18.5");
        arrayList.add("Normaali paino\t\t\t\t\t\t\t\t\t\t\t\t\t18.5 - 25");
        arrayList.add("Lievä ylipaino\t\t\t\t\t\t\t\t\t\t\t\t\t\t25 - 30");
        arrayList.add("Merkittävä ylipaino\t\t\t\t\t\t\t\t\t\t30 - 35");
        arrayList.add("Vaikea ylipaino\t\t\t\t\t\t\t\t\t\t\t\t\t35 - 40");
        arrayList.add("Vaarallinen ylipaino\t\t\t\t\t\t\t\t\t\t> 40");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);

        listView.setAdapter(arrayAdapter);
    }
}
