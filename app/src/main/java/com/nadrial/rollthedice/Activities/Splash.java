package com.nadrial.rollthedice.Activities;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import pl.droidsonroids.gif.AnimationListener;
import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

import com.nadrial.rollthedice.R;
import com.nadrial.rollthedice.Navigator;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashview);

        splash();
    }

    public void transition(Context context, Class<?> cls) {
        Navigator.openActivity(context, cls);
        finish();
    }

    private void splash() {
        GifImageView mSplash = findViewById(R.id.fondo);

        try {
            GifDrawable gifDrawable = new GifDrawable(getResources(), R.drawable.splashgiff);
            mSplash.setImageDrawable(gifDrawable);


            gifDrawable.addAnimationListener(new AnimationListener() {
                @Override
                public void onAnimationCompleted(int loopNumber) {
                    // La animación ha terminado, ahora puedes iniciar la transición
                    transition(Splash.this, Login.class);
                }
            });

            // Inicia la animación manualmente
            gifDrawable.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
