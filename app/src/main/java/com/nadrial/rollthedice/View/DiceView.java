package com.nadrial.rollthedice.View;

import android.content.Context;
import android.os.Bundle;

import com.nadrial.rollthedice.Presenter.DicePresenter;
import com.nadrial.rollthedice.R;
import com.nadrial.rollthedice.Router.Router;
import com.nadrial.rollthedice.Presenter.MainPresenter;

import android.view.View;
import android.widget.ImageView;


public class DiceView extends DicePresenter {

    Context context = this;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diceview);
        cambiarColorDeFondo(this);
        ImageView diceImage = findViewById(R.id.diceImageView);
        ImageView btnOpenMenu = findViewById(R.id.configIconDiceView);


        btnOpenMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainPresenter.showOptionsMenuDialog(context);
            }
        });
        diceImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int randomInt = generarNumeroAleatorio();
                Router.openQuestion(DiceView.this, TransitionView.class, randomInt);
            }
        });
    }


}


