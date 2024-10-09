package com.ArcherInfotech.tutionapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;


import com.ArcherInfotech.tutionapp.Adapter.ImageSliderAdapter;
import com.ArcherInfotech.tutionapp.Adapter.MyAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class Login_signUp extends AppCompatActivity {
    FrameLayout frameLayout;

    AppCompatButton userbtn,adminbtn;
    private int[] images = {R.drawable.image1, R.drawable.image2, R.drawable.image3};
    private Handler handler = new Handler(Looper.getMainLooper());
    private Runnable runnable;
    LinearLayout linearLayout,dotsLayout;
    private int numOfFragments = 3;
    ViewPager2 viewPager2;
    MyAdapter myAdapter;
    private ImageView[] dots;
    FragmentManager fragmentManager;
    TabLayout tabLayout;

    private final Handler slideHandler = new Handler(Looper.getMainLooper());
    private Runnable slideRunnable;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      
        setContentView(R.layout.activity_login_sign_up);

        fragmentManager= getSupportFragmentManager();
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.frame);
         fragment = fragmentManager.findFragmentById(R.id.frame);
        if (fragment == null) {
            fragmentManager.beginTransaction().replace(R.id.frame, new User_Login()).commit();
        }
        fragmentManager.beginTransaction().replace(R.id.frame,new User_Login()).commit();


        
        userbtn = findViewById(R.id.userbtn);
        adminbtn = findViewById(R.id.adminbtn);
        viewPager2 = findViewById(R.id.studentimg);


        myAdapter = new MyAdapter(
          getSupportFragmentManager(),
          getLifecycle()
        );

        ImageSliderAdapter adapter = new ImageSliderAdapter(this);
        viewPager2.setAdapter(adapter);

        startAutoSlide();




        userbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction().replace(R.id.frame,new User_Login()).commit();
                userbtn.setTextColor(getResources().getColor(R.color.ternary));
                adminbtn.setTextColor(getResources().getColor(R.color.primary));
            }
        });



        adminbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction().replace(R.id.frame,new Admin_login() ).commit();
                adminbtn.setTextColor(getResources().getColor(R.color.ternary));
                userbtn.setTextColor(getResources().getColor(R.color.primary));

            }
        });

    }
    boolean isSlidingForward = true;
    private void startAutoSlide() {
        slideRunnable = new Runnable() {
            @Override
            public void run() {

                int currentItem = viewPager2.getCurrentItem();
                int totalIems =viewPager2.getAdapter().getItemCount();
                int nextItem = currentItem + 1;

                // If the current item is the last one, set the next item to the first one (infinite loop)
                if (isSlidingForward) {
                    if (currentItem < totalIems - 1) {
                        // Slide forward if not at the last item
                        viewPager2.setCurrentItem(currentItem + 1, true);
                    } else {
                        // When at the last item, change direction to backward
                        isSlidingForward = false;
                        viewPager2.setCurrentItem(currentItem - 1, true);
                    }
                } else {
                    if (currentItem > 0) {
                        // Slide backward if not at the first item
                        viewPager2.setCurrentItem(currentItem - 1, true);
                    } else {
                        // When at the first item, change direction to forward
                        isSlidingForward = true;
                        viewPager2.setCurrentItem(currentItem + 1, true);
                    }
                }

                // Schedule the next slide after 2 seconds
                slideHandler.postDelayed(this, 2000);
            }
        };

        // Start the slide show initially
        slideHandler.postDelayed(slideRunnable, 2000);
    }

}

