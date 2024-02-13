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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.nadrial.rollthedice.Entities.Category;
import com.nadrial.rollthedice.Entities.GameMode;
import com.nadrial.rollthedice.Navigator;
import com.nadrial.rollthedice.QuestionInteractor;
import com.nadrial.rollthedice.R;

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
        answer1.setOnClickListener(v -> checkAnswer(answer1, context));
        answer2.setOnClickListener(v -> checkAnswer(answer2, context));
        answer3.setOnClickListener(v -> checkAnswer(answer3, context));
        answer4.setOnClickListener(v -> checkAnswer(answer4, context));
    }
    boolean cancelTimer;
    String correctAnswer, answer;

    public void setColors() {
        ProgressBar timeBar = findViewById(R.id.timeProgressBar);
        TextView colorType = findViewById(R.id.colorTypeTextViewQuestionView);
        ImageView questionTypeIcon = findViewById(R.id.typeQuestionIconQuestionView);

        colorType.setBackgroundColor(Category.getCategoryMainColor());
        timeBar.setProgressBackgroundTintList(ColorStateList.valueOf(Category.getCategoryBarColor2()));
        timeBar.setProgressTintList(ColorStateList.valueOf(Category.getCategoryBarColor1()));
        questionTypeIcon.setImageResource(Category.getCategoryIcon());
    }

    public void setQuestion() {

        TextView questionText = findViewById(R.id.questionTextViewQuestionView);
        ImageView questionImage = findViewById(R.id.questionImageQuestionView);
        Button answer1 = findViewById(R.id.answer1ButtonQuestionView);
        Button answer2 = findViewById(R.id.answer2ButtonQuestionView);
        Button answer3 = findViewById(R.id.answer3ButtonQuestionView);
        Button answer4 = findViewById(R.id.answer4ButtonQuestionView);

        QuestionInteractor questionReader = new QuestionInteractor();
        com.nadrial.rollthedice.Entities.Question randomQuestion = questionReader.getRandomQuestion(this, Category.getCategoryJSON());

        if (randomQuestion != null) {
            String question = randomQuestion.getQuestion();
            String questionCorrectAnswer = randomQuestion.getCorrectAnswer();
            Glide.with(context)
                    .load(randomQuestion.getImg())
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(questionImage);
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
            assert buttonPressed != null;
            buttonPressed.setBackgroundColor(Category.getCategoryMainColor());
        } else {
            if (buttonPressed != null) {
                buttonPressed.setBackgroundColor(ContextCompat.getColor(this,R.color.redError));
            } else {
                Button[] buttons = {findViewById(R.id.answer1ButtonQuestionView), findViewById(R.id.answer2ButtonQuestionView),
                        findViewById(R.id.answer3ButtonQuestionView), findViewById(R.id.answer4ButtonQuestionView)};
                for (Button button : buttons) {
                    button.setBackgroundColor(ContextCompat.getColor(this,R.color.redError));
                }
            }
            assert correctButton != null;
            correctButton.setBackgroundColor(Category.categoryMainColor);
        }

        new Handler().postDelayed(() -> {
            if (answer.equals(correctAnswer)) {
                increment();
                switch (Category.getCategory()) {
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
                finish();
            } else {
                Navigator.openActivity(context, Results.class);
                finish();
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
