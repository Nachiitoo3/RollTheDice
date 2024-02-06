package com.nadrial.rollthedice.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.nadrial.rollthedice.R;
import com.nadrial.rollthedice.Navigator;

public class Register extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registerview);

        Button registerButton = findViewById(R.id.registerButtonRegisterView);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigator.openActivity(Register.this, Login.class);
            }
        });
    }
}
