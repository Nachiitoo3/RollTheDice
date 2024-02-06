package com.nadrial.rollthedice.View;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.nadrial.rollthedice.Presenter.StatisticsPresenter;
import com.nadrial.rollthedice.R;
import com.nadrial.rollthedice.Router.Router;

public class StatisticsView extends StatisticsPresenter {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statisticsview);

        Button mainButton = findViewById(R.id.mainButtonResultsView);
        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Router.openActivity(StatisticsView.this, MainView.class);
            }
        });

    }
}
