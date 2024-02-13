package com.nadrial.rollthedice.Activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.nadrial.rollthedice.Navigator;
import com.nadrial.rollthedice.R;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Register extends AppCompatActivity {

    Button  btn_register;
    EditText Name,Email,Password,RPassword;
    FirebaseFirestore mFirestore;
    FirebaseAuth mAuth;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registerview);

        mFirestore = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();

        btn_register = findViewById(R.id.registerButtonRegisterView);
         Name = findViewById(R.id.nameRegisterView);
         Email = findViewById(R.id.emailRegisterView);
         Password = findViewById(R.id.passwordRegisterView);
         RPassword = findViewById(R.id.confirmPasswordRegisterView);

        btn_register.setOnClickListener(v -> {

            String nameUser = Name.getText().toString().trim();
            String emailUser = Email.getText().toString().trim();
            String passUser = "";
            int imgUser = R.drawable.user;
            if (RPassword.getText().toString().trim().equals(Password.getText().toString().trim())) {
                passUser = Password.getText().toString().trim();
            }
            if (nameUser.length() > 16) {
                nameUser = "";
            }

            if(nameUser.isEmpty() || emailUser.isEmpty() || passUser.isEmpty()) {
                if (nameUser.isEmpty()) {
                    Toast.makeText(Register.this, "El nombre no puede tener más de 16 caracteres", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Register.this, "Complete los datos", Toast.LENGTH_SHORT).show();

                }
            }  else {
                registerUser(nameUser,emailUser,passUser,imgUser);
            }
        });

    }

    private void registerUser(String nameUser, String emailUser, String passUser, int imgUser) {
        mAuth.createUserWithEmailAndPassword(emailUser, passUser).addOnCompleteListener(task -> {
            String id = Objects.requireNonNull(mAuth.getCurrentUser()).getUid();
            Map<String, Object> map = new HashMap<>();
            map.put("id",id);
            map.put("name",nameUser);
            map.put("email",emailUser);
            map.put("img",imgUser);
            //map.put("password",passUser);

            mFirestore.collection("user").document(id).set(map).addOnCompleteListener(task1 -> {
                finish();
                Navigator.openActivity(Register.this, Login.class);
                Toast.makeText(Register.this, "Usuario registrado con éxito", Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(e -> Toast.makeText(Register.this, "Error al guardar", Toast.LENGTH_SHORT).show());
        }).addOnFailureListener(e -> Toast.makeText(Register.this, "Error al register", Toast.LENGTH_SHORT).show());
    }
}
