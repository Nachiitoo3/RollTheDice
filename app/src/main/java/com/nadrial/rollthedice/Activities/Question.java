package com.nadrial.rollthedice.Activities;

import static com.nadrial.rollthedice.Entities.Counter.increment;
import static com.nadrial.rollthedice.Entities.Counter.incrementFoodCount;
import static com.nadrial.rollthedice.Entities.Counter.incrementMitCount;
import static com.nadrial.rollthedice.Entities.Counter.incrementNatCount;
import static com.nadrial.rollthedice.Entities.Counter.incrementTechCount;
import static com.nadrial.rollthedice.Entities.Counter.incrementTripCount;

import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.nadrial.rollthedice.Entities.GameMode;
import com.nadrial.rollthedice.QuestionInteractor;
import com.nadrial.rollthedice.R;
import com.nadrial.rollthedice.Navigator;

import java.util.Collections;
import java.util.List;

public class Question extends AppCompatActivity {

    Context context = this;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questionview);

        Button answer1 = findViewById(R.id.answer1ButtonQuestionView);
        Button answer2 = findViewById(R.id.answer2ButtonQuestionView);
        Button answer3 = findViewById(R.id.answer3ButtonQuestionView);
        Button answer4 = findViewById(R.id.answer4ButtonQuestionView);

        setColors();
        setQuestion();
        timer(context);
        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(answer1, context);
            }
        });
        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(answer2, context);
            }
        });
        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(answer3, context);
            }
        });
        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(answer4, context);
            }
        });
    }

    int mainColor;
    boolean cancelTimer;
    String correctAnswer, answer;

    public void setColors() {
        ProgressBar timeBar = findViewById(R.id.timeProgressBar);
        TextView colorType = findViewById(R.id.colorTypeTextViewQuestionView);
        ImageView questionTypeIcon = findViewById(R.id.typeQuestionIconQuestionView);

        switch (GameMode.getCategory()) {
            case 0:
                colorType.setBackgroundResource(R.color.greenNature);
                timeBar.setProgressBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.greenNatureBar2)));
                timeBar.setProgressTintList(ColorStateList.valueOf(getResources().getColor(R.color.greenNatureBar1)));
                questionTypeIcon.setImageResource(R.drawable.natureicon);
                mainColor = getColor(R.color.greenNature);
                break;
            case 1:
                colorType.setBackgroundResource(R.color.yellowMitology);
                timeBar.setProgressBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.yellowMitologyBar2)));
                timeBar.setProgressTintList(ColorStateList.valueOf(getResources().getColor(R.color.yellowMitologyBar1)));
                questionTypeIcon.setImageResource(R.drawable.mitologyicon);
                mainColor = getColor(R.color.yellowMitology);
                break;
            case 2:
                colorType.setBackgroundResource(R.color.redFood);
                timeBar.setProgressBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.redFoodBar2)));
                timeBar.setProgressTintList(ColorStateList.valueOf(getResources().getColor(R.color.redFoodBar1)));
                questionTypeIcon.setImageResource(R.drawable.foodicon);
                mainColor = getColor(R.color.redFood);
                break;
            case 3:
                colorType.setBackgroundResource(R.color.orangeTrips);
                timeBar.setProgressBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.orangeTripsBar2)));
                timeBar.setProgressTintList(ColorStateList.valueOf(getResources().getColor(R.color.orangeTripsBar1)));
                questionTypeIcon.setImageResource(R.drawable.tripsicon);
                mainColor = getColor(R.color.orangeTrips);
                break;
            case 4:
                colorType.setBackgroundResource(R.color.purpleTecnology);
                timeBar.setProgressBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.purpleTecnologyBar2)));
                timeBar.setProgressTintList(ColorStateList.valueOf(getResources().getColor(R.color.purpleTecnologyBar1)));
                questionTypeIcon.setImageResource(R.drawable.techicon);
                mainColor = getColor(R.color.purpleTecnology);
                break;
        }
    }

    public void setQuestion() {

        String JSONString = null;
        TextView questionText = findViewById(R.id.questionTextViewQuestionView);
        ImageView questionImage = findViewById(R.id.questionImageQuestionView);
        Button answer1 = findViewById(R.id.answer1ButtonQuestionView);
        Button answer2 = findViewById(R.id.answer2ButtonQuestionView);
        Button answer3 = findViewById(R.id.answer3ButtonQuestionView);
        Button answer4 = findViewById(R.id.answer4ButtonQuestionView);

        switch (GameMode.getCategory()) {
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
        com.nadrial.rollthedice.Entities.Question randomQuestion = questionReader.getRandomQuestion(this, JSONString);

        if (randomQuestion != null) {
            String question = randomQuestion.getQuestion();
            String questionCorrectAnswer = randomQuestion.getCorrectAnswer();
            List<String> opciones = randomQuestion.getOptions();
            questionText.setText(question);
            Collections.shuffle(opciones);
            answer1.setText(opciones.get(0));
            answer2.setText(opciones.get(1));
            answer3.setText(opciones.get(2));
            answer4.setText(opciones.get(3));
            correctAnswer = questionCorrectAnswer;
        }
    }

    public void timer(Context context) {
        cancelTimer = false;
        ProgressBar progressBar = findViewById(R.id.timeProgressBar);

        long TIMER_DURATION = GameMode.getDuration();
        long INTERVAL = 5;

        if (TIMER_DURATION == 20000) {
            progressBar.setMax(4000);
        } else {
            progressBar.setMax(2000);
        }
        new CountDownTimer(TIMER_DURATION, INTERVAL) {
            @Override
            public void onTick(long millisUntilFinished) {

                int progress = (int) ((TIMER_DURATION - millisUntilFinished) / INTERVAL);
                progressBar.setProgress(progress);
                if (cancelTimer) {
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

    protected void checkAnswer(Button buttonPressed, Context context) {
        cancelTimer = true;
        lockButtons();
        answer = "asd";
        if (buttonPressed != null) {
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
            buttonPressed.setBackgroundColor(mainColor);
        } else {
            if (buttonPressed != null) {
                buttonPressed.setBackgroundColor(getResources().getColor(R.color.redError));
            } else {
                Button[] buttons = {findViewById(R.id.answer1ButtonQuestionView), findViewById(R.id.answer2ButtonQuestionView),
                        findViewById(R.id.answer3ButtonQuestionView), findViewById(R.id.answer4ButtonQuestionView)};
                for (Button button : buttons) {
                    button.setBackgroundColor(getResources().getColor(R.color.redError));
                }
            }
            correctButton.setBackgroundColor(mainColor);
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (answer.equals(correctAnswer)) {
                    increment();
                    switch (GameMode.getCategory()) {
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
                    Navigator.openActivity(context, Dice.class);
                } else {
                    Navigator.openActivity(context, Results.class);
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
}
