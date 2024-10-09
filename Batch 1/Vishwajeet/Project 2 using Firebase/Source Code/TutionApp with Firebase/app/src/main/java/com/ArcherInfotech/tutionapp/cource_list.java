package com.ArcherInfotech.tutionapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ArcherInfotech.tutionapp.Adaptor.CourceAdaptor;
import com.ArcherInfotech.tutionapp.Listener.ItemClickListner;
import com.ArcherInfotech.tutionapp.Modal.Cources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class cource_list extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.cource_list);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Get the string arrays from strings.xml
        String[] courses = getResources().getStringArray(R.array.course_array);
        String[] duration = getResources().getStringArray(R.array.duration_array);
        String[] instructors = getResources().getStringArray(R.array.instructer_name_array);

        String[][] professions = {
                getResources().getStringArray(R.array.prof_Ankita_info),
                getResources().getStringArray(R.array.prof_YogeshPatil_info),
                getResources().getStringArray(R.array.prof_YogeshPatil_info),
                getResources().getStringArray(R.array.prof_Ankita_info),
                getResources().getStringArray(R.array.prof_PrajwalVahane_info),
                getResources().getStringArray(R.array.prof_YogeshPatil_info),
                getResources().getStringArray(R.array.prof_Ankita_info),
                getResources().getStringArray(R.array.prof_PrajwalVahane_info)
        };
        String[] images = getResources().getStringArray(R.array.cource_img_array);
//        String[] courcebgimg = getResources().getStringArray(R.array.cource_img_bg);
        String[] fees = getResources().getStringArray(R.array.fees_array);

        String[][] syllabi = {
                getResources().getStringArray(R.array.c_syllabus_array),
                getResources().getStringArray(R.array.cpp_syllabus_array),
                getResources().getStringArray(R.array.java_syllabus_array),
                getResources().getStringArray(R.array.sql_syllabus_array),
                getResources().getStringArray(R.array.ds),
                getResources().getStringArray(R.array.ai_syllabus_array),
                getResources().getStringArray(R.array.webdev_syllabus_array),
                getResources().getStringArray(R.array.testing_syllabus_array)
        };

        // Set the adapter
        CourceAdaptor adapter = new CourceAdaptor(courses, images, duration, instructors, professions,syllabi, fees);
        recyclerView.setAdapter(adapter);
    }
}