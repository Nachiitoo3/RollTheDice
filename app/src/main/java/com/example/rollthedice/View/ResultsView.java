package com.example.rollthedice.View;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.rollthedice.Model.Counter;
import com.example.rollthedice.Presenter.ResultsPresenter;
import com.example.rollthedice.R;
import com.example.rollthedice.NavigatorController.NavigatorController;

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
                NavigatorController.openActivity(ResultsView.this, MainView.class);
            }
        });
        retryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Counter.reset();
                NavigatorController.openActivity(ResultsView.this, DiceView.class);
            }
        });


    }
}
