package com.nadrial.rollthedice.Activities;

import android.content.Context;

import android.os.Bundle;
import android.os.Handler;

import android.widget.ImageView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import com.nadrial.rollthedice.Entities.GameMode;
import com.nadrial.rollthedice.R;
import com.nadrial.rollthedice.Navigator;


public class TransitionDiceIntoQuestion extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transitionview);
        setScreen();
        transition(this, Question.class);

    }
    public void setScreen() {

        TextView categoryText = findViewById(R.id.textViewTransitionView);
        ImageView categoryIcon = findViewById(R.id.imageViewTransitionView);

        switch (GameMode.getCategory()) {
            case 0:
                categoryText.setText("Naturaleza");
                getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.greenNature));
                categoryIcon.setImageResource(R.drawable.natureicon);
                break;
            case 1:
                categoryText.setText("Mitología");
                getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.yellowMitology));
                categoryIcon.setImageResource(R.drawable.mitologyicon);
                break;
            case 2:
                categoryText.setText("Gastronomía");
                getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.redFood));
                categoryIcon.setImageResource(R.drawable.foodicon);
                break;
            case 3:
                categoryText.setText("Viajes y Cultura");
                getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.orangeTrips));
                categoryIcon.setImageResource(R.drawable.tripsicon);
                break;
            case 4:
                categoryText.setText("Tecnología");
                getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.purpleTecnology));
                categoryIcon.setImageResource(R.drawable.techicon);
                break;

        }
    }

    public static void transition(Context context, Class<?> cls) {

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Navigator.openActivity(context, Question.class);
            }
        }, 500);


    }



}