package com.nadrial.rollthedice.View;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.nadrial.rollthedice.Presenter.RecordsPresenter;
import com.nadrial.rollthedice.R;
import com.nadrial.rollthedice.Router.Router;

public class RecordsView extends RecordsPresenter {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recordsview);

        Button mainButton = findViewById(R.id.mainButtonRecordsView);
        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Router.openActivity(RecordsView.this, MainView.class);
            }
        });


    }
}
