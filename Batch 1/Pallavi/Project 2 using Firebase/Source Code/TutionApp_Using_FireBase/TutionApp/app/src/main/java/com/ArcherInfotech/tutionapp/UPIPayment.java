package com.ArcherInfotech.tutionapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class UPIPayment extends AppCompatActivity {

    TextView upipaybtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_upipayment);

        upipaybtn = findViewById(R.id.upicontinuebtn);
        upipaybtn.setOnClickListener(view -> {
            Intent intent = new Intent(UPIPayment.this, Payment_Success.class);
            startActivity(intent);
        });
    }
}