package com.example.rollthedice.View;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.rollthedice.Entities.Question;
import com.example.rollthedice.Interactor.QuestionInteractor;
import com.example.rollthedice.R;
import com.example.rollthedice.Router.Router;

import java.util.Collections;
import java.util.List;

public class QuestionView extends AppCompatActivity {

    String correctAnswer;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questionview);
        int numeroRecibido = 0;
        if (getIntent().hasExtra("categoria")) {
            numeroRecibido = getIntent().getIntExtra("categoria", -1);
        }
        setColors(numeroRecibido);
        setQuestion(numeroRecibido);
        Button answer1 = findViewById(R.id.answer1ButtonQuestionView);
        Button answer2 = findViewById(R.id.answer2ButtonQuestionView);
        Button answer3 = findViewById(R.id.answer3ButtonQuestionView);
        Button answer4 = findViewById(R.id.answer4ButtonQuestionView);
        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(answer1);
            }
        });

        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(answer2);
            }
        });

        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(answer3);
            }
        });

        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(answer4);
            }
        });
    }



    private void checkAnswer(Button buttonPressed) {
        lockButtons();
        String answer = buttonPressed.getText().toString();
        Button correctButton = null;

        if (answer.equals(correctAnswer)) {
            correctButton = buttonPressed;
        } else {
            Button[] buttons = {findViewById(R.id.answer1ButtonQuestionView), findViewById(R.id.answer2ButtonQuestionView),
                    findViewById(R.id.answer3ButtonQuestionView), findViewById(R.id.answer4ButtonQuestionView)};

            for (Button button : buttons) {
                if (button.getText().toString().equals(correctAnswer)) {
                    correctButton = button;
                    break;
                }
            }
        }

        if (answer.equals(correctAnswer)) {
            buttonPressed.setBackgroundColor(getResources().getColor(R.color.greenCorrect));
        } else {
            buttonPressed.setBackgroundColor(getResources().getColor(R.color.redError));
            correctButton.setBackgroundColor(getResources().getColor(R.color.greenCorrect));
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (answer.equals(correctAnswer)) {
                    Router.openActivity(QuestionView.this, DiceView.class);
                } else {
                    Router.openActivity(QuestionView.this, ResultsView.class);
                }
            }
        }, 1500);

    }

    private void lockButtons() {
        Button answer1 = findViewById(R.id.answer1ButtonQuestionView);
        Button answer2 = findViewById(R.id.answer2ButtonQuestionView);
        Button answer3 = findViewById(R.id.answer3ButtonQuestionView);
        Button answer4 = findViewById(R.id.answer4ButtonQuestionView);

        answer1.setEnabled(false);
        answer2.setEnabled(false);
        answer3.setEnabled(false);
        answer4.setEnabled(false);
    }
    public void setQuestion(int categoria){

        String JSONString = null;
        TextView questionText = findViewById(R.id.questionTextViewQuestionView);
        ImageView questionImage = findViewById(R.id.questionImageQuestionView);
        Button answer1 = findViewById(R.id.answer1ButtonQuestionView);
        Button answer2 = findViewById(R.id.answer2ButtonQuestionView);
        Button answer3 = findViewById(R.id.answer3ButtonQuestionView);
        Button answer4 = findViewById(R.id.answer4ButtonQuestionView);

        switch (categoria) {
            case 0:
                JSONString = "naturaleza";
                break;
            case 1:
                JSONString = "mitologia";
                break;
            case 2:
                JSONString = "gastronomia";
                break;
            case 3:
                JSONString = "viajes";
                break;
            case 4:
                JSONString = "tecnologia";
                break;

        }
        QuestionInteractor questionReader = new QuestionInteractor();
        Question preguntaAleatoria = questionReader.getRandomQuestion(this, JSONString);

        if (preguntaAleatoria != null) {
            String pregunta = preguntaAleatoria.getQuestion();
            String respuestaCorrecta = preguntaAleatoria.getCorrectAnswer();
            List<String> opciones = preguntaAleatoria.getOptions();
            questionText.setText(pregunta);
            Collections.shuffle(opciones);
            answer1.setText(opciones.get(0));
            answer2.setText(opciones.get(1));
            answer3.setText(opciones.get(2));
            answer4.setText(opciones.get(3));
            correctAnswer = respuestaCorrecta;

        }

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
