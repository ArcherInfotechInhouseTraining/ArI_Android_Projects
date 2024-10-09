package com.ArcherInfotech.tutionapp;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class CardPayment extends AppCompatActivity {

    EditText datePicker_editText;
    private int selectedMonth, selectedYear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_card_payment);

        datePicker_editText = findViewById(R.id.date_editText);

        datePicker_editText.setOnClickListener(view -> showMonthYearPickerDialog());

    }

    private void showMonthYearPickerDialog(){
        Calendar calendar = Calendar.getInstance();

        @SuppressLint({"NewApi", "LocalSuppress"})
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                selectedYear = year;
                selectedMonth = monthOfYear+1;
                String date = "Month: "+selectedMonth+" year: "+selectedYear;

                datePicker_editText.setText(date);

            }
        };

//        create the date picker dialog
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                CardPayment.this,
                dateSetListener,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)

        );

//        hide the day picker

        datePickerDialog.getDatePicker().findViewById( getResources().getIdentifier("day", "id", "android")).setVisibility(View.GONE);
        datePickerDialog.show();
    }
}