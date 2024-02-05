package com.example.rollthedice.View;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.rollthedice.R;
import com.example.rollthedice.Router.Router;

public class SplashView extends AppCompatActivity {


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
                Router.openActivity(context, LoginView.class);
            }
        }, 8500);


    }

    private void splash(){

        ImageView mSplash = findViewById(R.id.fondo);

        try {
            Glide.with(this)
                    .load(R.drawable.splashgiff)
                    .into(mSplash);
        } catch (Exception e) {
            e.printStackTrace();
        }

        transition(this, LoginView.class);

    }

}


