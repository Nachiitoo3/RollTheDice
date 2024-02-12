package com.nadrial.rollthedice.Activities;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.nadrial.rollthedice.Navigator;
import com.nadrial.rollthedice.R;

public class Login extends AppCompatActivity {

    EditText email,password;
    FirebaseAuth mAuth;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginview);
        mAuth = FirebaseAuth.getInstance();

        Button loginButton = findViewById(R.id.loginButtonLoginView);
        TextView registerText = findViewById(R.id.signupTextLoginView);
        email = findViewById(R.id.emailLoginView);
        password = findViewById(R.id.passwordLoginView);

        setSignUpColor();

        loginButton.setOnClickListener(view -> {


            String emailUser = email.getText().toString().trim();
            String passUser = password.getText().toString().trim();

            if (emailUser.isEmpty() || passUser.isEmpty()){
                Toast.makeText(Login.this, "Ingrese los datos", Toast.LENGTH_SHORT).show();
            }else{
                loginUser(emailUser,passUser);
            }

        });
        registerText.setOnClickListener(view -> Navigator.openActivity(Login.this, Register.class));
    }

    private void loginUser(String emailUser, String passUser) {

        mAuth.signInWithEmailAndPassword(emailUser,passUser).addOnCompleteListener(task -> {
            if (task.isSuccessful()){
                setUser();
                finish();
                Navigator.openActivity(Login.this, MainMenu.class);
            }
        }).addOnFailureListener(e -> Toast.makeText(Login.this, "Error al iniciar sesión", Toast.LENGTH_SHORT).show());

    }

    public void setSignUpColor() {
        TextView textView = findViewById(R.id.signupTextLoginView);
        String fullText = "DON'T HAVE AN ACCOUNT? SIGN UP";
        SpannableString spannableString = new SpannableString(fullText);
        int startIndex = fullText.indexOf("SIGN UP");
        spannableString.setSpan(new ForegroundColorSpan(Color.MAGENTA), startIndex, startIndex + "SIGN UP".length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(spannableString);
    }

    public void setUser() {

    }
}
