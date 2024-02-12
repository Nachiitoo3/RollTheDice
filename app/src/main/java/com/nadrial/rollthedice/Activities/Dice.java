package com.nadrial.rollthedice.Activities;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.nadrial.rollthedice.Entities.Category;
import com.nadrial.rollthedice.Entities.GameMode;
import com.nadrial.rollthedice.Navigator;
import com.nadrial.rollthedice.R;

import java.util.Random;


public class Dice extends AppCompatActivity {

    Context context = this;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diceview);

        ImageView diceImage = findViewById(R.id.diceImageView);
        ImageView configIcon = findViewById(R.id.configIconDiceView);

        changeBackgroungColor();

        configIcon.setOnClickListener(v -> MainMenu.showOptionsMenuDialog(context));
        diceImage.setOnClickListener(v -> {
            randomCategoryGenerator();
            Navigator.openActivity(Dice.this, TransitionDiceIntoQuestion.class);
            finish();
        });
    }

    public void changeBackgroungColor() {
        final ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), ContextCompat.getColor(this,R.color.yellowMitology), ContextCompat.getColor(this,R.color.redFood),
                ContextCompat.getColor(this,R.color.greenNature),
                ContextCompat.getColor(this,R.color.purpleTecnology),
                ContextCompat.getColor(this,R.color.orangeTrips));

        colorAnimation.setDuration(5000);
        colorAnimation.setRepeatCount(ValueAnimator.INFINITE);
        colorAnimation.setRepeatMode(ValueAnimator.REVERSE);
        colorAnimation.addUpdateListener(animator -> getWindow().getDecorView().setBackgroundColor((int) animator.getAnimatedValue()));

        colorAnimation.start();
    }

    public void randomCategoryGenerator() {
        if (GameMode.mode != 2) {
            Random random = new Random();
            Category.setCategory(random.nextInt(5));

        }

    }
}


