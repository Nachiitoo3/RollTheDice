package com.nadrial.rollthedice.Activities;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import pl.droidsonroids.gif.AnimationListener;
import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

import com.nadrial.rollthedice.Entities.Category;
import com.nadrial.rollthedice.Entities.GameMode;
import com.nadrial.rollthedice.R;
import com.nadrial.rollthedice.Navigator;

import java.util.Random;

public class Dice extends AppCompatActivity {

    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diceview);

        GifImageView diceImage = findViewById(R.id.diceImageView);
        ImageView configIcon = findViewById(R.id.configIconDiceView);

        changeBackgroundColor();

        configIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainMenu.showOptionsMenuDialog(context);
            }
        });

        diceImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cuando el usuario hace clic en la imagen del dado
                // Se genera una categoría aleatoria y se inicia la animación
                randomCategoryGenerator();
                animDice();
            }
        });
    }

    public void changeBackgroundColor() {
        final ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(),
                getResources().getColor(R.color.yellowMitology),
                getResources().getColor(R.color.redFood),
                getResources().getColor(R.color.greenNature),
                getResources().getColor(R.color.purpleTecnology),
                getResources().getColor(R.color.orangeTrips));

        colorAnimation.setDuration(5000);
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

    public void randomCategoryGenerator() {
        if (GameMode.mode != 2) {
            Random random = new Random();
            Category.setCategory(random.nextInt(5));
        }
    }

    public void transitionAnimDice(Context context, Class<?> cls) {
        Navigator.openActivity(context, cls);
        finish();
    }

    private void animDice() {
        GifImageView gifImageView = findViewById(R.id.diceImageView);

        try {
            GifDrawable gifDrawable = new GifDrawable(getResources(), R.drawable.animcultviajes);
            gifImageView.setImageDrawable(gifDrawable);

            gifDrawable.addAnimationListener(new AnimationListener() {
                @Override
                public void onAnimationCompleted(int loopNumber) {
                    // La animación ha terminado, ahora puedes iniciar la transición
                    transitionAnimDice(Dice.this, TransitionDiceIntoQuestion.class);
                }
            });

            // Inicia la animación manualmente
            gifDrawable.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
