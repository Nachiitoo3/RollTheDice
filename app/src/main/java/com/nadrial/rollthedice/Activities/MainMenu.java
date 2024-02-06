package com.nadrial.rollthedice.Activities;


import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.nadrial.rollthedice.Entities.GameMode;
import com.nadrial.rollthedice.R;
import com.nadrial.rollthedice.Navigator;

public class MainMenu extends AppCompatActivity {

    Context context = this;
    TextView modeTextView;
    Button setCrono, setClassic, setJustOne;
    Spinner categorySpinner;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainmenuview);

        Button playButton = findViewById(R.id.playButtonMainView);
        Button recordsButton = findViewById(R.id.recordsButtonMainView);
        Button statisticsButton = findViewById(R.id.statisticsButtonMainView);
        ImageView configIcon = findViewById(R.id.configImageMainView);
        modeTextView = findViewById(R.id.modoTextViewMainView);
        setCrono = findViewById(R.id.speedButtonMainView);
        setClassic = findViewById(R.id.classicButtonMainView);
        setJustOne = findViewById(R.id.categoryButtonMainView);
        categorySpinner = findViewById(R.id.categorySpinnerMainView);
        setUpSpinner(getResources().getStringArray(R.array.categorias), categorySpinner);

        configIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showOptionsMenuDialog(context);
            }
        });
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigator.openActivity(MainMenu.this, Dice.class);
                if (GameMode.getMode() == 2) {
                    GameMode.setCategory(categorySpinner.getSelectedItemPosition());
                }
            }
        });
        setCrono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCronoGame();
            }
        });
        setClassic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setClassicGame();
            }
        });
        setJustOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setJustOneGame();
            }
        });
        recordsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigator.openActivity(MainMenu.this, Records.class);
            }
        });
        statisticsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigator.openActivity(MainMenu.this, Statistics.class);
            }
        });
    }

    public void setUpSpinner(String[] data, Spinner spinner) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, data) {
            @NonNull
            @Override
            public View getView(int position, View convertView, @NonNull ViewGroup parent) {
                TextView textView = (TextView) super.getView(position, convertView, parent);
                textView.setTextColor(Color.BLACK);
                return textView;
            }

            public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                TextView textView = (TextView) super.getDropDownView(position, convertView, parent);
                textView.setTextColor(Color.BLACK);
                textView.setBackgroundResource(R.drawable.gradient2);
                textView.setPadding(350, 0, 0, 0);

                return textView;
            }
        };
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    public static void showOptionsMenuDialog(Context context) {
        Dialog optionsDialog = new Dialog(context);
        optionsDialog.setContentView(R.layout.options_menu);
        optionsDialog.setTitle("Opciones");
        optionsDialog.show();
    }

    public void setClassicGame() {
        modeTextView.setText("Classic Mode");
        GameMode.setDuration(20000);
        GameMode.setMode(0);
        categorySpinner.setVisibility(View.INVISIBLE);

        Drawable drawableCrono = setCrono.getCompoundDrawables()[0];
        drawableCrono.setColorFilter(ContextCompat.getColor(context, R.color.grey), PorterDuff.Mode.SRC_IN);
        drawableCrono.setBounds(3, 0, 55, 55);
        setCrono.setCompoundDrawablesRelative(drawableCrono, null, null, null);

        Drawable drawableClassic = setClassic.getCompoundDrawables()[0];
        drawableClassic.setColorFilter(ContextCompat.getColor(context, R.color.black), PorterDuff.Mode.SRC_IN);
        drawableClassic.setBounds(-40, -2, 110, 135);
        setClassic.setCompoundDrawablesRelative(drawableClassic, null, null, null);

        Drawable drawableUnico = setJustOne.getCompoundDrawables()[0];
        drawableUnico.setColorFilter(ContextCompat.getColor(context, R.color.grey), PorterDuff.Mode.SRC_IN);
        drawableUnico.setBounds(15, -1, 55, 38);
        setJustOne.setCompoundDrawablesRelative(drawableUnico, null, null, null);
    }

    @SuppressLint("SetTextI18n")
    public void setCronoGame() {
        modeTextView.setText("Speed Mode");
        GameMode.setDuration(10000);
        GameMode.setMode(1);

        categorySpinner.setVisibility(View.INVISIBLE);
        Drawable drawableCrono = setCrono.getCompoundDrawables()[0];
        drawableCrono.setColorFilter(ContextCompat.getColor(context, R.color.black), PorterDuff.Mode.SRC_IN);
        drawableCrono.setBounds(-20, 0, 85, 85);

        setCrono.setCompoundDrawablesRelative(drawableCrono, null, null, null);
        Drawable drawableClassic = setClassic.getCompoundDrawables()[0];
        drawableClassic.setColorFilter(ContextCompat.getColor(context, R.color.grey), PorterDuff.Mode.SRC_IN);
        drawableClassic.setBounds(-10, 0, 80, 80);

        setClassic.setCompoundDrawablesRelative(drawableClassic, null, null, null);
        Drawable drawableUnico = setJustOne.getCompoundDrawables()[0];
        drawableUnico.setColorFilter(ContextCompat.getColor(context, R.color.grey), PorterDuff.Mode.SRC_IN);
        drawableUnico.setBounds(15, -1, 55, 38);
        setJustOne.setCompoundDrawablesRelative(drawableUnico, null, null, null);
    }

    @SuppressLint("SetTextI18n")
    public void setJustOneGame() {
        modeTextView.setText("Just 1 Mode");
        GameMode.setDuration(20000);
        GameMode.setMode(2);
        categorySpinner.setVisibility(View.VISIBLE);

        Drawable drawableCrono = setCrono.getCompoundDrawables()[0];
        drawableCrono.setColorFilter(ContextCompat.getColor(context, R.color.grey), PorterDuff.Mode.SRC_IN);
        drawableCrono.setBounds(3, 0, 55, 55);
        setCrono.setCompoundDrawablesRelative(drawableCrono, null, null, null);

        Drawable drawableClassic = setClassic.getCompoundDrawables()[0];
        drawableClassic.setColorFilter(ContextCompat.getColor(context, R.color.grey), PorterDuff.Mode.SRC_IN);
        drawableClassic.setBounds(-10, 0, 80, 80);
        setClassic.setCompoundDrawablesRelative(drawableClassic, null, null, null);

        Drawable drawableJustOne = setJustOne.getCompoundDrawables()[0];
        drawableJustOne.setColorFilter(ContextCompat.getColor(context, R.color.black), PorterDuff.Mode.SRC_IN);
        drawableJustOne.setBounds(-1, -2, 72, 72);
        setJustOne.setCompoundDrawablesRelative(drawableJustOne, null, null, null);
    }
}
