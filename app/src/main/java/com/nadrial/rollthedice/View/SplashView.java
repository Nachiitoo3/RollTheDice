package com.nadrial.rollthedice.View;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.nadrial.rollthedice.Presenter.SplashPresenter;
import com.nadrial.rollthedice.R;

public class SplashView extends SplashPresenter {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashview);



        ImageView mSplash = findViewById(R.id.fondo);

        try {
            Glide.with(this)
                    .load(R.drawable.splashgiff)
                    .into(mSplash);
        } catch (Exception e) {
            e.printStackTrace();
        }

        transition();

    }


}


