package com.nadrial.rollthedice.View;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.nadrial.rollthedice.Presenter.RegisterPresenter;
import com.nadrial.rollthedice.R;
import com.nadrial.rollthedice.Router.Router;

public class RegisterView extends RegisterPresenter {


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
