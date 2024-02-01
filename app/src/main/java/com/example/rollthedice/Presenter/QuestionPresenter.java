package com.example.rollthedice.Presenter;

import static com.example.rollthedice.Entities.Counter.increment;
import static com.example.rollthedice.Entities.Counter.incrementFoodCount;
import static com.example.rollthedice.Entities.Counter.incrementMitCount;
import static com.example.rollthedice.Entities.Counter.incrementNatCount;
import static com.example.rollthedice.Entities.Counter.incrementTechCount;
import static com.example.rollthedice.Entities.Counter.incrementTripCount;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.os.CountDownTimer;
import android.os.Handler;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.rollthedice.Entities.GameMode;
import com.example.rollthedice.Entities.Question;
import com.example.rollthedice.Interactor.QuestionInteractor;
import com.example.rollthedice.R;
import com.example.rollthedice.Router.Router;
import com.example.rollthedice.View.DiceView;
import com.example.rollthedice.View.ResultsView;

import java.util.Collections;
import java.util.List;

public class QuestionPresenter extends AppCompatActivity {
    int colorBase;
    boolean cancelTimer;
    String correctAnswer, answer;
    int categoria;
    protected int getCategoria(){
        int numeroRecibido = 0;
        if (getIntent().hasExtra("categoria")) {
            numeroRecibido = getIntent().getIntExtra("categoria", -1);
            categoria = numeroRecibido;
        }
        return numeroRecibido;
    }

    protected void checkAnswer(Button buttonPressed, Context context) {
        cancelTimer = true;
        lockButtons();
        answer = "asd";
        if (buttonPressed!=null){
            answer = buttonPressed.getText().toString();
        }
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
            buttonPressed.setBackgroundColor(colorBase);

        } else {
            if (buttonPressed!=null){
            buttonPressed.setBackgroundColor(getResources().getColor(R.color.redError));}
            else {
                Button[] buttons = {findViewById(R.id.answer1ButtonQuestionView), findViewById(R.id.answer2ButtonQuestionView),
                        findViewById(R.id.answer3ButtonQuestionView), findViewById(R.id.answer4ButtonQuestionView)};
                for (Button button : buttons) {
                  button.setBackgroundColor(getResources().getColor(R.color.redError));
                    }
            }
            correctButton.setBackgroundColor(colorBase);
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (answer.equals(correctAnswer)) {
                    increment();
                    switch (categoria){
                        case 0:
                            incrementNatCount();
                            break;
                        case 1:
                            incrementMitCount();
                            break;
                        case 2:
                            incrementFoodCount();
                            break;
                        case 3:
                            incrementTripCount();
                            break;
                        case 4:
                            incrementTechCount();
                            break;

                    }
                    Router.openActivity(context, DiceView.class);
                } else {
                    Router.openActivity(context, ResultsView.class);
                }
            }
        }, 1700);

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

    public void setQuestion(int categoria) {

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




    public void setColors(int categoria) {
        ProgressBar timeBar = findViewById(R.id.timeProgressBar);
        TextView colorType = findViewById(R.id.colorTypeTextViewQuestionView);
        ImageView questionTypeIcon = findViewById(R.id.typeQuestionIconQuestionView);

        switch (categoria) {
            case 0:
                colorType.setBackgroundResource(R.color.greenNature);
                timeBar.setProgressBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.greenNatureBar2)));
                timeBar.setProgressTintList(ColorStateList.valueOf(getResources().getColor(R.color.greenNatureBar1)));
                questionTypeIcon.setImageResource(R.drawable.natureicon);
                colorBase = getColor(R.color.greenNature);
                break;
            case 1:
                colorType.setBackgroundResource(R.color.yellowMitology);
                timeBar.setProgressBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.yellowMitologyBar2)));
                timeBar.setProgressTintList(ColorStateList.valueOf(getResources().getColor(R.color.yellowMitologyBar1)));
                questionTypeIcon.setImageResource(R.drawable.mitologyicon);
                colorBase = getColor(R.color.yellowMitology);
                break;
            case 2:
                colorType.setBackgroundResource(R.color.redFood);
                timeBar.setProgressBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.redFoodBar2)));
                timeBar.setProgressTintList(ColorStateList.valueOf(getResources().getColor(R.color.redFoodBar1)));
                questionTypeIcon.setImageResource(R.drawable.foodicon);
                colorBase = getColor(R.color.redFood);
                break;
            case 3:
                colorType.setBackgroundResource(R.color.orangeTrips);
                timeBar.setProgressBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.orangeTripsBar2)));
                timeBar.setProgressTintList(ColorStateList.valueOf(getResources().getColor(R.color.orangeTripsBar1)));
                questionTypeIcon.setImageResource(R.drawable.tripsicon);
                colorBase = getColor(R.color.orangeTrips);
                break;
            case 4:
                colorType.setBackgroundResource(R.color.purpleTecnology);
                timeBar.setProgressBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.purpleTecnologyBar2)));
                timeBar.setProgressTintList(ColorStateList.valueOf(getResources().getColor(R.color.purpleTecnologyBar1)));
                questionTypeIcon.setImageResource(R.drawable.techicon);
                colorBase = getColor(R.color.purpleTecnology);
                break;

        }
    }
    public void timer (Context context){
        cancelTimer = false;
        ProgressBar progressBar = findViewById(R.id.timeProgressBar);


        long TIMER_DURATION = GameMode.duration;
        long INTERVAL = 5;

        if (TIMER_DURATION == 20000){
            progressBar.setMax(4000);
        } else {
            progressBar.setMax(2000);
        }


            new CountDownTimer(TIMER_DURATION, INTERVAL) {


                @Override
                public void onTick(long millisUntilFinished) {

                    int progress = (int) ((TIMER_DURATION - millisUntilFinished) / INTERVAL);
                    progressBar.setProgress(progress);
                    if (cancelTimer){
                        cancel();
                        cancelTimer = false;
                    }

                }

                @Override
                public void onFinish() {
                  checkAnswer(null, context);
                }
            }.start();
        }


}
