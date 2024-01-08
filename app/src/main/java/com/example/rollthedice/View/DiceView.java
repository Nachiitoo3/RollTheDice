package com.example.rollthedice.View;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.rollthedice.R;
import com.example.rollthedice.Router.Router;

import android.view.View;
import android.widget.Button;

public class DiceView extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diceview);

        Button diceButton = findViewById(R.id.diceButtonDiceView);

        diceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Router.openActivity(DiceView.this, QuestionView.class);
            }
        });
    }
}


