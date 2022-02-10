package com.example.medicinal_plants.db;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.medicinal_plants.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DbTableMedplantsManager extends AppCompatActivity implements View.OnClickListener {

    private ActionBar actionBar;
    private EditText nameMedPlants;
    private EditText descMedPlants;
    private EditText illsThreat;
    private DbFunctions dbFunctions;
    private Button save_btn;
    private Button update_search_btn;
    private Button delete_btn;

    private int request_code = 555;

    private ConstraintLayout constraintLayout;
    private ImageView imageViewPlant;
    private ImageButton searchImage, deleteImage;
    private FloatingActionButton addImage;
    private String tempPhotoUri = "Empty";

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
        dbFunctions = new DbFunctions(this);
        nameMedPlants = findViewById(R.id.name_plants_et);
        descMedPlants = findViewById(R.id.description_plants_et);
        illsThreat = findViewById(R.id.ills_treat_et);
        save_btn = findViewById(R.id.save_btn);
        update_search_btn = findViewById(R.id.update_search_btn);
        delete_btn = findViewById(R.id.delete_btn);

        constraintLayout = findViewById(R.id.clEditImage);
        imageViewPlant = findViewById(R.id.imagePlant);
        addImage = findViewById(R.id.fabAddImage);
        searchImage = findViewById(R.id.ibSearchImage);
        deleteImage = findViewById(R.id.ibDeleteImage);
        addImage.setOnClickListener(this);
        searchImage.setOnClickListener(this);
        deleteImage.setOnClickListener(this);

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
        dbFunctions.openDB();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbFunctions.closeDB();
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
                    dbFunctions.insertInDB(nameMedPlants.getText().toString(),
                            descMedPlants.getText().toString(),
                            illsThreat.getText().toString(), tempPhotoUri);
                    Toast toast = Toast.makeText(this, R.string.med_plants_save, Toast.LENGTH_LONG);
                    toast.show();
                    nameMedPlants.setText("");
                    descMedPlants.setText("");
                    illsThreat.setText("");
                    imageViewPlant.setImageResource(R.drawable.logo);
                    tempPhotoUri = "Empty";
                }
                break;

            case R.id.fabAddImage:
                constraintLayout.setVisibility(View.VISIBLE);
                addImage.setVisibility(View.GONE);
                break;

            case R.id.ibDeleteImage:
                constraintLayout.setVisibility(View.GONE);
                addImage.setVisibility(View.VISIBLE);
                tempPhotoUri = "Empty";
                imageViewPlant.setImageResource(R.drawable.logo);
                break;

            case R.id.ibSearchImage:
                Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                intent.setType("image/*");
                startActivityForResult(intent, request_code);
                break;

        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK && requestCode == request_code && data != null) {
            getContentResolver().takePersistableUriPermission(data.getData(), Intent.FLAG_GRANT_READ_URI_PERMISSION);
            tempPhotoUri = data.getData().toString();
            imageViewPlant.setImageURI(data.getData());
        }

    }
}
