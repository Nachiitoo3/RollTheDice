package com.example.rollthedice.View;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.rollthedice.Presenter.RegisterPresenter;
import com.example.rollthedice.R;
import com.example.rollthedice.NavigatorController.NavigatorController;

public class RegisterView extends RegisterPresenter {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registerview);

        Button registerButton = findViewById(R.id.registerButtonRegisterView);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavigatorController.openActivity(RegisterView.this, LoginView.class);
            }
        });

    }
}
