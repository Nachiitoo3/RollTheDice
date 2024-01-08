package com.example.rollthedice.View;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import com.example.rollthedice.R;

public class QuestionView extends AppCompatActivity {



    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questionview);
        int numeroRecibido = 0;
        if (getIntent().hasExtra("categoria")) {
            numeroRecibido = getIntent().getIntExtra("categoria", -1);
        }
        TextView questionText = findViewById(R.id.questionTextViewQuestionView);
        ImageView questionImage = findViewById(R.id.questionImageQuestionView);
        Button answer1 = findViewById(R.id.answer1ButtonQuestionView);
        Button answer2 = findViewById(R.id.answer2ButtonQuestionView);
        Button answer3 = findViewById(R.id.answer3ButtonQuestionView);
        Button answer4 = findViewById(R.id.answer4ButtonQuestionView);
        setColors(numeroRecibido);

    }

    public void setColors(int categoria){

        TextView colorType = findViewById(R.id.colorTypeTextViewQuestionView);
        TextView colorBar1 = findViewById(R.id.color1BarQuestionView);
        TextView colorBar2 = findViewById(R.id.color2BarQuestionView);
        ImageView questionTypeIcon = findViewById(R.id.typeQuestionIconQuestionView);

        switch (categoria) {
            case 0:
                colorType.setBackgroundResource(R.color.greenNature);
                colorBar1.setBackgroundResource(R.color.greenNatureBar1);
                colorBar2.setBackgroundResource(R.color.greenNatureBar2);
                getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.greenNature2));
                questionTypeIcon.setImageResource(R.drawable.natureicon);
                break;
            case 1:
                colorType.setBackgroundResource(R.color.yellowMitology);
                colorBar1.setBackgroundResource(R.color.yellowMitologyBar1);
                colorBar2.setBackgroundResource(R.color.yellowMitologyBar2);
                getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.yellowMitology2));
                questionTypeIcon.setImageResource(R.drawable.mitologyicon);
                break;
            case 2:
                colorType.setBackgroundResource(R.color.redFood);
                colorBar1.setBackgroundResource(R.color.redFoodBar1);
                colorBar2.setBackgroundResource(R.color.redFoodBar2);
                getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.redFood2));
                questionTypeIcon.setImageResource(R.drawable.foodicon);
                break;
            case 3:
                colorType.setBackgroundResource(R.color.orangeTrips);
                colorBar1.setBackgroundResource(R.color.orangeTripsBar1);
                colorBar2.setBackgroundResource(R.color.orangeTripsBar2);
                getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.orangeTrips2));
                questionTypeIcon.setImageResource(R.drawable.tripsicon);
                break;
            case 4:
                colorType.setBackgroundResource(R.color.purpleTecnology);
                colorBar1.setBackgroundResource(R.color.purpleTecnologyBar1);
                colorBar2.setBackgroundResource(R.color.purpleTecnologyBar2);
                getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.purpleTecnology2));
                questionTypeIcon.setImageResource(R.drawable.techicon);
                break;

        }
    }
}
