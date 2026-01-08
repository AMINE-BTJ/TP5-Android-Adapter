package com.example.myapplication;// Fichier: CountryAdapter.java

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CountryAdapter extends ArrayAdapter<Country> {
    Activity activity;
    int resourceId;
    ArrayList<Country> items;

    public CountryAdapter(Activity activity, int resourceId, ArrayList<Country> items) {
        super(activity, resourceId, items);
        this.activity = activity;
        this.resourceId = resourceId;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        // 1. Création de la vue si elle n'existe pas encore (Recyclage)
        if (view == null) {
            LayoutInflater inflater = activity.getLayoutInflater();
            view = inflater.inflate(resourceId, parent, false);
        }

        // 2. Récupération des composants graphiques
        ImageView flagIV = view.findViewById(R.id.flagIV);
        TextView nameTV = view.findViewById(R.id.nameTV);

        // 3. Récupération de la donnée courante grâce à la position
        Country country = items.get(position);

        // 4. Affectation des données
        flagIV.setImageResource(country.flagResId);
        nameTV.setText(country.name);

        return view;
    }
}