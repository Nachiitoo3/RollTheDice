package com.nadrial.rollthedice.Activities;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.nadrial.rollthedice.Entities.Category;
import com.nadrial.rollthedice.R;
import com.nadrial.rollthedice.Navigator;


public class TransitionDiceIntoQuestion extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transitionview);
        setCategoryValues();
        setScreen();
        transition(this, Question.class);
    }

    public void setScreen() {

        TextView categoryText = findViewById(R.id.textViewTransitionView);
        ImageView categoryIcon = findViewById(R.id.imageViewTransitionView);

        categoryText.setText(Category.getCategoryName());
        getWindow().getDecorView().setBackgroundColor(Category.getCategoryMainColor());
        categoryIcon.setImageResource(Category.getCategoryIcon());
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

    public void setCategoryValues() {
        int categoria = Category.getCategory();
        if (categoria == 0) {
            Category.setCategoryName("Naturaleza");
            Category.setCategoryIcon(R.drawable.natureicon);
            Category.setCategoryMainColor(getResources().getColor(R.color.greenNature));
            Category.setCategoryBarColor1(getResources().getColor(R.color.greenNatureBar1));
            Category.setCategoryBarColor2(getResources().getColor(R.color.greenNatureBar2));
            Category.setCategoryJSON("naturaleza");
        } else if (categoria == 1) {
            Category.setCategoryName("Mitología");
            Category.setCategoryIcon(R.drawable.mitologyicon);
            Category.setCategoryMainColor(getResources().getColor(R.color.yellowMitology));
            Category.setCategoryBarColor1(getResources().getColor(R.color.yellowMitologyBar1));
            Category.setCategoryBarColor2(getResources().getColor(R.color.yellowMitologyBar2));
            Category.setCategoryJSON("mitologia");
        } else if (categoria == 2) {
            Category.setCategoryName("Gastronomía");
            Category.setCategoryIcon(R.drawable.foodicon);
            Category.setCategoryMainColor(getResources().getColor(R.color.redFood));
            Category.setCategoryBarColor1(getResources().getColor(R.color.redFoodBar1));
            Category.setCategoryBarColor2(getResources().getColor(R.color.redFoodBar2));
            Category.setCategoryJSON("gastronomia");
        } else if (categoria == 3) {
            Category.setCategoryName("Viajes y Cultura");
            Category.setCategoryIcon(R.drawable.tripsicon);
            Category.setCategoryMainColor(getResources().getColor(R.color.orangeTrips));
            Category.setCategoryBarColor1(getResources().getColor(R.color.orangeTripsBar1));
            Category.setCategoryBarColor2(getResources().getColor(R.color.orangeTripsBar2));
            Category.setCategoryJSON("viajes");
        } else if (categoria == 4) {
            Category.setCategoryName("Tecnología");
            Category.setCategoryIcon(R.drawable.techicon);
            Category.setCategoryMainColor(getResources().getColor(R.color.purpleTecnology));
            Category.setCategoryBarColor1(getResources().getColor(R.color.purpleTecnologyBar1));
            Category.setCategoryBarColor2(getResources().getColor(R.color.purpleTecnologyBar2));
            Category.setCategoryJSON("tecnologia");
        }
    }
}
