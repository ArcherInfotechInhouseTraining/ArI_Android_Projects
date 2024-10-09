package com.ArcherInfotech.tutionapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class HomePageActivity extends AppCompatActivity {

    TextView seeall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_page);

        seeall = findViewById(R.id.txtview2);

        seeall.setOnClickListener(view -> {
            startActivity(new Intent(HomePageActivity.this, cource_list.class));
        });
    }
}
