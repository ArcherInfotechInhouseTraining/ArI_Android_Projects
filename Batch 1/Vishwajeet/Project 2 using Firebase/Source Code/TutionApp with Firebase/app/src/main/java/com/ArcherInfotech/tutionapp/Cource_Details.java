package com.ArcherInfotech.tutionapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Cource_Details extends AppCompatActivity {


    TextView cancelbtn;
    TextView paymentbtn;

    @Override
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cource_details);


        //Find View By id
        TextView courcetextview = findViewById(R.id.courcename);
        TextView syllabustext = findViewById(R.id.syllabustext);
        TextView instructortext = findViewById(R.id.instructername);
        TextView professiontext = findViewById(R.id.instructerinfo);
        TextView feestext = findViewById(R.id.paynow);


        //retrive data from intent
        String course = getIntent().getStringExtra("course");
        String[] syllabus = getIntent().getStringArrayExtra("syllabus");
        String instructor = getIntent().getStringExtra("instructor");
        String[] profession = getIntent().getStringArrayExtra("profession");
        String fees = getIntent().getStringExtra("fees");

        courcetextview.setText(course);

        //Format and set Syllabus;
        if(syllabus != null)
        {
            StringBuilder syllabusBuilder = new StringBuilder();
            for (String line : syllabus) {
                syllabusBuilder.append(line).append("\n");
            }
            syllabustext.setText(syllabusBuilder.toString().trim());
        }
        else
        {
            syllabustext.setText("No Syllabus Available");
        }

        if(profession != null)
        {
            StringBuilder professionBuilder = new StringBuilder();
            for (String line : profession) {
                professionBuilder.append(line).append("\n");
            }
            professiontext.setText(professionBuilder.toString().trim());
        }
        else
        {
            professiontext.setText("No Profession Available");
        }

        instructortext.setText(instructor);
        feestext.setText(fees);

        paymentbtn = findViewById(R.id.paynow);
        paymentbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Cource_Details.this, AdmissionForm.class);
                startActivity(intent);
            }
        });

        cancelbtn = findViewById(R.id.cancelpayment);
        cancelbtn.setOnClickListener(view -> {
            Intent intent = new Intent(Cource_Details.this, cource_list.class);
            startActivity(intent);
        });
    }
}