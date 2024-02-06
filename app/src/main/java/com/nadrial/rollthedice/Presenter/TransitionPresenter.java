package com.nadrial.rollthedice.Presenter;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.nadrial.rollthedice.R;
import com.nadrial.rollthedice.View.QuestionView;


public class TransitionPresenter extends AppCompatActivity {

    int numberReceived = 0;

    public void setScreen(int categoria) {


        TextView categoryText = findViewById(R.id.textViewTransitionView);
        ImageView categoryIcon = findViewById(R.id.imageViewTransitionView);

        switch (categoria) {
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

    protected int getNumber() {
        if (getIntent().hasExtra("categoria")) {
            numberReceived = getIntent().getIntExtra("categoria", -1);
        }
        return numberReceived;
    }

    protected void transition(Context context) {

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(context, QuestionView.class);
                intent.putExtra("categoria", numberReceived);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);

            }
        }, 1000);


    }

}