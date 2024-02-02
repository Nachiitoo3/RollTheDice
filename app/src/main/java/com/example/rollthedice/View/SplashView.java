package com.example.rollthedice.View;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.rollthedice.Presenter.SplashPresenter;
import com.example.rollthedice.R;

public class SplashView extends SplashPresenter {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashview);



        ImageView mSplash = findViewById(R.id.fondo);
      /*  Glide.with(this)
                .load(R.drawable.splashgiff)
                .transition(DrawableTransitionOptions.withCrossFade(2000))
                .centerCrop()
                .placeholder(new ColorDrawable(this.getResources().getColor(R.color.orangeTrips)))
                .into(mSplash);*/

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


/* super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ImageView rayo = findViewById(R.id.logo);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.blink);
        rayo.startAnimation(animation);
        ImageView mSplash = findViewById(R.id.fondo);


        Glide.with(this)
                .load(R.drawable.fondo_mar)
                .transition(DrawableTransitionOptions.withCrossFade(2000))
                .centerCrop()
                .placeholder(new ColorDrawable(this.getResources().getColor(R.color.teal_700)))
                .into(mSplash);
        openApp();
*/