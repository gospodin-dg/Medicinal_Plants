package com.example.medicinal_plants.db;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.medicinal_plants.R;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends ArrayAdapter<MedPlant> {

    private LayoutInflater inflater;
    private int list_item;
    private List<MedPlant> medPlants;

    public MyAdapter(@NonNull Context context, int resource, @NonNull List<MedPlant> objects) {

        super(context, resource, objects);
        this.inflater = LayoutInflater.from(context);
        this.list_item = resource;
        this.medPlants = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        View view = inflater.inflate(list_item, parent, false);
        TextView tv = view.findViewById(R.id.tvMedPlant);
        MedPlant medPlant = medPlants.get(position);
        tv.setText(medPlant.getName());

        return view;
    }
}
