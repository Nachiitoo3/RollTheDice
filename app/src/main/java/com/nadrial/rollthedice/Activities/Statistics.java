package com.nadrial.rollthedice.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.nadrial.rollthedice.R;
import com.nadrial.rollthedice.Navigator;

public class Statistics extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statisticsview);

        Button mainButton = findViewById(R.id.mainButtonResultsView);
        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigator.openActivity(Statistics.this, MainMenu.class);
            }
        });
    }
}
