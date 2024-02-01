package com.example.rollthedice.Presenter;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.rollthedice.Entities.GameMode;
import com.example.rollthedice.R;
import com.example.rollthedice.View.DiceView;

import java.util.Random;

public class DicePresenter extends AppCompatActivity {

    private int[] coloresResources = {R.color.yellowMitology, R.color.redFood, R.color.greenNature, R.color.purpleTecnology, R.color.orangeTrips};
    private int duracionTransicion = 5000;

    public void cambiarColorDeFondo(Context context) {
        final ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), ContextCompat.getColor(context, coloresResources[0]),
                ContextCompat.getColor(context, coloresResources[1]),
                ContextCompat.getColor(context, coloresResources[2]),
                ContextCompat.getColor(context, coloresResources[3]),
                ContextCompat.getColor(context, coloresResources[4]));

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

    public static int generarNumeroAleatorio() {
        if (GameMode.categoria == -2) {

            Random random = new Random();
            int randomNumber = random.nextInt(5);
            return randomNumber;
        }
        else {
            int number = GameMode.indexSpinner;
            return number;
        }
    }
}
