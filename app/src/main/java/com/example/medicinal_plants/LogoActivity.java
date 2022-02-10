package com.example.medicinal_plants;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class LogoActivity extends AppCompatActivity {

    private Animation logoAnimation, buttonAnimation, titleAnimation;
    private ImageView imageLogo;
    private Button buttonStart;
    private TextView titleLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logo);
        init();
//        startMainActivity();
    }

    private void init() {
        imageLogo = findViewById(R.id.image_logo);
        buttonStart = findViewById(R.id.button_start);
        titleLogo = findViewById(R.id.title_logo);

        logoAnimation = AnimationUtils.loadAnimation(getBaseContext(), R.anim.logo_animation);
        buttonAnimation = AnimationUtils.loadAnimation(getBaseContext(), R.anim.button_animation);
        titleAnimation = AnimationUtils.loadAnimation(getBaseContext(), R.anim.title_animation);

        imageLogo.startAnimation(logoAnimation);
        buttonStart.startAnimation(buttonAnimation);
        titleLogo.startAnimation(titleAnimation);
    }

/*    private void startMainActivity() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    Intent intent = new Intent(LogoActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }*/


    public void onClickStartApp(View view) {
        Intent intent = new Intent(LogoActivity.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }



}