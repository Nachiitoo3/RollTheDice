package com.example.rollthedice.View;

import android.os.Bundle;

import com.example.rollthedice.Presenter.DicePresenter;
import com.example.rollthedice.R;
import com.example.rollthedice.Router.Router;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class DiceView extends DicePresenter {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diceview);
        cambiarColorDeFondo(this);
        ImageView diceImage = findViewById(R.id.diceImageView);
        diceImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int randomInt = generarNumeroAleatorio();
                Router.openQuestion(DiceView.this, TransitionView.class, randomInt);
            }
        });
    }


}


