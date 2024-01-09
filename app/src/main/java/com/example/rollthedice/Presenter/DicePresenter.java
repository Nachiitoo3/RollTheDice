package com.example.rollthedice.Presenter;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;

import androidx.core.content.ContextCompat;

import com.example.rollthedice.Model.ColorsResources;

import java.util.Random;

public class DicePresenter {

    public static ValueAnimator setValueAnimator(Context context, int[] coloresResources) {
        final ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(),
                ContextCompat.getColor(context, coloresResources[0]),
                ContextCompat.getColor(context, coloresResources[1]),
                ContextCompat.getColor(context, coloresResources[2]),
                ContextCompat.getColor(context, coloresResources[3]),
                ContextCompat.getColor(context, coloresResources[4]));
        return colorAnimation;
    }
    public static ValueAnimator setAnimation(Context context){
        int[] coloresResources = ColorsResources.getColorsResources();
        ValueAnimator colorAnimation= DicePresenter.setValueAnimator(context, coloresResources);
        colorAnimation.setDuration(5000);
        colorAnimation.setRepeatCount(ValueAnimator.INFINITE);
        colorAnimation.setRepeatMode(ValueAnimator.REVERSE);
        return colorAnimation;
    }

    public static int generarNumeroAleatorio() {
        Random random = new Random();
        int randomNumber = random.nextInt(5);
        return randomNumber;

    }
}
