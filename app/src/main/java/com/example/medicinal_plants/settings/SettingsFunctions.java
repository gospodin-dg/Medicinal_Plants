package com.example.medicinal_plants.settings;

import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.widget.TextView;

public class SettingsFunctions {

    public static void setTextSize(TextView content_text, SharedPreferences sharedPreferences) {
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

    public static void setTextDecoration(TextView content_text, SharedPreferences sharedPreferences) {
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

    public static void setTextFont(TextView content_text, SharedPreferences sharedPreferences, Typeface oswald, Typeface pacifico, Typeface pangolin, Typeface robotomono) {
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

}
