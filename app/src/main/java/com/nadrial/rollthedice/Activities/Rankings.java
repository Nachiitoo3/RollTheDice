package com.nadrial.rollthedice.Activities;


import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.nadrial.rollthedice.Navigator;
import com.nadrial.rollthedice.R;


public class Rankings extends AppCompatActivity {

    boolean speedSelected = false, classicSelected = false, just1Selected = false;
    Context context = this;
    TextView rankingName;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rankingsview);

        ImageButton backToMenuButton = findViewById(R.id.backButtonRankings);
        Button speedRankingModeButton = findViewById(R.id.speedRankingModeRankings);
        TextView speedRankingLabel = findViewById(R.id.speedRankingLabelRankings);
        ImageButton speedImage = findViewById(R.id.speedImageRankings);
        Button classicRankingModeButton = findViewById(R.id.classicRankingModeRankings);
        TextView classicRankingLabel = findViewById(R.id.classicRankingLabelRankings);
        ImageButton classicImage = findViewById(R.id.classicImageRankings);
        Button just1RankingModeButton = findViewById(R.id.just1ModeRanking);
        TextView just1RankingLabel = findViewById(R.id.just1RankingLabelRankings);
        ImageButton just1Image = findViewById(R.id.just1ImageRankings);
        rankingName = findViewById(R.id.rankingModeLabelRankings);

        selectRankingMode(classicRankingModeButton, classicRankingLabel, classicImage);
        classicSelected = true;


        speedImage.setOnClickListener(v -> {
            if (!speedSelected){
                selectRankingMode(speedRankingModeButton, speedRankingLabel, speedImage);
                speedSelected = true;
            }
            if(classicSelected){
                deselectRankingMode(classicRankingModeButton, classicRankingLabel, classicImage);
                classicSelected = false;
            }
            if(just1Selected){
                deselectRankingMode(just1RankingModeButton, just1RankingLabel, just1Image);
                just1Selected = false;
            }
        });
        classicImage.setOnClickListener(v -> {
            if (!classicSelected){
                selectRankingMode(classicRankingModeButton, classicRankingLabel, classicImage);
                classicSelected = true;
            }
            if(speedSelected){
                deselectRankingMode(speedRankingModeButton, speedRankingLabel, speedImage);
                speedSelected = false;
            }
            if(just1Selected){
                deselectRankingMode(just1RankingModeButton, just1RankingLabel, just1Image);
                just1Selected = false;
            }
        });
        just1Image.setOnClickListener(v -> {
            if (!just1Selected){
                selectRankingMode(just1RankingModeButton, just1RankingLabel, just1Image);
                just1Selected = true;
            }
            if(classicSelected){
                deselectRankingMode(classicRankingModeButton, classicRankingLabel, classicImage);
                classicSelected = false;
            }
            if(speedSelected){
                deselectRankingMode(speedRankingModeButton, speedRankingLabel, speedImage);
                speedSelected = false;
            }
        });
        backToMenuButton.setOnClickListener(v -> {
            Navigator.openActivity(Rankings.this, MainMenu.class);
            finish();
        });
    }


    public void selectRankingMode(Button button, TextView textView, ImageView imageView){
        ObjectAnimator animation1 = ObjectAnimator.ofFloat(button, "translationY", -120f);
        ObjectAnimator animation2 = ObjectAnimator.ofFloat(textView, "translationY", -120f);
        ObjectAnimator animation3 = ObjectAnimator.ofFloat(imageView, "translationY", -120f);
        imageView.setColorFilter(ContextCompat.getColor(context, R.color.black));
        textView.setTextColor(ContextCompat.getColor(context, R.color.black));
        rankingName.setText(textView.getText());

        animation1.setDuration(100);
        animation1.start();
        animation2.setDuration(100);
        animation2.start();
        animation3.setDuration(100);
        animation3.start();

    }

    public void deselectRankingMode (Button button, TextView textView, ImageView imageView){
        ObjectAnimator animation1 = ObjectAnimator.ofFloat(button, "translationY", 0f);
        ObjectAnimator animation2 = ObjectAnimator.ofFloat(textView, "translationY", 0f);
        ObjectAnimator animation3 = ObjectAnimator.ofFloat(imageView, "translationY", 0f);
        imageView.setColorFilter(ContextCompat.getColor(context, R.color.completed));
        textView.setTextColor(ContextCompat.getColor(context, R.color.completed));

        animation1.setDuration(100);
        animation1.start();
        animation2.setDuration(100);
        animation2.start();
        animation3.setDuration(100);
        animation3.start();

    }


}
