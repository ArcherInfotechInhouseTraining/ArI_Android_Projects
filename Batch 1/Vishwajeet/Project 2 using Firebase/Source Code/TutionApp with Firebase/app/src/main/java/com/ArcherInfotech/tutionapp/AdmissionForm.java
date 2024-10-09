package com.ArcherInfotech.tutionapp;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.ByteArrayOutputStream;
import java.util.Calendar;
import java.util.HashMap;

public class AdmissionForm extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;
    private static final int CAMERA_REQUEST = 2;

    private Uri imageUri;
    private TextView datetextView;
    private Spinner courselevel;
    private ImageView buttonUpload;
    private DatabaseReference databaseReference;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admission_form);

        EditText editFullName = findViewById(R.id.full_name);
        EditText editEmail = findViewById(R.id.email);
        EditText editPhone = findViewById(R.id.phone);
        buttonUpload = findViewById(R.id.uploadfProfile);
        datetextView = findViewById(R.id.dateTextView);
        courselevel = findViewById(R.id.level);
        AppCompatButton buttonRegister = findViewById(R.id.submit_button);

        // Initialize Firebase Database reference
        databaseReference = FirebaseDatabase.getInstance().getReference("Users");

        // Set up the ArrayAdapter for Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.course_list, R.layout.spinner_selected_item);
        adapter.setDropDownViewResource(R.layout.spinner_item);
        courselevel.setAdapter(adapter);

        courselevel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if (position != 0) {
                    String selectedCourse = parentView.getItemAtPosition(position).toString();
                    Toast.makeText(AdmissionForm.this, "Selected: " + selectedCourse, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Do nothing
            }
        });

        // Initialize the date picker
        datetextView.setOnClickListener(v -> showDatePicker());

        buttonUpload.setOnClickListener(v -> openFileChooser());

        buttonRegister.setOnClickListener(v -> {
            String name = editFullName.getText().toString().trim();
            String phone = editPhone.getText().toString().trim();
            String email = editEmail.getText().toString().trim();
            String course = courselevel.getSelectedItem().toString();
            String date = datetextView.getText().toString();
            String imageUrl = imageUri != null ? imageUri.toString() : null;



            if (name.isEmpty() || phone.isEmpty() || email.isEmpty() || course.isEmpty() || date.isEmpty() || imageUrl == null) {
                Toast.makeText(AdmissionForm.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("name", name);
            hashMap.put("phone", phone);
            hashMap.put("email", email);
            hashMap.put("course", course);
            hashMap.put("date", date);
            hashMap.put("imageURL", imageUrl);

            databaseReference.child("user1").setValue(hashMap)
                    .addOnSuccessListener(aVoid -> {
                Toast.makeText(AdmissionForm.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                // Navigate to profile_activity after successful data insertion
                Intent intent = new Intent(AdmissionForm.this, profile_activity.class);
                startActivity(intent);
               // finish(); // Optional: finish AdmissionForm activity if you don't want to return to it
            })
                    .addOnFailureListener(e -> Toast.makeText(this, "Data Not Inserted", Toast.LENGTH_SHORT).show());

        });
    }

    private void showDatePicker() {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                (view, selectedYear, selectedMonth, selectedDay) -> {
                    String selectedDate = selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear;
                    datetextView.setText(selectedDate);
                },
                year, month, day
        );
        datePickerDialog.show();
    }

    private void openFileChooser() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    private void openCamera() {
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (cameraIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(cameraIntent, CAMERA_REQUEST);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null) {
            if (requestCode == PICK_IMAGE_REQUEST) {
                imageUri = data.getData();
                buttonUpload.setImageURI(imageUri);
            } else if (requestCode == CAMERA_REQUEST) {
                Bitmap photo = (Bitmap) data.getExtras().get("data");
                buttonUpload.setImageBitmap(photo);
                imageUri = getImageUri(photo);
            }
        }
    }

    private Uri getImageUri(Bitmap bitmap) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(getContentResolver(), bitmap, "Title", null);
        return Uri.parse(path);
    }

    private byte[] bitmapToByteArray(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        return stream.toByteArray();
    }
}
