package com.example.rollthedice.Router;

import android.content.Context;
import android.content.Intent;


import androidx.appcompat.app.AppCompatActivity;

public class Router extends AppCompatActivity {

    public static void openActivity(Context context, Class<?> cls) {
        Intent intent = new Intent(context, cls);
        context.startActivity(intent);
    }

    public static void openQuestion(Context context, Class<?> cls, int randomNumber) {
        Intent intent = new Intent(context, cls);
        intent.putExtra("categoria", randomNumber);
        context.startActivity(intent);
    }

}
