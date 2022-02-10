package com.example.medicinal_plants;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.example.medicinal_plants.db.MedPlant;
import com.example.medicinal_plants.settings.SettingsFunctions;

public class PageContentActivity extends AppCompatActivity {

    private ImageView pageContentHeaderImage;
    private TextView content_text;
    private TextView pageContentFooter;
    private ActionBar actionBar;
    private int menu_item = 0;
    private Intent intent;
    private LinearLayout llImageHeader;
    private MedPlant medPlant;
    private SharedPreferences sharedPreferences;
    private Typeface pangolin, oswald, pacifico, robotomono;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_content);
        init();
    }

    private void init(){

        intent = getIntent();

        content_text = findViewById(R.id.page_content_text);
        pageContentHeaderImage = findViewById(R.id.main_content_page_header);
        pageContentFooter = findViewById(R.id.additional_content);
        llImageHeader = findViewById(R.id.llImageHeader);

        if(getSupportActionBar() != null)
        {
            actionBar = getSupportActionBar();
        }

        pangolin = Typeface.createFromAsset(getAssets(),"fonts/Pangolin-Regular.ttf");
        oswald = Typeface.createFromAsset(getAssets(),"fonts/Oswald-Regular.ttf");
        pacifico = Typeface.createFromAsset(getAssets(),"fonts/Pacifico-Regular.ttf");
        robotomono = Typeface.createFromAsset(getAssets(),"fonts/RobotoMono-Regular.ttf");
        content_text.setTypeface(pangolin);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        SettingsFunctions.setTextSize(content_text, sharedPreferences);
        SettingsFunctions.setTextFont(content_text, sharedPreferences, oswald, pacifico, pangolin, robotomono);
        SettingsFunctions.setTextDecoration(content_text, sharedPreferences);
        setTextColors();
        setBackgroundColors();
        setActionbarColors();

    }

    @Override
    protected void onResume() {
        super.onResume();
        setContentText();
    }

    private void setContentText(){
        if(intent != null){
            menu_item = intent.getIntExtra("menu_item", 0);
            medPlant = (MedPlant) intent.getSerializableExtra("selected_plant");
        }
        switch (menu_item){
            case 0:
                content_text.setText(medPlant.getDesc());
                if(getSupportActionBar() != null)
                {
                    actionBar.setTitle(medPlant.getName());
                }
                pageContentFooter.setText(medPlant.getIll());
                if(medPlant.getPhoto().equals("Empty")){
                    llImageHeader.setVisibility(View.GONE);
                } else {
                    pageContentHeaderImage.setImageURI(Uri.parse(medPlant.getPhoto()));
                }
                break;
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;
        }
    }

    public void setTextColors() {
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

    public void setBackgroundColors() {
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

    public void setActionbarColors() {
        String actionbar_color = sharedPreferences.getString("actionbar_color_settings", "Стандартный");
        if(actionbar_color != null){
            switch (actionbar_color){
                case "Черный":
                    actionBar.setBackgroundDrawable(new ColorDrawable(Color.BLACK));
                    pageContentFooter.setBackgroundColor(Color.BLACK);
                    break;
                case "Белый":
                    actionBar.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                    pageContentFooter.setBackgroundColor(Color.WHITE);
                    break;
                case "Желтый":
                    actionBar.setBackgroundDrawable(new ColorDrawable(Color.YELLOW));
                    pageContentFooter.setBackgroundColor(Color.YELLOW);
                    break;
                case "Красный":
                    actionBar.setBackgroundDrawable(new ColorDrawable(Color.RED));
                    pageContentFooter.setBackgroundColor(Color.RED);
                    break;
                case "Зеленый":
                    actionBar.setBackgroundDrawable(new ColorDrawable(Color.GREEN));
                    pageContentFooter.setBackgroundColor(Color.GREEN);
                    break;
                case "Синий":
                    actionBar.setBackgroundDrawable(new ColorDrawable(Color.BLUE));
                    pageContentFooter.setBackgroundColor(Color.BLUE);
                    break;
                case "Серый":
                    actionBar.setBackgroundDrawable(new ColorDrawable(Color.GRAY));
                    pageContentFooter.setBackgroundColor(Color.GRAY);
                    break;
                case "Стандартный":
                    actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.purple_500)));
                    pageContentFooter.setBackgroundColor(getResources().getColor(R.color.purple_500));
                    break;
                case "Фиолетовый":
                    actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.purple_200)));
                    pageContentFooter.setBackgroundColor(getResources().getColor(R.color.purple_200));
                    break;
            }
        }
    }

}
