package com.example.rollthedice.View;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.rollthedice.R;
import com.example.rollthedice.Router.Router;

import android.view.View;
import android.widget.Button;


import java.util.Random;

public class DiceView extends AppCompatActivity {

    private int[] coloresResources = {R.color.yellowMitology, R.color.redFood, R.color.greenNature, R.color.purpleTecnology, R.color.orangeTrips};
    private int duracionTransicion = 5000;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diceview);
        cambiarColorDeFondo();

        Button diceButton = findViewById(R.id.diceButtonDiceView);

        diceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int randomInt = generarNumeroAleatorio();
                Router.openQuestion(DiceView.this, TransitionView.class, randomInt);


            }
        });
    }



    public void cambiarColorDeFondo() {
        final ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), ContextCompat.getColor(this, coloresResources[0]),
                ContextCompat.getColor(this, coloresResources[1]),
                ContextCompat.getColor(this, coloresResources[2]),
                ContextCompat.getColor(this, coloresResources[3]),
                ContextCompat.getColor(this, coloresResources[4]));

        colorAnimation.setDuration(duracionTransicion);
        colorAnimation.setRepeatCount(ValueAnimator.INFINITE);
        colorAnimation.setRepeatMode(ValueAnimator.REVERSE);

        colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                getWindow().getDecorView().setBackgroundColor((int) animator.getAnimatedValue());
            }
        });

        colorAnimation.start();
    }

    public int generarNumeroAleatorio() {
        Random random = new Random();
        int randomNumber = random.nextInt(5);
        return randomNumber;

    }
}


