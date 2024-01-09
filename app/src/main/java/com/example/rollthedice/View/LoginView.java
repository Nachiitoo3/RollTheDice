package com.example.rollthedice.View;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.rollthedice.Presenter.LoginPresenter;
import com.example.rollthedice.R;
import com.example.rollthedice.NavigatorController.NavigatorController;


public class LoginView extends AppCompatActivity {

    public LoginPresenter presenter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginview);

        Button loginButton = findViewById(R.id.loginButtonLoginView);
        Button registerButton = findViewById(R.id.registerButtonLoginView);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavigatorController.openActivity(LoginView.this, MainView.class);
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavigatorController.openActivity(LoginView.this, RegisterView.class);
            }
        });

    }
}
