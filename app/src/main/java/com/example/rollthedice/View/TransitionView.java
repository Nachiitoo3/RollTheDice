package com.example.rollthedice.View;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.rollthedice.R;
import com.example.rollthedice.Router.Router;

public class TransitionView extends AppCompatActivity {

    int numeroRecibido = 0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transitionview);

        if (getIntent().hasExtra("categoria")) {
            numeroRecibido = getIntent().getIntExtra("categoria", -1);
        }
        setScreen(numeroRecibido);
        transition();

    }
    public void setScreen(int categoria){

        TextView categoryText = findViewById(R.id.textViewTransitionView);
        ImageView categoryIcon = findViewById(R.id.imageViewTransitionView);

        switch (categoria) {
            case 0:
                categoryText.setText("Naturaleza");
                getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.greenNature2));
                categoryIcon.setImageResource(R.drawable.natureicon);
                break;
            case 1:
                categoryText.setText("Mitología");
                getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.yellowMitology2));
                categoryIcon.setImageResource(R.drawable.mitologyicon);
                break;
            case 2:
                categoryText.setText("Gastronomía");
                getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.redFood2));
                categoryIcon.setImageResource(R.drawable.foodicon);
                break;
            case 3:
                categoryText.setText("Viajes y Cultura");
                getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.orangeTrips2));
                categoryIcon.setImageResource(R.drawable.tripsicon);
                break;
            case 4:
                categoryText.setText("Tecnología");
                getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.purpleTecnology2));
                categoryIcon.setImageResource(R.drawable.techicon);
                break;

        }
    }

    private void transition() {

        Handler handler = new Handler();
        handler.postDelayed(new Runnable()
        {
            @Override
            public void run() {
                Intent intent = new Intent(TransitionView
                        .this, QuestionView.class);
                intent.putExtra("categoria", numeroRecibido);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);

            }
        }, 1000);


    }

}