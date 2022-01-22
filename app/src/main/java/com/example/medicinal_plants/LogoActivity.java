package com.example.medicinal_plants;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LogoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logo);
    }

    public void onClickStartApp(View view) {
        Intent intent = new Intent(LogoActivity.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }
}