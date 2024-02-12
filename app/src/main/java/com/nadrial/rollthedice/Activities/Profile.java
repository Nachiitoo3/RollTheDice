package com.nadrial.rollthedice.Activities;

import android.app.Dialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.nadrial.rollthedice.Navigator;
import com.nadrial.rollthedice.R;

public class Profile extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profileview);

        ImageButton backToMenuButton = findViewById(R.id.backButtonProfileView);
        TextView logOut = findViewById(R.id.logOutBackground);
        TextView changeProfileImage = findViewById(R.id.changeProfileImageBackground);
        TextView changeName = findViewById(R.id.changeNameBackground);

        backToMenuButton.setOnClickListener(v -> {
            Navigator.openActivity(Profile.this, MainMenu.class);
            finish();
        });

        logOut.setOnClickListener(v -> {
            Navigator.openActivity(Profile.this, Login.class);
            finish();
        });

        changeProfileImage.setOnClickListener(v -> changeProfileImage());

        changeName.setOnClickListener(v -> changeName());


    }

    public void changeName() {
        Dialog optionsDialog = new Dialog(this);
        optionsDialog.setContentView(R.layout.changenamedialog);
        optionsDialog.setTitle("Cambiar nombre");

        Button changeNameButton = optionsDialog.findViewById(R.id.changeNameButton);
        EditText nameChangedEditText = optionsDialog.findViewById(R.id.changeNameEditText);

        changeNameButton.setOnClickListener(v -> {
            String newName = nameChangedEditText.getText().toString().trim();

            if (newName.length() > 16) {
                Toast.makeText(this, "El nombre no puede tener más de 16 caracteres", Toast.LENGTH_SHORT).show();
                return;
            }

            TextView nameText = findViewById(R.id.profileNameProfileView);
            nameText.setText(newName);
            optionsDialog.dismiss();
        });

        optionsDialog.show();
    }

    public void changeProfileImage() {

        Dialog profileImages = new Dialog(this);
        profileImages.setContentView(R.layout.changeavatardialog);
        profileImages.setTitle("Cambiar avatar");

        Button chageImageButton = profileImages.findViewById(R.id.confirmChangeImageButton);

        chageImageButton.setOnClickListener(v -> profileImages.dismiss());


        profileImages.show();
    }



}
