package com.nadrial.rollthedice.Activities;



import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Bundle;

import com.nadrial.rollthedice.Entities.GameMode;
import com.nadrial.rollthedice.R;
import com.nadrial.rollthedice.Navigator;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;


public class Dice extends AppCompatActivity {

    Context context = this;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diceview);
        ImageView diceImage = findViewById(R.id.diceImageView);
        ImageView configIcon = findViewById(R.id.configIconDiceView);

        changeBackgroungColor();

        configIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainMenu.showOptionsMenuDialog(context);
            }
        });
        diceImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                randomCategoryGenerator();
                Navigator.openActivity(Dice.this, TransitionDiceIntoQuestion.class);
            }
        });
    }



    public void changeBackgroungColor() {
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

    public void randomCategoryGenerator() {
        if (GameMode.mode == 2) {

        }else {
            Random random = new Random();
            GameMode.setCategory(random.nextInt(5));
        }

    }

}


