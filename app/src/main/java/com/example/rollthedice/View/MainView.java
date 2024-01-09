package com.example.rollthedice.View;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.rollthedice.Presenter.MainPresenter;
import com.example.rollthedice.R;
import com.example.rollthedice.NavigatorController.NavigatorController;

public class MainView extends MainPresenter {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainview);

        Button playButton = findViewById(R.id.playButtonMainView);
        Button recordsButton = findViewById(R.id.recordsButtonMainView);
        Button statisticsButton = findViewById(R.id.statisticsButtonMainView);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavigatorController.openActivity(MainView.this, DiceView.class);
            }
        });

        recordsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavigatorController.openActivity(MainView.this, RecordsView.class);
            }
        });

        statisticsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavigatorController.openActivity(MainView.this, StatisticsView.class);
            }
        });
    }
}
