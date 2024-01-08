package com.example.rollthedice.View;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.rollthedice.R;
import com.example.rollthedice.Router.Router;

public class RegisterView extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registerview);

        Button registerButton = findViewById(R.id.registerButtonRegisterView);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Router.openActivity(RegisterView.this, LoginView.class);
            }
        });

    }
}
