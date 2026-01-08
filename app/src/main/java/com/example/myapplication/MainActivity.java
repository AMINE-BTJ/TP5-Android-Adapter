package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.spinner);
        ListView listView = findViewById(R.id.listView);
        GridView gridView = findViewById(R.id.gridView);
        Button btnShow = findViewById(R.id.btnShow);

        ArrayList<Country> countries = new ArrayList<>();
        countries.add(new Country(R.drawable.flag_morocco, "MOROCCO"));
        countries.add(new Country(R.drawable.flag_mali, "MALI"));
        countries.add(new Country(R.drawable.flag_zimbabwe, "ZIMBABWE"));
        countries.add(new Country(R.drawable.flag_comores, "COMORES"));

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

        ArrayAdapter<String> listAdapter =
                new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1,
                        countryNames);
        listView.setAdapter(listAdapter);

        CountryAdapter countryAdapter =
                new CountryAdapter(this,
                        R.layout.item_country,
                        countries);
        gridView.setAdapter(countryAdapter);

        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        btnShow.setOnClickListener(v -> {
            int position = listView.getCheckedItemPosition();
            if (position != ListView.INVALID_POSITION) {
                String selectedItem = listAdapter.getItem(position);
                Toast.makeText(this,
                        "Sélection : " + selectedItem,
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this,
                        "Aucun élément sélectionné",
                        Toast.LENGTH_SHORT).show();
            }
        });

        spinner.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent,
                                               View view,
                                               int position,
                                               long id) {
                        String selectedItem =
                                spinnerAdapter.getItem(position);
                        Toast.makeText(MainActivity.this,
                                "Sélection : " + selectedItem,
                                Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) { }
                });

        gridView.setOnItemClickListener(
                (parent, view, position, id) -> {
                    Country country = countryAdapter.getItem(position);
                    Intent intent = new Intent(MainActivity.this, com.example.myapplication.DetailActivity.class);
                    intent.putExtra("countryName", country.name);
                    intent.putExtra("flagId", country.flagResId);
                    startActivity(intent);
                });
    }
}
