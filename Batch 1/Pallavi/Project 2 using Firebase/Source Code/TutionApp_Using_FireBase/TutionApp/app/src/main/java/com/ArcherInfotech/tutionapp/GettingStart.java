package com.ArcherInfotech.tutionapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.ArcherInfotech.tutionapp.Adapter.FragmentStateAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class GettingStart extends AppCompatActivity {
    LinearLayout linearLayout,dotsLayout;
    private int numOfFragments = 4;
    ViewPager2 viewPager2;
    private ImageView[] dots;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_getting_start);

        linearLayout = findViewById(R.id.li);
        viewPager2 = findViewById(R.id.viewpager);

        FragmentStateAdapter adapter = new FragmentStateAdapter(this);
        viewPager2.setAdapter(adapter);

        dotsLayout = findViewById(R.id.dotsLayout);
        createDots(0);

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                createDots(position);
            }
        });

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GettingStart.this, Login_signUp.class));
            }
        });


    }

    private void createDots(int currentPosition) {
        if (dotsLayout != null) {
            dotsLayout.removeAllViews();  // Clear existing dots
        }

        dots = new ImageView[numOfFragments];  // Adjust according to the number of fragments

        for (int i = 0; i < numOfFragments; i++) {
            dots[i] = new ImageView(this);

            if (i == currentPosition) {
                dots[i].setImageDrawable(getDrawable(R.drawable.active_dott));  // Active dot drawable
            } else {
                dots[i].setImageDrawable(getDrawable(R.drawable.inactive_dot));  // Inactive dot drawable
            }

            // Set the size and margins for each dot
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(8, 0, 8, 0);  // Adjust the space between dots
            dotsLayout.addView(dots[i], params);
        }
    }
}