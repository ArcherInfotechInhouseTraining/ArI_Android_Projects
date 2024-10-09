package com.ArcherInfotech.tutionapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;

public class payment extends AppCompatActivity {

    LinearLayout netBankingLinearLayout;
    TextView netBanking_textView;

    LinearLayout linearUpi;
    LinearLayout linearCard;
    LinearLayout linearEmi;

    TextView continuebtn;

    TextView moreText;
    GridLayout gridLayout;


    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_payment);

//        netBankingRelativeLayout = findViewById(R.id.netBanking_relative);
        netBankingLinearLayout = findViewById(R.id.netbanking);


        linearUpi = findViewById(R.id.upi);

//        FragmentManager fragmentManager = getSupportFragmentManager();

        linearCard = findViewById(R.id.creditcard);
        linearEmi = findViewById(R.id.emi);
        continuebtn = findViewById(R.id.paycontinue_button);

        continuebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(payment.this,Payment_Success.class);
                startActivity(intent);
            }
        });

        // Set click listener on LinearLayout to toggle RecyclerView visibility

//        netBankingRelativeLayout.setOnClickListener( view -> {
//
//            setVisibilityToggleForGridLayout(gridLayout);
//
//        });

//        netBankingLinearLayout.setOnClickListener( view -> {
//            setVisibilityToggleForGridLayout(gridLayout);
//        });

//        moreText.setOnClickListener( view -> {
//            Intent intent = new Intent(payment.this, NetBanking.class);
//            startActivity(intent);
//        });

        netBankingLinearLayout.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Log.d("MainActivity", "Textview clicked");  //for debugging
                Intent intent = new Intent(payment.this, NetBanking.class);
                startActivity(intent);

            }

        });


        linearUpi.setOnClickListener(view -> {
            Intent intent = new Intent(payment.this, UPIPayment.class);
            startActivity(intent);
        });

        linearCard.setOnClickListener(view -> {
            Intent intent = new Intent(payment.this, CardPayment.class);
            startActivity(intent);
        });

        linearEmi.setOnClickListener(view -> {
            Intent intent = new Intent(payment.this, EmiPayment.class);
            startActivity(intent);
        });
    }

    public void setVisibilityToggleForGridLayout(GridLayout gridLayout){

        if(gridLayout.getVisibility() == View.GONE){
            gridLayout.setVisibility(View.VISIBLE);
        }
        else {
            gridLayout.setVisibility(View.GONE);
        }
    }
}