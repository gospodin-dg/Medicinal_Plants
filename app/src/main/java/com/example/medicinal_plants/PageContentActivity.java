package com.example.medicinal_plants;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class PageContentActivity extends AppCompatActivity {

    private ImageView pageContentHeader;
    private LinearLayout pageContentFooter;
    private ActionBar actionBar;
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
    private Typeface pangolin, oswald, pacifico, robotomono;

    private String[] medicinal_plants_titles;
    private String[] ills_titles;
    private String[] identifier_titles;
    private String[] recipes_titles;
    private String[] collection_storage_titles;
    private String[] advices_titles;
    private SharedPreferences sharedPreferences;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_content);
        init();
        setContentText();
    }

    private void init(){
        intent = getIntent();
        content_text = findViewById(R.id.page_content_text);
        if(getSupportActionBar() != null)
        {
            actionBar = getSupportActionBar();
        }
        pangolin = Typeface.createFromAsset(getAssets(),"fonts/Pangolin-Regular.ttf");
        oswald = Typeface.createFromAsset(getAssets(),"fonts/Oswald-Regular.ttf");
        pacifico = Typeface.createFromAsset(getAssets(),"fonts/Pacifico-Regular.ttf");
        robotomono = Typeface.createFromAsset(getAssets(),"fonts/RobotoMono-Regular.ttf");
        content_text.setTypeface(pangolin);
        medicinal_plants_titles = getResources().getStringArray(R.array.medicinal_plants);
        ills_titles = getResources().getStringArray(R.array.ills);
        identifier_titles = getResources().getStringArray(R.array.identifier);
        recipes_titles = getResources().getStringArray(R.array.recipes);
        collection_storage_titles = getResources().getStringArray(R.array.collection_storage);
        advices_titles = getResources().getStringArray(R.array.advices);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        pageContentHeader = findViewById(R.id.main_content_page_header);
        pageContentFooter = findViewById(R.id.main_content_page_footer);

        setTextSize();
        setTextFont();
        setTextDecoration();
        setTextColors();
        setBackgroundColors();
        setActionbarColors();
    }

    private void setContentText(){
        if(intent != null){
            menu_item = intent.getIntExtra("menu_item", 0);
            menu_item_item = intent.getIntExtra("menu_item_item", 0);
        }

        switch (menu_item){
            case 0:
                content_text.setText(medicinal_plants[menu_item_item]);
                setTitleActionBar(medicinal_plants_titles, menu_item_item);
                break;
            case 1:
                content_text.setText(ills[menu_item_item]);
                setTitleActionBar(ills_titles, menu_item_item);
                break;
            case 2:
                content_text.setText(identifier[menu_item_item]);
                setTitleActionBar(identifier_titles, menu_item_item);
                break;
            case 3:
                content_text.setText(recipes[menu_item_item]);
                setTitleActionBar(recipes_titles, menu_item_item);
                break;
            case 4:
                content_text.setText(collection_storage[menu_item_item]);
                setTitleActionBar(collection_storage_titles, menu_item_item);
                break;
            case 5:
                content_text.setText(advices[menu_item_item]);
                setTitleActionBar(advices_titles, menu_item_item);
                break;
        }
    }

    private void setTitleActionBar(String[] selected_menu_item, int selected_menu_item_item)
    {
        if (getSupportActionBar() != null)
        {
            actionBar.setTitle(selected_menu_item[selected_menu_item_item]);
        }
    }

    private void setTextSize() {
        String text_size = sharedPreferences.getString("text_size_settings", "15");
        if(text_size != null){
            switch (text_size){
                case "10":
                    content_text.setTextSize(10);
                    break;
                case "15":
                    content_text.setTextSize(15);
                    break;
                case "20":
                    content_text.setTextSize(20);
                    break;
                case "25":
                    content_text.setTextSize(25);
                    break;
                case "30":
                    content_text.setTextSize(30);
                    break;
            }
        }
    }

    private void setTextFont() {
        String text_font = sharedPreferences.getString("text_font_settings", "Pacifico");
        if(text_font != null){
            switch (text_font){
                case "Oswald":
                    content_text.setTypeface(oswald);
                    break;
                case "Pacifico":
                    content_text.setTypeface(pacifico);
                    break;
                case "Pangolin":
                    content_text.setTypeface(pangolin);
                    break;
                case "RobotoMono":
                    content_text.setTypeface(robotomono);
                    break;
            }
        }
    }

    private void setTextDecoration() {
        String text_decoration = sharedPreferences.getString("text_style_settings", "Обычный");
        if(text_decoration != null){
            switch (text_decoration){
                case "Жирный":
                    content_text.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                    break;
                case "Курсив":
                    content_text.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC));
                    break;
                case "Жирный-Курсив":
                    content_text.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD_ITALIC));
                    break;
                case "Обычный":
                    content_text.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                    break;
            }
        }
    }

    private void setTextColors() {
        String text_color = sharedPreferences.getString("text_color_settings", "Черный");
        if(text_color != null){
            switch (text_color){
                case "Черный":
                    content_text.setTextColor(Color.BLACK);
                    break;
                case "Белый":
                    content_text.setTextColor(Color.WHITE);
                    break;
                case "Желтый":
                    content_text.setTextColor(Color.YELLOW);
                    break;
                case "Красный":
                    content_text.setTextColor(Color.RED);
                    break;
                case "Зеленый":
                    content_text.setTextColor(Color.GREEN);
                    break;
                case "Синий":
                    content_text.setTextColor(Color.BLUE);
                    break;
                case "Серый":
                    content_text.setTextColor(Color.GRAY);
                    break;
                case "Стандартный":
                    content_text.setTextColor(getResources().getColor(R.color.purple_500));
                    break;
                case "Фиолетовый":
                    content_text.setTextColor(getResources().getColor(R.color.purple_200));
                    break;
            }
        }
    }

    private void setBackgroundColors() {
        String background_color = sharedPreferences.getString("background_color_settings", "Белый");
        if(background_color != null){
            switch (background_color){
                case "Черный":
                    content_text.setBackgroundColor(Color.BLACK);
                    break;
                case "Белый":
                    content_text.setBackgroundColor(Color.WHITE);
                    break;
                case "Желтый":
                    content_text.setBackgroundColor(Color.YELLOW);
                    break;
                case "Красный":
                    content_text.setBackgroundColor(Color.RED);
                    break;
                case "Зеленый":
                    content_text.setBackgroundColor(Color.GREEN);
                    break;
                case "Синий":
                    content_text.setBackgroundColor(Color.BLUE);
                    break;
                case "Серый":
                    content_text.setBackgroundColor(Color.GRAY);
                    break;
                case "Стандартный":
                    content_text.setBackgroundColor(getResources().getColor(R.color.purple_500));
                    break;
                case "Фиолетовый":
                    content_text.setBackgroundColor(getResources().getColor(R.color.purple_200));
                    break;
            }
        }
    }

    private void setActionbarColors() {
        String actionbar_color = sharedPreferences.getString("actionbar_color_settings", "Стандартный");
        if(actionbar_color != null){
            switch (actionbar_color){
                case "Черный":
                    actionBar.setBackgroundDrawable(new ColorDrawable(Color.BLACK));
                    pageContentHeader.setBackgroundColor(Color.BLACK);
                    pageContentFooter.setBackgroundColor(Color.BLACK);
                    break;
                case "Белый":
                    actionBar.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                    pageContentHeader.setBackgroundColor(Color.WHITE);
                    pageContentFooter.setBackgroundColor(Color.WHITE);
                    break;
                case "Желтый":
                    actionBar.setBackgroundDrawable(new ColorDrawable(Color.YELLOW));
                    pageContentHeader.setBackgroundColor(Color.YELLOW);
                    pageContentFooter.setBackgroundColor(Color.YELLOW);
                    break;
                case "Красный":
                    actionBar.setBackgroundDrawable(new ColorDrawable(Color.RED));
                    pageContentHeader.setBackgroundColor(Color.RED);
                    pageContentFooter.setBackgroundColor(Color.RED);
                    break;
                case "Зеленый":
                    actionBar.setBackgroundDrawable(new ColorDrawable(Color.GREEN));
                    pageContentHeader.setBackgroundColor(Color.GREEN);
                    pageContentFooter.setBackgroundColor(Color.GREEN);
                    break;
                case "Синий":
                    actionBar.setBackgroundDrawable(new ColorDrawable(Color.BLUE));
                    pageContentHeader.setBackgroundColor(Color.BLUE);
                    pageContentFooter.setBackgroundColor(Color.BLUE);
                    break;
                case "Серый":
                    actionBar.setBackgroundDrawable(new ColorDrawable(Color.GRAY));
                    pageContentHeader.setBackgroundColor(Color.GRAY);
                    pageContentFooter.setBackgroundColor(Color.GRAY);
                    break;
                case "Стандартный":
                    actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.purple_500)));
                    pageContentHeader.setBackgroundColor(getResources().getColor(R.color.purple_500));
                    pageContentFooter.setBackgroundColor(getResources().getColor(R.color.purple_500));
                    break;
                case "Фиолетовый":
                    actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.purple_200)));
                    pageContentHeader.setBackgroundColor(getResources().getColor(R.color.purple_200));
                    pageContentFooter.setBackgroundColor(getResources().getColor(R.color.purple_200));
                    break;
            }
        }
    }
}
