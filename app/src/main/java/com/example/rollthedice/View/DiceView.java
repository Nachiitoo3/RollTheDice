package com.example.rollthedice.View;

import android.animation.ValueAnimator;
import android.os.Bundle;

import com.example.rollthedice.Presenter.DicePresenter;
import com.example.rollthedice.R;
import com.example.rollthedice.NavigatorController.NavigatorController;

import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class DiceView extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diceview);
        Button diceButton = findViewById(R.id.diceButtonDiceView);

        ValueAnimator colorAnimation = DicePresenter.setAnimation(this);
        colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                getWindow().getDecorView().setBackgroundColor((int) animator.getAnimatedValue());
            }
        });
        colorAnimation.start();
        diceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int randomInt = DicePresenter.generarNumeroAleatorio();
                NavigatorController.openQuestion(DiceView.this, TransitionView.class, randomInt);
            }
        });
    }


}


