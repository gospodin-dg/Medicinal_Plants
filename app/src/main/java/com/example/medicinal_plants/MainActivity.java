package com.example.medicinal_plants;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
//import android.widget.Toolbar;
import androidx.appcompat.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.medicinal_plants.db.DbContentManagement;
import com.example.medicinal_plants.db.MedPlant;
import com.example.medicinal_plants.db.MyAdapter;
import com.example.medicinal_plants.settings.DbTableList;
import com.example.medicinal_plants.settings.SettingsActivity;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {

    private DbContentManagement dbContentManagement;
    private ArrayList<MedPlant> medPlantsNameList;
    private String[] plants_array;
    private ListView plants_view;
    private MyAdapter plants_adapter;
    private Toolbar toolbar;
    private int menu_item = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){



        plants_view = findViewById(R.id.plants_view);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.menu_medicinal_plants);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        plants_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(MainActivity.this, PageContentActivity.class);
                intent.putExtra("menu_item", menu_item);
                intent.putExtra("menu_item_item", position);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        dbContentManagement = new DbContentManagement(this);
        dbContentManagement.openDB();
        medPlantsNameList = dbContentManagement.readAllFromDB();
        plants_adapter = new MyAdapter(this, R.layout.list_item, medPlantsNameList);
        plants_view.setAdapter(plants_adapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbContentManagement.closeDB();
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

        if(id == R.id.action_settings) {
            Intent intent1 = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent1);
        }
        else if(id == R.id.management_content){
            Intent intent2 = new Intent(MainActivity.this, DbTableList.class);
            startActivity(intent2);
        }

        return super.onOptionsItemSelected(item);

    }

    private void setContentList(int page_title, int menu_identifier)
    {

        plants_adapter.clear();
        medPlantsNameList = dbContentManagement.readAllFromDB();
        plants_adapter.addAll(medPlantsNameList);
        plants_adapter.notifyDataSetChanged();
        toolbar.setTitle(page_title);
        menu_item = menu_identifier;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id==R.id.nav_medicinal_plants)
        {
            setContentList(R.string.menu_medicinal_plants, 0);
        }

     else if (id==R.id.nav_ills)
        {
            setContentList(R.string.menu_ills, 1);

        }

     /*   else if (id==R.id.nav_identifier)
        {
            setContentList(R.array.identifier, R.string.menu_identifier, 2);
        }

        else if (id==R.id.nav_recipes)
        {
            setContentList(R.array.recipes, R.string.menu_recipes, 3);
        }

        else if (id==R.id.nav_collection_storage)
        {
            setContentList(R.array.collection_storage, R.string.menu_collection_storage, 4);
        }

        else if (id==R.id.nav_advices)
        {
            setContentList(R.array.advices, R.string.menu_advices, 5);
        }*/

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }
}