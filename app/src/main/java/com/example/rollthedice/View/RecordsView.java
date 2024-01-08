package com.example.rollthedice.View;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.rollthedice.R;
import com.example.rollthedice.Router.Router;

public class RecordsView extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recordsview);

        Button mainButton = findViewById(R.id.mainButtonRecordsView);

        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Router.openActivity(RecordsView.this, MainView.class);
            }
        });


    }
}
