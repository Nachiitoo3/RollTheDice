package com.example.rollthedice.View;

import android.content.Intent;

import android.os.Bundle;
import android.os.Handler;

import android.widget.ImageView;
import android.widget.TextView;


import com.example.rollthedice.Presenter.TransitionPresenter;
import com.example.rollthedice.R;


public class TransitionView extends TransitionPresenter {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transitionview);

        setScreen(getNumber());
        transition(this);

    }

}