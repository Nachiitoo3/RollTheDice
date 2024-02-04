package com.example.rollthedice.View;

import static com.example.rollthedice.Presenter.MainPresenter.showOptionsMenuDialog;

import android.content.Context;
import android.os.Bundle;

import com.example.rollthedice.Presenter.DicePresenter;
import com.example.rollthedice.R;
import com.example.rollthedice.Router.Router;

import android.view.View;
import android.widget.Button;
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

                showOptionsMenuDialog(context);
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


