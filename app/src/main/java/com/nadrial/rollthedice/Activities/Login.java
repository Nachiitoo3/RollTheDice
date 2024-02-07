package com.nadrial.rollthedice.Activities;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.nadrial.rollthedice.R;
import com.nadrial.rollthedice.Navigator;

public class Login extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginview);

        Button loginButton = findViewById(R.id.loginButtonLoginView);
        TextView registerText = findViewById(R.id.signupTextLoginView);

        setSignUpColor();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigator.openActivity(Login.this, MainMenu.class);
                finish();
            }
        });
        registerText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigator.openActivity(Login.this, Register.class);
            }
        });
    }

    public void setSignUpColor() {
        TextView textView = findViewById(R.id.signupTextLoginView);
        String fullText = "DON'T HAVE AN ACCOUNT? SIGN UP";
        SpannableString spannableString = new SpannableString(fullText);
        int startIndex = fullText.indexOf("SIGN UP");
        spannableString.setSpan(new ForegroundColorSpan(Color.MAGENTA), startIndex, startIndex + "SIGN UP".length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(spannableString);
    }


}
