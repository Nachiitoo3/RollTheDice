package com.example.rollthedice.View;



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

import com.example.rollthedice.Entities.GameMode;
import com.example.rollthedice.R;
import com.example.rollthedice.Router.Router;

public class MainView extends AppCompatActivity {

    Context context = this;

    TextView modoTextView;
    Button setCrono, setClassic, setCategory;
    Spinner categoriasSpinner;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainview);

        Button playButton = findViewById(R.id.playButtonMainView);
        Button recordsButton = findViewById(R.id.recordsButtonMainView);
        Button statisticsButton = findViewById(R.id.statisticsButtonMainView);
        ImageView btnOpenMenu = findViewById(R.id.configImageMainView);
        modoTextView = findViewById(R.id.modoTextViewMainView);
        setCrono = findViewById(R.id.speedButtonMainView);
        setClassic = findViewById(R.id.classicButtonMainView);
        setCategory = findViewById(R.id.categoryButtonMainView);

        categoriasSpinner = findViewById(R.id.categorySpinnerMainView);
        setUpSpinner(getResources().getStringArray(R.array.categorias), categoriasSpinner);

        btnOpenMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showOptionsMenuDialog(context);
            }
        });
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Router.openActivity(MainView.this, DiceView.class);
                if (GameMode.categoria == -1) {
                    GameMode.setIndexSpinner(categoriasSpinner.getSelectedItemPosition());
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
        setCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCategoriaGame();
            }
        });

        recordsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Router.openActivity(MainView.this, RecordsView.class);
            }
        });

        statisticsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Router.openActivity(MainView.this, StatisticsView.class);
            }
        });



    }
    public void setUpSpinner (String[]datos, Spinner spinner){
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, datos) {
            @NonNull
            @Override
            public View getView(int position, View convertView, @NonNull ViewGroup parent) {
                TextView vista = (TextView) super.getView(position, convertView, parent);
                vista.setTextColor(Color.BLACK);
                return vista;
            }

            public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                TextView vista = (TextView) super.getDropDownView(position, convertView, parent);
                vista.setTextColor(Color.BLACK);
                vista.setBackgroundResource(R.drawable.gradient2);
                vista.setPadding(350, 0, 0, 0);

                return vista;
            }

        };
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spinner.setAdapter(adaptador);

    }
    public static void showOptionsMenuDialog(Context context) {
        Dialog optionsDialog = new Dialog(context);
        optionsDialog.setContentView(R.layout.options_menu);
        optionsDialog.setTitle("Opciones");

        optionsDialog.show();
    }
    public void setClassicGame() {
        modoTextView.setText("Classic Mode");
        GameMode.setDuration(20000);
        GameMode.setCategoria(-2);
        categoriasSpinner.setVisibility(View.INVISIBLE);

        Drawable drawableCrono = setCrono.getCompoundDrawables()[0];
        drawableCrono.setColorFilter(ContextCompat.getColor(context, R.color.grey), PorterDuff.Mode.SRC_IN);
        drawableCrono.setBounds(3, 0, 55, 55);
        setCrono.setCompoundDrawablesRelative(drawableCrono, null, null, null);

        Drawable drawableClassic = setClassic.getCompoundDrawables()[0];
        drawableClassic.setColorFilter(ContextCompat.getColor(context, R.color.black), PorterDuff.Mode.SRC_IN);
        drawableClassic.setBounds(-40, -2, 110, 135);
        setClassic.setCompoundDrawablesRelative(drawableClassic, null, null, null);

        Drawable drawableUnico = setCategory.getCompoundDrawables()[0];
        drawableUnico.setColorFilter(ContextCompat.getColor(context, R.color.grey), PorterDuff.Mode.SRC_IN);
        drawableUnico.setBounds(15, -1, 55, 38);
        setCategory.setCompoundDrawablesRelative(drawableUnico, null, null, null);
    }
    @SuppressLint("SetTextI18n")
    public void setCronoGame() {
        modoTextView.setText("Speed Mode");
        GameMode.setDuration(10000);
        GameMode.setCategoria(-2);
        categoriasSpinner.setVisibility(View.INVISIBLE);
        Drawable drawableCrono = setCrono.getCompoundDrawables()[0];
        drawableCrono.setColorFilter(ContextCompat.getColor(context, R.color.black), PorterDuff.Mode.SRC_IN);
        drawableCrono.setBounds(-20, 0, 85, 85);
        setCrono.setCompoundDrawablesRelative(drawableCrono, null, null, null);
        Drawable drawableClassic = setClassic.getCompoundDrawables()[0];
        drawableClassic.setColorFilter(ContextCompat.getColor(context, R.color.grey), PorterDuff.Mode.SRC_IN);
        drawableClassic.setBounds(-10, 0, 80, 80);
        setClassic.setCompoundDrawablesRelative(drawableClassic, null, null, null);
        Drawable drawableUnico = setCategory.getCompoundDrawables()[0];
        drawableUnico.setColorFilter(ContextCompat.getColor(context, R.color.grey), PorterDuff.Mode.SRC_IN);
        drawableUnico.setBounds(15, -1, 55, 38);
        setCategory.setCompoundDrawablesRelative(drawableUnico, null, null, null);
    }
    @SuppressLint("SetTextI18n")
    public void setCategoriaGame() {
            modoTextView.setText("Just 1 Mode");
            GameMode.setDuration(20000);
            GameMode.setCategoria(-1);
            categoriasSpinner.setVisibility(View.VISIBLE);

            Drawable drawableCrono = setCrono.getCompoundDrawables()[0];
            drawableCrono.setColorFilter(ContextCompat.getColor(context, R.color.grey), PorterDuff.Mode.SRC_IN);
            drawableCrono.setBounds(3, 0, 55, 55);
            setCrono.setCompoundDrawablesRelative(drawableCrono, null, null, null);

            Drawable drawableClassic = setClassic.getCompoundDrawables()[0];
            drawableClassic.setColorFilter(ContextCompat.getColor(context, R.color.grey), PorterDuff.Mode.SRC_IN);
            drawableClassic.setBounds(-10, 0, 80, 80);
            setClassic.setCompoundDrawablesRelative(drawableClassic, null, null, null);

            Drawable drawableUnico = setCategory.getCompoundDrawables()[0];
            drawableUnico.setColorFilter(ContextCompat.getColor(context, R.color.black), PorterDuff.Mode.SRC_IN);
            drawableUnico.setBounds(-1, -2, 72, 72);
            setCategory.setCompoundDrawablesRelative(drawableUnico, null, null, null);
        }

}
