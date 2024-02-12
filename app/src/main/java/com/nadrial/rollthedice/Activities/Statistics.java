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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nadrial.rollthedice.ItemAchievement;
import com.nadrial.rollthedice.ItemAdapterAchievement;
import com.nadrial.rollthedice.ItemAdapterStats;
import com.nadrial.rollthedice.ItemStat;
import com.nadrial.rollthedice.Navigator;
import com.nadrial.rollthedice.R;

import java.util.ArrayList;
import java.util.List;

public class Statistics extends AppCompatActivity {

    private List<ItemStat> getListStats() {
        return com.nadrial.rollthedice.Activities.setupList.generateStatsItems();
    }

    private List<ItemAchievement> getListAchievements() {
        return com.nadrial.rollthedice.Activities.setupList.generateAchievementsItems();
    }

    public Context context = this;

    boolean statsSelected = false, achievementsSelected = false;

    RecyclerView recyclerViewStats;
    TextView statsTittle;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statisticsview);

        ImageButton backButton = findViewById(R.id.backButton);

        recyclerViewStats = findViewById(R.id.recyclerViewStats);
        recyclerViewStats.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewStats.setAdapter(new ItemAdapterStats(getApplicationContext(), getListStats()));

        statsTittle = findViewById(R.id.statsLabel);
        Button statsMode = findViewById(R.id.statsMode);
        TextView statsLabel = findViewById(R.id.statsModeLabel);
        ImageButton statsImage = findViewById(R.id.statsImage);
        Button achievementsMode = findViewById(R.id.achievementsMode);
        TextView achievementsLabel = findViewById(R.id.achievementsLabel);
        ImageButton achievementsImage = findViewById(R.id.achievementsImage);

        selectMode(statsMode, statsLabel, statsImage);
        statsSelected = true;
        backButton.setOnClickListener(v -> {
            Navigator.openActivity(Statistics.this, MainMenu.class);
            finish();
        });
        statsImage.setOnClickListener(v -> {
            if (!statsSelected) {
                selectMode(statsMode, statsLabel, statsImage);
                recyclerViewStats.setLayoutManager(new LinearLayoutManager(context));
                recyclerViewStats.setAdapter(new ItemAdapterStats(getApplicationContext(), getListStats()));
                statsSelected = true;
            }
            if (achievementsSelected) {
                deselectMode(achievementsMode, achievementsLabel, achievementsImage);
                achievementsSelected = false;
            }

        });
        achievementsImage.setOnClickListener(v -> {
            if (!achievementsSelected) {
                selectMode(achievementsMode, achievementsLabel, achievementsImage);
                recyclerViewStats.setLayoutManager(new LinearLayoutManager(context));
                recyclerViewStats.setAdapter(new ItemAdapterAchievement(getApplicationContext(), getListAchievements()));
                achievementsSelected = true;
            }
            if (statsSelected) {
                deselectMode(statsMode, statsLabel, statsImage);
                statsSelected = false;
            }

        });


    }

    public void selectMode(Button button, TextView textView, ImageView imageView) {
        ObjectAnimator animation1 = ObjectAnimator.ofFloat(button, "translationY", -120f);
        ObjectAnimator animation2 = ObjectAnimator.ofFloat(textView, "translationY", -120f);
        ObjectAnimator animation3 = ObjectAnimator.ofFloat(imageView, "translationY", -120f);
        imageView.setColorFilter(ContextCompat.getColor(context, R.color.black));
        textView.setTextColor(ContextCompat.getColor(context, R.color.black));
        statsTittle.setText(textView.getText());

        animation1.setDuration(100);
        animation1.start();
        animation2.setDuration(100);
        animation2.start();
        animation3.setDuration(100);
        animation3.start();


    }

    public void deselectMode(Button button, TextView textView, ImageView imageView) {
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

class setupList {
    public static List<ItemStat> generateStatsItems() {
        List<ItemStat> items = new ArrayList<>();
        items.add(new ItemStat("Preguntas acertadas", "42"));
        items.add(new ItemStat("Preguntas falladas", "17"));
        items.add(new ItemStat("Posicion global clasico", "1"));
        items.add(new ItemStat("Posicion global speed", "1"));
        items.add(new ItemStat("Posicion just 1", "1"));
        items.add(new ItemStat("Preguntas acertadas mitologia", "13"));
        items.add(new ItemStat("Preguntas acertadas naturaleza", "12"));
        items.add(new ItemStat("Preguntas acertadas tecnologia", "17"));
        items.add(new ItemStat("Preguntas acertadas gastronomia", "5"));
        items.add(new ItemStat("Preguntas acertadas cultura", "4"));
        items.add(new ItemStat("Preguntas falladas mitologia", "3"));

        return items;
    }

    public static List<ItemAchievement> generateAchievementsItems() {
        List<ItemAchievement> items = new ArrayList<>();
        items.add(new ItemAchievement("Alcanza Top 1", true));
        items.add(new ItemAchievement("Alcanza Top 2", true));
        items.add(new ItemAchievement("Alcanza Top 3", true));
        items.add(new ItemAchievement("Contesta 10 preguntas", true));
        items.add(new ItemAchievement("Contesta 100 preguntas", true));
        items.add(new ItemAchievement("Contesta 1000 preguntas", false));
        items.add(new ItemAchievement("Acierta 10 preguntas", true));
        items.add(new ItemAchievement("Acierta 100 preguntas", false));
        items.add(new ItemAchievement("Acierta 1000 preguntas", false));
        items.add(new ItemAchievement("Falla 10 preguntas", true));
        items.add(new ItemAchievement("Falla 50 preguntas", true));
        items.add(new ItemAchievement("Falla 100 preguntas", false));
        items.add(new ItemAchievement("Falla 500 preguntas", false));
        items.add(new ItemAchievement("Falla 1000 preguntas", false));
        items.add(new ItemAchievement("Falla 100 Mitología", true));
        items.add(new ItemAchievement("Falla 100 Naturaleza", false));


        return items;
    }
}


