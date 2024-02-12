package com.nadrial.rollthedice.Activities;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.nadrial.rollthedice.R;
import com.nadrial.rollthedice.Navigator;
import com.nadrial.rollthedice.Entities.User;

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

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override


            public void onClick(View view) {


                String emailUser = email.getText().toString().trim();
                String passUser = password.getText().toString().trim();

                if (emailUser.isEmpty() || passUser.isEmpty()){
                    Toast.makeText(Login.this, "Ingrese los datos", Toast.LENGTH_SHORT).show();
                }else{
                    loginUser(emailUser,passUser);
                }

            }
        });
        registerText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigator.openActivity(Login.this, Register.class);
            }
        });
    }

    private void loginUser(String emailUser, String passUser) {

        mAuth.signInWithEmailAndPassword(emailUser,passUser).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    setUser();
                    finish();
                    Navigator.openActivity(Login.this, MainMenu.class);
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Login.this, "Error al iniciar sesión", Toast.LENGTH_SHORT).show();
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

    public void setUser(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        User.setId(user.getUid());
        DatabaseReference usersRef = FirebaseDatabase.getInstance().getReference().child("user").child(User.getId());
        DataSnapshot snapshot;
        usersRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User.setName(snapshot.child("nombre").getValue(String.class));
                User.setEmail(snapshot.child("email").getValue(String.class));
                User.setImgUser(snapshot.child("img").getValue(int.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
}
}
