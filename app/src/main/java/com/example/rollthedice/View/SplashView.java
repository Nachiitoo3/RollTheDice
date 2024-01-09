package com.example.rollthedice.View;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.rollthedice.Presenter.SplashPresenter;
import com.example.rollthedice.R;

public class SplashView extends SplashPresenter {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashview);

        transition(this);


    }


}
