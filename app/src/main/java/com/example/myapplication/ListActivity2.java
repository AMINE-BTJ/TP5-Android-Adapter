package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list2);
        Button btnShow = findViewById(R.id.btnShow);
        ListView listView = findViewById(R.id.listView);
        ArrayList<Country> countries = new ArrayList<>();
        countries.add(new Country(R.drawable.flag_morocco, "Morocco"));
        countries.add(new Country(R.drawable.flag_mali, "Mali"));
        countries.add(new Country(R.drawable.flag_zimbabwe, "Zimbabwe"));
        countries.add(new Country(R.drawable.flag_comores, "Comores"));

        ArrayList<String> countryNames = new ArrayList<>();
        for (Country c : countries) {
            countryNames.add(c.name);
        }

        ArrayAdapter<String> spinnerAdapter =
                new ArrayAdapter<>(this,
                        android.R.layout.simple_spinner_item,
                        countryNames);
        ArrayAdapter<String> listAdapter =
                new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1,
                        countryNames);
        listView.setAdapter(listAdapter);

        btnShow.setOnClickListener(v -> {
            Intent intent = new Intent(ListActivity2.this, com.example.myapplication.GridActivity.class);
            startActivity(intent);
        });
    }
}