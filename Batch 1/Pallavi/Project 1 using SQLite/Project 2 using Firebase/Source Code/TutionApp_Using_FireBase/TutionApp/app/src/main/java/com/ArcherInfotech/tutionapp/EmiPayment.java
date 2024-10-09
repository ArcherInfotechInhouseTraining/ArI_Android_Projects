package com.ArcherInfotech.tutionapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class EmiPayment extends AppCompatActivity {

    TextView emipaybtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_emi_payment);

        emipaybtn = findViewById(R.id.emi_button);
        emipaybtn.setOnClickListener(view -> {
            Intent intent = new Intent(EmiPayment.this, Payment_Success.class);
            startActivity(intent);
        });
    }
}