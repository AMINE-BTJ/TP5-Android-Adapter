package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class spinnerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_spinner);
        Button btnShow = findViewById(R.id.btnShow);
        Spinner spinner = findViewById(R.id.spinner);
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
        spinnerAdapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);

        btnShow.setOnClickListener(v -> {
            Intent intent = new Intent(spinnerActivity.this, ListActivity2.class);
            startActivity(intent);
        });
    }
}