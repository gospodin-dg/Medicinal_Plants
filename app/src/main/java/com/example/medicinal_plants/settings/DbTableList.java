package com.example.medicinal_plants.settings;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.medicinal_plants.R;

public class DbTableList extends AppCompatActivity {
    private ActionBar actionBar;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.db_table_list);
        init();
    }

    private  void init() {
        if(getSupportActionBar() != null) {
            actionBar = getSupportActionBar();
            actionBar.setTitle(getString(R.string.management_content));
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home){
            finish();
        }
        return true;
    }

}
