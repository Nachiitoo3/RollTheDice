package com.example.rollthedice.View;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.rollthedice.R;
import com.example.rollthedice.Router.Router;

public class LoginView extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginview);

        Button loginButton = findViewById(R.id.loginButtonLoginView);
        TextView registerText = findViewById(R.id.signupTextLoginView);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Router.openActivity(LoginView.this, MainView.class);
            }
        });

        registerText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Router.openActivity(LoginView.this, RegisterView.class);
            }
        });


    }
}
