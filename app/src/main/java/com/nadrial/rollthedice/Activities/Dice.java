package com.nadrial.rollthedice.Activities;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.nadrial.rollthedice.Entities.Category;
import com.nadrial.rollthedice.Entities.GameMode;
import com.nadrial.rollthedice.R;
import com.nadrial.rollthedice.Navigator;

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
                animDice();
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
        if (GameMode.mode != 2) {
            Random random = new Random();
            Category.setCategory(random.nextInt(5));

        }

    }

    public void transitionAnimDice(Context context, Class<?> cls) {

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Navigator.openActivity(context, TransitionDiceIntoQuestion.class);
                finish();
            }
        }, 10500);
    }

    private void animDice() {

        ImageView dice = findViewById(R.id.diceImageView);

        try {
            Glide.with(this)
                    .load(R.drawable.animcultviajes)
                    .into(dice);
        } catch (Exception e) {
            e.printStackTrace();
        }
        transitionAnimDice(this, TransitionDiceIntoQuestion.class);
    }



}


