package com.nadrial.rollthedice.Activities;


import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import com.nadrial.rollthedice.Navigator;
import com.nadrial.rollthedice.R;


public class Rankings extends AppCompatActivity {

    boolean speedSelected = false, classicSelected = false, just1Selected = false;

    TextView rankingName;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rankingsview);

        ImageButton backToMenuButton = findViewById(R.id.backButton);
        Button speedRankingModeButton = findViewById(R.id.speedRankingMode);
        TextView speedRankingLabel = findViewById(R.id.speedRankingLabel);
        ImageButton speedImage = findViewById(R.id.speedImage);
        Button classicRankingModeButton = findViewById(R.id.classicRankingMode);
        TextView classicRankingLabel = findViewById(R.id.classicRankingLabel);
        ImageButton classicImage = findViewById(R.id.classicImage);
        Button just1RankingModeButton = findViewById(R.id.just1ModeRanking);
        TextView just1RankingLabel = findViewById(R.id.just1RankingLabel);
        ImageButton just1Image = findViewById(R.id.just1Image);
        rankingName = findViewById(R.id.rankingModeLabel);

        selectRankingMode(classicRankingModeButton, classicRankingLabel, classicImage);
        classicSelected = true;


        speedImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (speedSelected == false){
                    selectRankingMode(speedRankingModeButton, speedRankingLabel, speedImage);
                    speedSelected = true;
                }
                if(classicSelected == true){
                    deselectRankingMode(classicRankingModeButton, classicRankingLabel, classicImage);
                    classicSelected = false;
                }
                if(just1Selected == true){
                    deselectRankingMode(just1RankingModeButton, just1RankingLabel, just1Image);
                    just1Selected = false;
                }
            }
        });
        classicImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (classicSelected == false){
                    selectRankingMode(classicRankingModeButton, classicRankingLabel, classicImage);
                    classicSelected = true;
                }
                if(speedSelected == true){
                    deselectRankingMode(speedRankingModeButton, speedRankingLabel, speedImage);
                    speedSelected = false;
                }
                if(just1Selected == true){
                    deselectRankingMode(just1RankingModeButton, just1RankingLabel, just1Image);
                    just1Selected = false;
                }
            }
        });
        just1Image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (just1Selected == false){
                    selectRankingMode(just1RankingModeButton, just1RankingLabel, just1Image);
                    just1Selected = true;
                }
                if(classicSelected == true){
                    deselectRankingMode(classicRankingModeButton, classicRankingLabel, classicImage);
                    classicSelected = false;
                }
                if(speedSelected == true){
                    deselectRankingMode(speedRankingModeButton, speedRankingLabel, speedImage);
                    speedSelected = false;
                }
            }
        });
        backToMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigator.openActivity(Rankings.this, MainMenu.class);
                finish();
            }
        });
    }


    public void selectRankingMode (Button button, TextView textView, ImageView imageView){
        ObjectAnimator animation1 = ObjectAnimator.ofFloat(button, "translationY", -120f);
        ObjectAnimator animation2 = ObjectAnimator.ofFloat(textView, "translationY", -120f);
        ObjectAnimator animation3 = ObjectAnimator.ofFloat(imageView, "translationY", -120f);
        rankingName.setText(textView.getText());

        animation1.setDuration(100);
        animation1.start();;
        animation2.setDuration(100);
        animation2.start();;
        animation3.setDuration(100);
        animation3.start();;

    }

    public void deselectRankingMode (Button button, TextView textView, ImageView imageView){
        ObjectAnimator animation1 = ObjectAnimator.ofFloat(button, "translationY", 0f);
        ObjectAnimator animation2 = ObjectAnimator.ofFloat(textView, "translationY", 0f);
        ObjectAnimator animation3 = ObjectAnimator.ofFloat(imageView, "translationY", 0f);

        animation1.setDuration(100);
        animation1.start();;
        animation2.setDuration(100);
        animation2.start();;
        animation3.setDuration(100);
        animation3.start();;

    }


}
