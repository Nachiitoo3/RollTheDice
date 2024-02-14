package com.nadrial.rollthedice.Activities;



import android.app.Dialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.nadrial.rollthedice.Entities.User;
import com.nadrial.rollthedice.Navigator;
import com.nadrial.rollthedice.R;

import org.checkerframework.checker.nullness.qual.NonNull;

public class Profile extends AppCompatActivity {

    private ImageButton lastSelectedImageBtn;
    private static String newImg;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profileview);
        ImageButton backToMenuButton = findViewById(R.id.backButtonProfileView);
        TextView logOut = findViewById(R.id.logOutBackground);
        TextView changeProfileImage = findViewById(R.id.changeProfileImageBackground);
        TextView changeName = findViewById(R.id.changeNameBackground);
        setUpUser();

        backToMenuButton.setOnClickListener(v -> {
            Navigator.openActivity(Profile.this, MainMenu.class);
            finish();
        });

        logOut.setOnClickListener(v -> {
            FirebaseAuth.getInstance().signOut();
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
            guardarNombre(newName);
            optionsDialog.dismiss();
        });

        optionsDialog.show();
    }

    public void changeProfileImage() {

        Dialog profileImages = new Dialog(this);
        profileImages.setContentView(R.layout.changeavatardialog);
        profileImages.setTitle("Cambiar avatar");

        Button chageImageButton = profileImages.findViewById(R.id.confirmChangeImageButton);
        ImageView profileImage = findViewById(R.id.profileImageProfileView);
        ImageButton image1 = profileImages.findViewById(R.id.imageButton1);
        ImageButton image2 = profileImages.findViewById(R.id.imageButton2);
        ImageButton image3 = profileImages.findViewById(R.id.imageButton3);
        image1.setOnClickListener(v -> {

            profileImage.setImageDrawable(image1.getDrawable());

        });
        image2.setOnClickListener(v -> {

            profileImage.setImageDrawable(image2.getDrawable());

        });
        image3.setOnClickListener(v -> {

            profileImage.setImageDrawable(image3.getDrawable());

        });

        chageImageButton.setOnClickListener(v -> profileImages.dismiss());


        profileImages.show();
    }

    public void setUpUser(){
        TextView email = findViewById(R.id.gmailTextProfileView);
        ImageView img = findViewById(R.id.profileImageProfileView);
        TextView name = findViewById(R.id.profileNameProfileView);
        name.setText(User.getName());
        email.setText(User.getEmail());
        String profileImg = User.getImgUser();
        img.setImageResource(Integer.parseInt(profileImg));    }

    public void guardarNombre(String nuevoNombre){

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null){
            FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
            DocumentReference userReference = firebaseFirestore.collection("user").document(user.getUid());
            userReference.update("name",nuevoNombre);
            User.setName(nuevoNombre);
        }

    }


}
