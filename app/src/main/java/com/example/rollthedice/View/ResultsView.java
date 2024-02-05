package com.example.rollthedice.View;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.rollthedice.Entities.Counter;
import com.example.rollthedice.Entities.GameMode;
import com.example.rollthedice.Presenter.ResultsPresenter;
import com.example.rollthedice.R;
import com.example.rollthedice.Router.Router;

public class ResultsView extends ResultsPresenter {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultsview);

        setNumbers();
        Button mainButton = findViewById(R.id.mainButtonResultsView);
        Button retryButton = findViewById(R.id.retryButtonResultsView);
        setProgressBar();



        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Counter.reset();
                GameMode.setDuration(20000);
                GameMode.setCategoria(-2);
                Router.openActivity(ResultsView.this, MainView.class);
                ;
            }
        });
        retryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Counter.reset();
                Router.openActivity(ResultsView.this, DiceView.class);
            }
        });


    }
}
