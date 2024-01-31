package com.example.rollthedice.Presenter;

import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.rollthedice.Entities.Counter;
import com.example.rollthedice.R;

public class ResultsPresenter extends AppCompatActivity {

    protected void setNumbers(){
        TextView resultsText = findViewById(R.id.resultTextResultsView);
        TextView maxNumber = findViewById(R.id.topNumberYResultsView);
        TextView halfNumber = findViewById(R.id.halfCounterResultsView);
        maxNumber.setText(String.valueOf(Counter.getCount()+1));
        halfNumber.setText(String.valueOf((Counter.getCount()+1)/2));
        resultsText.setText(String.valueOf(Counter.getCount()));
    }

    protected void setProgressBar(){

        ProgressBar mitProgressBar = findViewById(R.id.mitProgressBarResultsView);
        ProgressBar natProgressBar = findViewById(R.id.natProgressBarResultsView);
        ProgressBar foodProgressBar = findViewById(R.id.foodProgressBarResultsView);
        ProgressBar tripProgressBar = findViewById(R.id.tripsProgressBarResultsView);
        ProgressBar techProgressBar = findViewById(R.id.techProgressBarResultsView);

        mitProgressBar.setMax(Counter.getCount()+1);
        natProgressBar.setMax(Counter.getCount()+1);
        foodProgressBar.setMax(Counter.getCount()+1);
        tripProgressBar.setMax(Counter.getCount()+1);
        techProgressBar.setMax(Counter.getCount()+1);

        mitProgressBar.setProgress(Counter.getMitCount());
        natProgressBar.setProgress(Counter.getNatCount());
        foodProgressBar.setProgress(Counter.getFoodCount());
        tripProgressBar.setProgress(Counter.getTripCount());
        techProgressBar.setProgress(Counter.getTechCount());



    }

}
