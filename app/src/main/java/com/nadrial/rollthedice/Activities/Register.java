package com.nadrial.rollthedice.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Firebase;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.nadrial.rollthedice.R;
import com.nadrial.rollthedice.Navigator;

import java.util.HashMap;
import java.util.Map;

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

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nameUser = Name.getText().toString().trim();
                String emailUser = Email.getText().toString().trim();
                String passUser = Password.getText().toString().trim();

                if(nameUser.isEmpty() && emailUser.isEmpty() && passUser.isEmpty()){
                    Toast.makeText(Register.this, "Complete los datos", Toast.LENGTH_SHORT).show();

                }else {
                    registerUser(nameUser,emailUser,passUser);
                }
            }
        });

    }

    private void registerUser(String nameUser, String emailUser, String passUser) {
        mAuth.createUserWithEmailAndPassword(emailUser, passUser).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                String id = mAuth.getCurrentUser().getUid();
                Map<String, Object> map = new HashMap<>();
                map.put("id",id);
                map.put("name",nameUser);
                map.put("email",emailUser);
                map.put("password",passUser);

                mFirestore.collection("user").document(id).set(map).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        finish();
                        Navigator.openActivity(Register.this, Login.class);
                        Toast.makeText(Register.this, "Usuario registrado con éxito", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Register.this, "Error al guardar", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Register.this, "Error al register", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
