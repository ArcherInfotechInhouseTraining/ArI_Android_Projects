package com.ArcherInfotech.tutionapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class profile_activity extends AppCompatActivity {

    private DatabaseReference databaseReference;
    private ImageView imageViewProfile;
    private TextView textViewName, textViewMobile, textFullname, textViewEmail, seeAllCourses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Initialize views
        imageViewProfile = findViewById(R.id.profile_image);
        textViewName = findViewById(R.id.username);
        textViewMobile = findViewById(R.id.mobile);
        textFullname = findViewById(R.id.name);
        textViewEmail = findViewById(R.id.email);
        seeAllCourses = findViewById(R.id.seeall);

        // Firebase Database reference
        databaseReference = FirebaseDatabase.getInstance().getReference("Users").child("user1");

        // Set up a listener for "See All Courses" button
        seeAllCourses.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), payment.class)));

        // Retrieve user data from Firebase
        loadProfileData();
    }

    private void loadProfileData() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    String name = dataSnapshot.child("name").getValue(String.class);
                    String fullname = dataSnapshot.child("name").getValue(String.class); // assuming same as name
                    String phone = dataSnapshot.child("phone").getValue(String.class);
                    String email = dataSnapshot.child("email").getValue(String.class);
                    String imageUrl = dataSnapshot.child("imageURL").getValue(String.class);

                    // Set data to views
                    textViewName.setText(" " + name);
                    textFullname.setText(" " + fullname);
                    textViewMobile.setText(" " + phone);
                    textViewEmail.setText(" " + email);

                    // Load image from URL
                    if (imageUrl != null && !imageUrl.isEmpty()) {
                        Uri uri = Uri.parse(imageUrl);
                        imageViewProfile.setImageURI(uri);
                    }
                } else {
                    Toast.makeText(profile_activity.this, "User data not found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(profile_activity.this, "Failed to load data", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
