package com.example.rollthedice.View;



import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Bundle;

import com.example.rollthedice.Entities.GameMode;
import com.example.rollthedice.R;
import com.example.rollthedice.Router.Router;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;


public class DiceView extends AppCompatActivity {

    Context context = this;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diceview);
        ImageView diceImage = findViewById(R.id.diceImageView);
        ImageView btnOpenMenu = findViewById(R.id.configIconDiceView);

        cambiarColorDeFondo();

        btnOpenMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainView.showOptionsMenuDialog(context);
            }
        });
        diceImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int randomInt = randomNumberGenerator();
                Router.openQuestion(DiceView.this, TransitionView.class, randomInt);
            }
        });
    }



    public void cambiarColorDeFondo() {
        final ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), getResources().getColor(R.color.yellowMitology), getResources().getColor(R.color.redFood),
               getResources().getColor(R.color.greenNature),
              getResources().getColor(R.color.purpleTecnology),
              getResources().getColor(R.color.orangeTrips));

        colorAnimation.setDuration(5000);
        colorAnimation.setRepeatCount(ValueAnimator.INFINITE);
        colorAnimation.setRepeatMode(ValueAnimator.REVERSE);

        colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(@NonNull ValueAnimator animator) {
                getWindow().getDecorView().setBackgroundColor((int) animator.getAnimatedValue());
            }
        });

        colorAnimation.start();
    }

    public int randomNumberGenerator() {
        if (GameMode.categoria == -2) {

            Random random = new Random();
            return random.nextInt(5);
        }
        else {
            return GameMode.indexSpinner;
        }
    }

}


