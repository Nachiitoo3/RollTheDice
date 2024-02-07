package com.nadrial.rollthedice.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.nadrial.rollthedice.Entities.Counter;
import com.nadrial.rollthedice.Entities.GameMode;
import com.nadrial.rollthedice.R;
import com.nadrial.rollthedice.Navigator;

public class Results extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultsview);

        Button mainButton = findViewById(R.id.mainButtonResultsView);
        Button retryButton = findViewById(R.id.retryButtonResultsView);

        setNumbers();
        setProgressBar();

        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Counter.reset();
                GameMode.setDuration(20000);
                GameMode.setMode(0);
                Navigator.openActivity(Results.this, MainMenu.class);
            }
        });
        retryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Counter.reset();
                Navigator.openActivity(Results.this, Dice.class);
            }
        });
    }

    protected void setNumbers() {
        TextView resultsText = findViewById(R.id.resultTextResultsView);
        TextView maxNumber = findViewById(R.id.topNumberYResultsView);
        maxNumber.setText(String.valueOf(Counter.getCount() + 1));
        resultsText.setText(String.valueOf(Counter.getCount()));
    }

    protected void setProgressBar() {

        ProgressBar mitProgressBar = findViewById(R.id.mitProgressBarResultsView);
        ProgressBar natProgressBar = findViewById(R.id.natProgressBarResultsView);
        ProgressBar foodProgressBar = findViewById(R.id.foodProgressBarResultsView);
        ProgressBar tripProgressBar = findViewById(R.id.tripsProgressBarResultsView);
        ProgressBar techProgressBar = findViewById(R.id.techProgressBarResultsView);

        mitProgressBar.setMax(Counter.getCount() + 1);
        natProgressBar.setMax(Counter.getCount() + 1);
        foodProgressBar.setMax(Counter.getCount() + 1);
        tripProgressBar.setMax(Counter.getCount() + 1);
        techProgressBar.setMax(Counter.getCount() + 1);

        mitProgressBar.setProgress(Counter.getMitCount());
        natProgressBar.setProgress(Counter.getNatCount());
        foodProgressBar.setProgress(Counter.getFoodCount());
        tripProgressBar.setProgress(Counter.getTripCount());
        techProgressBar.setProgress(Counter.getTechCount());
    }
}
