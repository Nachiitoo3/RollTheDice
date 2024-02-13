package com.nadrial.rollthedice.Activities;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.nadrial.rollthedice.Entities.Category;
import com.nadrial.rollthedice.Entities.GameMode;
import com.nadrial.rollthedice.R;
import com.nadrial.rollthedice.Navigator;

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

        configIcon.setOnClickListener(v -> MainMenu.showOptionsMenuDialog(context));
        diceImage.setOnClickListener(v -> {
            randomCategoryGenerator();
            animDice();
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
        colorAnimation.addUpdateListener(animator -> getWindow().getDecorView().setBackgroundColor((int) animator.getAnimatedValue()));

        colorAnimation.start();
    }

    public void randomCategoryGenerator() {
        if (GameMode.mode != 2) {
            Random random = new Random();
            Category.setCategory(random.nextInt(5));

        }

    }
    public void transitionAnimDice(Context context) {
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            Navigator.openActivity(context, TransitionDiceIntoQuestion.class);
            finish();
        }, 3500);
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
        transitionAnimDice(this);
    }

}


