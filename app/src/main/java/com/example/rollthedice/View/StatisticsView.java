package com.example.rollthedice.View;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.rollthedice.Presenter.StatisticsPresenter;
import com.example.rollthedice.R;
import com.example.rollthedice.Router.Router;

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
