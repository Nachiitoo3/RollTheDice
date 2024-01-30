package com.example.rollthedice.View;

import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.rollthedice.Entities.Counter;
import com.example.rollthedice.Entities.Question;
import com.example.rollthedice.Interactor.QuestionInteractor;
import com.example.rollthedice.Presenter.QuestionPresenter;
import com.example.rollthedice.R;
import com.example.rollthedice.Router.Router;

import java.util.Collections;
import java.util.List;

public class QuestionView extends QuestionPresenter {

    Context context = this;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questionview);
        int category = getCategoria();
        setColors(category);
        setQuestion(category);
        timer(context);
        Button answer1 = findViewById(R.id.answer1ButtonQuestionView);
        Button answer2 = findViewById(R.id.answer2ButtonQuestionView);
        Button answer3 = findViewById(R.id.answer3ButtonQuestionView);
        Button answer4 = findViewById(R.id.answer4ButtonQuestionView);
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



}
