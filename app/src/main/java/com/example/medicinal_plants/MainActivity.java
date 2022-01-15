package com.example.medicinal_plants;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
//import android.widget.Toolbar;
import androidx.appcompat.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private String[] plants_array;
    private ListView plants_view;
    private ArrayAdapter<String> plants_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        plants_view = findViewById(R.id.plants_view);
        plants_array = getResources().getStringArray(R.array.medicinal_plants);
        plants_adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new ArrayList<String>(Arrays.asList(plants_array)));
        plants_view.setAdapter(plants_adapter);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if(drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        if(id==R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id==R.id.nav_medicinal_plants)
        {
            plants_array = getResources().getStringArray(R.array.medicinal_plants);
            plants_adapter.clear();
            plants_adapter.addAll(plants_array);
            plants_adapter.notifyDataSetChanged();
        }

        else if (id==R.id.nav_ills)
        {
            plants_array = getResources().getStringArray(R.array.ills);
            plants_adapter.clear();
            plants_adapter.addAll(plants_array);
            plants_adapter.notifyDataSetChanged();
        }

        else if (id==R.id.nav_identifier)
        {
            plants_array = getResources().getStringArray(R.array.identifier);
            plants_adapter.clear();
            plants_adapter.addAll(plants_array);
            plants_adapter.notifyDataSetChanged();
        }

        else if (id==R.id.nav_recipes)
        {
            plants_array = getResources().getStringArray(R.array.recipes);
            plants_adapter.clear();
            plants_adapter.addAll(plants_array);
            plants_adapter.notifyDataSetChanged();
        }

        else if (id==R.id.nav_collection_storage)
        {
            plants_array = getResources().getStringArray(R.array.collection_storage);
            plants_adapter.clear();
            plants_adapter.addAll(plants_array);
            plants_adapter.notifyDataSetChanged();
        }

        else if (id==R.id.nav_advices)
        {
            plants_array = getResources().getStringArray(R.array.advices);
            plants_adapter.clear();
            plants_adapter.addAll(plants_array);
            plants_adapter.notifyDataSetChanged();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }
}