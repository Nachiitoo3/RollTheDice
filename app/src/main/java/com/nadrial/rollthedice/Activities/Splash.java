package com.nadrial.rollthedice.Activities;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;


import com.nadrial.rollthedice.R;
import com.nadrial.rollthedice.Navigator;

public class Splash extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashview);

        splash();
    }

    public static void transition(Context context, Class<?> cls) {

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Navigator.openActivity(context, Login.class);
            }
        }, 10500);
    }

    private void splash() {

        ImageView mSplash = findViewById(R.id.fondo);

        try {
            Glide.with(this)
                    .load(R.drawable.splashgiff)
                    .into(mSplash);
        } catch (Exception e) {
            e.printStackTrace();
        }
        transition(this, Login.class);
    }

}


