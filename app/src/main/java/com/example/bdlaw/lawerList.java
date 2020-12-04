package com.example.bdlaw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class lawerList extends AppCompatActivity implements View.OnClickListener {
    private Button lawerListButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lawer_list);

        lawerListButton = (Button) findViewById(R.id.lawerListButton);
        lawerListButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.lawerListButton:
                startActivity(new Intent(this, listView.class));
                break;
        }
    }
}