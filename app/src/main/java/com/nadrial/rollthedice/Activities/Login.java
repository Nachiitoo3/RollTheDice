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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.nadrial.rollthedice.Entities.User;
import com.nadrial.rollthedice.Navigator;
import com.nadrial.rollthedice.R;

import org.checkerframework.checker.nullness.qual.NonNull;

public class Login extends AppCompatActivity {

    EditText email, password;
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

            if (emailUser.isEmpty() || passUser.isEmpty()) {
                Toast.makeText(Login.this, "Ingrese los datos", Toast.LENGTH_SHORT).show();
            } else {
                loginUser(emailUser, passUser);
            }

        });
        registerText.setOnClickListener(view -> Navigator.openActivity(Login.this, Register.class));
    }

    private void loginUser(String emailUser, String passUser) {

        mAuth.signInWithEmailAndPassword(emailUser, passUser).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                setUser();
                Navigator.openActivity(Login.this, MainMenu.class);
                finish();
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
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        User.setId(user.getUid());
        FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
        DocumentReference userReference = firebaseFirestore.collection("user").document(User.getId());
        userReference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    if (task.isSuccessful()) {
                        DocumentSnapshot document = task.getResult();
                        if (document.exists()) {
                            User.setName(document.getString("name"));
                            User.setEmail(document.getString("email"));
                            User.setImgUser(document.getString("img"));
                        } else {

                        }
                    } else {
                        // Manejar errores de lectura de Firestore si es necesario
                        Exception exception = task.getException();
                    }
                }
            });
        }
    }




