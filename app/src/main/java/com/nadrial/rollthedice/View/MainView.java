package com.nadrial.rollthedice.View;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.nadrial.rollthedice.Entities.GameMode;
import com.nadrial.rollthedice.Presenter.MainPresenter;
import com.nadrial.rollthedice.R;
import com.nadrial.rollthedice.Router.Router;

public class MainView extends AppCompatActivity {

    Context context = this;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainview);

        TextView modoTextView = findViewById(R.id.modoTextViewMainView);
        Spinner categoriasSpinner = findViewById(R.id.categorySpinnerMainView);
        MainPresenter.setUpSpinner(getResources().getStringArray(R.array.categorias), categoriasSpinner, this);

        Button playButton = findViewById(R.id.playButtonMainView);
        Button recordsButton = findViewById(R.id.recordsButtonMainView);
        Button statisticsButton = findViewById(R.id.statisticsButtonMainView);
        Button setCrono = findViewById(R.id.speedButtonMainView);
        Button setClassic = findViewById(R.id.classicButtonMainView);
        Button setCategory = findViewById(R.id.categoryButtonMainView);

        ImageView btnOpenMenu = findViewById(R.id.configImageMainView);


        btnOpenMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainPresenter.showOptionsMenuDialog(context);
            }
        });

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Router.openActivity(MainView.this, DiceView.class);
                if (GameMode.categoria == -1){
                    GameMode.indexSpinner = categoriasSpinner.getSelectedItemPosition();
                }
            }
        });
        setCrono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                MainPresenter.setCronoGame();
                modoTextView.setText("Modo Speed");
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
        });
        setClassic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modoTextView.setText("Modo Classic");
                MainPresenter.setClasicGame();
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
        });
        setCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modoTextView.setText("Modo Único");
                MainPresenter.setCategoryGame();
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


}
