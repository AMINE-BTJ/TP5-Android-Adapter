package com.example.myapplication;


import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView flagIV = findViewById(R.id.detailFlagIV);
        TextView nameTV = findViewById(R.id.detailNameTV);

        String countryName = getIntent().getStringExtra("countryName");
        int flagId = getIntent().getIntExtra("flagId", 0);

        if (flagId != 0) {
            flagIV.setImageResource(flagId);
        }
        nameTV.setText(countryName);
    }
}