package com.example.rollthedice.View;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.rollthedice.Presenter.RecordsPresenter;
import com.example.rollthedice.R;
import com.example.rollthedice.NavigatorController.NavigatorController;

public class RecordsView extends RecordsPresenter {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recordsview);

        Button mainButton = findViewById(R.id.mainButtonRecordsView);
        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavigatorController.openActivity(RecordsView.this, MainView.class);
            }
        });


    }
}
