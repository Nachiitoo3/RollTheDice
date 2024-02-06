package com.nadrial.rollthedice.View;

import android.os.Bundle;


import com.nadrial.rollthedice.Presenter.TransitionPresenter;
import com.nadrial.rollthedice.R;


public class TransitionView extends TransitionPresenter {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transitionview);

        setScreen(getNumber());
        transition(this);

    }

}