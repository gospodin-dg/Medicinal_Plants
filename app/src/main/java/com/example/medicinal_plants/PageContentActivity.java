package com.example.medicinal_plants;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PageContentActivity extends AppCompatActivity {

    private int menu_item = 0;
    private int menu_item_item = 0;
    private Intent intent;
    private int[] medicinal_plants = {R.string.medicinal_plants_0, R.string.medicinal_plants_1, R.string.medicinal_plants_2, R.string.medicinal_plants_3,
                                      R.string.medicinal_plants_4, R.string.medicinal_plants_5, R.string.medicinal_plants_6, R.string.medicinal_plants_7,
                                      R.string.medicinal_plants_8, R.string.medicinal_plants_9, R.string.medicinal_plants_10, R.string.medicinal_plants_11,
                                      R.string.medicinal_plants_12, R.string.medicinal_plants_13, R.string.medicinal_plants_14, R.string.medicinal_plants_15,
                                      R.string.medicinal_plants_16, R.string.medicinal_plants_17, R.string.medicinal_plants_18, R.string.medicinal_plants_19,
                                      R.string.medicinal_plants_20, R.string.medicinal_plants_21, R.string.medicinal_plants_22, R.string.medicinal_plants_23,
                                      R.string.medicinal_plants_24, R.string.medicinal_plants_25, R.string.medicinal_plants_26};
    private int[] ills = {R.string.ills_0, R.string.ills_1, R.string.ills_2, R.string.ills_3, R.string.ills_4, R.string.ills_5, R.string.ills_6,
                          R.string.ills_7, R.string.ills_8};
    private int[] identifier = {R.string.identifier_0, R.string.identifier_1, R.string.identifier_2, R.string.identifier_3, R.string.identifier_4};
    private int[] recipes = {R.string.recipes_0, R.string.recipes_1, R.string.recipes_2, R.string.recipes_3, R.string.recipes_4};
    private int[] collection_storage = {R.string.collection_storage_0, R.string.collection_storage_1, R.string.collection_storage_2, R.string.collection_storage_3};
    private int[] advices = {R.string.advices_0, R.string.advices_1, R.string.advices_2, R.string.advices_3};
    private TextView content_text;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_content);
        intent = getIntent();
        content_text = findViewById(R.id.page_content_text);
        setContentText();
    }

    private void setContentText(){
        if(intent != null){
            menu_item = intent.getIntExtra("menu_item", 0);
            menu_item_item = intent.getIntExtra("menu_item_item", 0);
        }

        switch (menu_item){
            case 0:
                content_text.setText(medicinal_plants[menu_item_item]);
                break;
            case 1:
                content_text.setText(ills[menu_item_item]);
                break;
            case 2:
                content_text.setText(identifier[menu_item_item]);
                break;
            case 3:
                content_text.setText(recipes[menu_item_item]);
                break;
            case 4:
                content_text.setText(collection_storage[menu_item_item]);
                break;
            case 5:
                content_text.setText(advices[menu_item_item]);
                break;
        }
    }

}
