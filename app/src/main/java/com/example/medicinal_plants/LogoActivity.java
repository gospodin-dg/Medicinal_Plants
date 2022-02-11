package com.example.medicinal_plants;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class LogoActivity extends AppCompatActivity {

    private Animation logoAnimation, buttonAnimation, titleAnimation;
    private ImageView imageLogo;
    private Button buttonStart;
    private TextView titleLogo;

    private ProgressBar progressBar;
    private TextView progressStatus;
    private  int progress = 0;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logo);
        init();
    }

    private void init() {
        imageLogo = findViewById(R.id.image_logo);
        buttonStart = findViewById(R.id.button_start);
        titleLogo = findViewById(R.id.title_logo);

        progressBar = findViewById(R.id.progressBar);
        progressStatus = findViewById(R.id.progressStatus);

        logoAnimation = AnimationUtils.loadAnimation(getBaseContext(), R.anim.logo_animation);
        buttonAnimation = AnimationUtils.loadAnimation(getBaseContext(), R.anim.button_animation);
        titleAnimation = AnimationUtils.loadAnimation(getBaseContext(), R.anim.title_animation);

        imageLogo.startAnimation(logoAnimation);
        buttonStart.startAnimation(buttonAnimation);
        titleLogo.startAnimation(titleAnimation);

    }

    private void startMainActivity() {

        new Thread(new Runnable() {
            @Override
            public void run() {

               handler.post(new Runnable(){
                   @Override
                   public void run() {
                       buttonStart.setVisibility(View.GONE);
                       progressBar.setVisibility(View.VISIBLE);
                       progressStatus.setVisibility(View.VISIBLE);
                   }
               });

                for (int i = 0; i < 100; i++) {
                    progress = i + 1;
                    SystemClock.sleep(20);

                    handler.post(new Runnable(){
                        @Override
                        public void run() {
                            progressBar.setProgress(progress);
                            progressStatus.setText(progress + "%");
                            if(progress == 100){
                                Intent intent = new Intent(LogoActivity.this, MainActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                            }
                        }
                    });
                }

            }
        }).start();
    }


    public void onClickStartApp(View view) {
        startMainActivity();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }

}