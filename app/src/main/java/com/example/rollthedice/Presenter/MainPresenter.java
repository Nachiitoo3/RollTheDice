package com.example.rollthedice.Presenter;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.rollthedice.Entities.GameMode;
import com.example.rollthedice.R;

public class MainPresenter  {

    public static void setUpSpinner(String[] datos, Spinner spinner, Context context) {
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item, datos) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
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

    public static void setCronoGame(){
        GameMode.duration = 10000;
        GameMode.categoria = -2;

    }

    public static void setClasicGame(){
        GameMode.duration = 20000;
        GameMode.categoria = -2;
    }

    public static void setCategoryGame(){
        GameMode.duration = 20000;
        GameMode.categoria = -1;

    }

    public static void showOptionsMenuDialog(Context context) {
        Dialog optionsDialog = new Dialog(context);
        optionsDialog.setContentView(R.layout.options_menu);
        optionsDialog.setTitle("Opciones");

        optionsDialog.show();
    }
}
