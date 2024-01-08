package com.example.rollthedice.View;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.rollthedice.R;
import com.example.rollthedice.Router.Router;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class DiceView extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diceview);

        Button diceButton = findViewById(R.id.diceButtonDiceView);

        diceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int randomInt = generarNumeroAleatorio();
                Router.openQuestion(DiceView.this, TransitionView.class, randomInt);


            }
        });
    }
    public int generarNumeroAleatorio() {
        Random random = new Random();
        int randomNumber = random.nextInt(5);
        return randomNumber;

    }
}


