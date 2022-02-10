package com.example.medicinal_plants.settings;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.medicinal_plants.R;
import com.example.medicinal_plants.db.DbTableMedplantsManager;

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

    public void onMedPlantsClick(View view){
        Intent intent = new Intent(DbTableList.this, DbTableMedplantsManager.class);
        startActivity(intent);
    }

    private void onIllsClick(){

    }
    private void onRecipesClick(){

    }
    private void onColStorClick(){

    }
    private void onAdvicesClick(){

    }

}
