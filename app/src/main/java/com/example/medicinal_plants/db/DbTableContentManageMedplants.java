package com.example.medicinal_plants.db;

import static com.example.medicinal_plants.R.id.save_btn;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.medicinal_plants.R;

public class DbTableContentManageMedplants extends AppCompatActivity implements View.OnClickListener {

    private ActionBar actionBar;
    private EditText nameMedPlants;
    private EditText descMedPlants;
    private EditText illsThreat;
    private DbContentManagement dbContentManagement;
    private Button save_btn;
    private Button update_search_btn;
    private Button delete_btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.db_table_content_manage_medplants);
        init();
    }

    private  void init() {
        if(getSupportActionBar() != null) {
            actionBar = getSupportActionBar();
            actionBar.setTitle(getString(R.string.menu_medicinal_plants));
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        dbContentManagement = new DbContentManagement(this);
        nameMedPlants = findViewById(R.id.name_plants_et);
        descMedPlants = findViewById(R.id.description_plants_et);
        illsThreat = findViewById(R.id.ills_treat_et);
        save_btn = findViewById(R.id.save_btn);
        update_search_btn = findViewById(R.id.update_search_btn);
        delete_btn = findViewById(R.id.delete_btn);
        save_btn.setOnClickListener(this);
        update_search_btn.setOnClickListener(this);
        delete_btn.setOnClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home){
            finish();
        }
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        dbContentManagement.openDB();
    }

    /*public void onClickSave(View v) {

        if(nameMedPlants.getText().toString().equals("")||
            descMedPlants.getText().toString().equals("")||
            illsThreat.getText().toString().equals("")) {
            Toast toast = Toast.makeText(this, R.string.med_plants_no_save, Toast.LENGTH_LONG);
            toast.show();
        }
        else {
            dbContentManagement.insertInDB(nameMedPlants.getText().toString(),
                descMedPlants.getText().toString(),
                illsThreat.getText().toString());
            Toast toast = Toast.makeText(this, R.string.med_plants_save, Toast.LENGTH_LONG);
            toast.show();
            nameMedPlants.setText("");
            descMedPlants.setText("");
            illsThreat.setText("");
        }
    }*/

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbContentManagement.closeDB();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.save_btn:
                if (nameMedPlants.getText().toString().equals("") ||
                        descMedPlants.getText().toString().equals("") ||
                        illsThreat.getText().toString().equals("")) {
                    Toast toast = Toast.makeText(this, R.string.med_plants_no_save, Toast.LENGTH_LONG);
                    toast.show();
                }
                else {
                    dbContentManagement.insertInDB(nameMedPlants.getText().toString(),
                            descMedPlants.getText().toString(),
                            illsThreat.getText().toString());
                    Toast toast = Toast.makeText(this, R.string.med_plants_save, Toast.LENGTH_LONG);
                    toast.show();
                    nameMedPlants.setText("");
                    descMedPlants.setText("");
                    illsThreat.setText("");
                }
                break;
        }


    }
}
