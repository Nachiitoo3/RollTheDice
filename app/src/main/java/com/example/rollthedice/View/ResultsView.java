package com.example.rollthedice.View;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.rollthedice.Entities.Counter;
import com.example.rollthedice.R;
import com.example.rollthedice.Router.Router;

public class ResultsView extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultsview);

        TextView resultsText = findViewById(R.id.resultTextResultsView);
        Button mainButton = findViewById(R.id.mainButtonResultsView);

        String result = String.valueOf(Counter.getCount());
        resultsText.setText(result);
        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Counter.reset();
                Router.openActivity(ResultsView.this, MainView.class);
            }
        });

    }
}
