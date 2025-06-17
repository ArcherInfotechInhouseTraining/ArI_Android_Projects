package com.ArcherInfotech.tutionapp;


import static com.ArcherInfotech.tutionapp.SQLiteDB.DBHelper1.COLUMN_EMAIL;
import static com.ArcherInfotech.tutionapp.SQLiteDB.DBHelper1.COLUMN_IMAGE;
import static com.ArcherInfotech.tutionapp.SQLiteDB.DBHelper1.COLUMN_NAME;
import static com.ArcherInfotech.tutionapp.SQLiteDB.DBHelper1.COLUMN_PHONE;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.ArcherInfotech.tutionapp.SQLiteDB.DBHelper1;

public class profile_activity extends AppCompatActivity {

    private DBHelper1 dbHelper;


    @SuppressLint("Range")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ImageView imageViewProfile = findViewById(R.id.profile_image);
        TextView textViewName = findViewById(R.id.username);
        TextView textViewMobile = findViewById(R.id.mobile);
        TextView textFullname = findViewById(R.id.name);
        TextView textViewEmail = findViewById(R.id.email);
       // AppCompatButton btnBackHome = findViewById(R.id.btn_back_home);
        TextView seeallcource= findViewById(R.id.seeall);

        seeallcource.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),cource_list.class));
            }
        });

        dbHelper = new DBHelper1(this);
        Cursor cursor = dbHelper.getProfile();

        if (cursor.moveToFirst()) {
            String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
            String fullname = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
            String phone = cursor.getString(cursor.getColumnIndex(COLUMN_PHONE));
            String email = cursor.getString(cursor.getColumnIndex(COLUMN_EMAIL));
            byte[] imageBytes = cursor.getBlob(cursor.getColumnIndex(COLUMN_IMAGE));

            textViewName.setText(" " + name);
            textFullname.setText(" " + fullname);
            textViewMobile.setText(" " + phone);
            textViewEmail.setText(" " + email);

            if (imageBytes != null) {
                Bitmap bitmap = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
                imageViewProfile.setImageBitmap(bitmap);
            }
        }
        cursor.close();
    }
}
