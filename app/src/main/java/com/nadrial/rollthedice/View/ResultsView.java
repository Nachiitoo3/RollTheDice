package com.nadrial.rollthedice.View;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.nadrial.rollthedice.Entities.Counter;
import com.nadrial.rollthedice.Presenter.MainPresenter;
import com.nadrial.rollthedice.Presenter.ResultsPresenter;
import com.nadrial.rollthedice.R;
import com.nadrial.rollthedice.Router.Router;

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
                Router.openActivity(ResultsView.this, MainView.class);
                MainPresenter.setClasicGame();
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
