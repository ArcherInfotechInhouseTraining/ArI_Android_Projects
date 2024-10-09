package com.ArcherInfotech.tutionapp;


import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.ArcherInfotech.tutionapp.SQLiteDB.DBHelper;
import com.ArcherInfotech.tutionapp.SQLiteDB.DBHelper1;

import java.io.ByteArrayOutputStream;
import java.util.Calendar;

public class AdmissionForm extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;
    private static final int CAMERA_REQUEST = 2;

    //    private ImageView imageViewProfile;
    private Uri imageUri;
    TextView datetextView;
    Spinner courselevel;
    ImageView buttonUpload;
    private DBHelper1 dbHelper;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admission_form);

//        imageViewProfile = findViewById(R.id.imageViewProfile);
        EditText editFullName = findViewById(R.id.full_name);
        EditText editEmail = findViewById(R.id.email);
        EditText editPhone = findViewById(R.id.phone);
         buttonUpload = findViewById(R.id.uploadfProfile);
        datetextView = findViewById(R.id.dateTextView);
        courselevel = findViewById(R.id.level);
        AppCompatButton buttonRegister = findViewById(R.id.submit_button);

        dbHelper = new DBHelper1(this);

        // Set up the ArrayAdapter for Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.course_list, R.layout.spinner_selected_item);

        adapter.setDropDownViewResource(R.layout.spinner_item);


        courselevel.setAdapter(adapter);


        courselevel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if (position == 0) {
                    // The user selected the prompt item "Select a course"
                } else {
                    // Handle course selection
                    String selectedCourse = parentView.getItemAtPosition(position).toString();
                    Toast.makeText(AdmissionForm.this, "Selected: " + selectedCourse, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Do nothing here
            }
        });

        // Initialize the date picker
        datetextView.setOnClickListener(v -> showDatePicker());

        buttonUpload.setOnClickListener(v -> openFileChooser());

        buttonRegister.setOnClickListener(v -> {
            String name = editFullName.getText().toString();
            String phone = editPhone.getText().toString();
            String email = editEmail.getText().toString();

            if (name.isEmpty() || phone.isEmpty() || email.isEmpty() || imageUri == null) {
                Toast.makeText(AdmissionForm.this, "Please fill all fields and upload an image", Toast.LENGTH_SHORT).show();
            } else {
                Bitmap bitmap = null;
                try {
                    bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUri);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                byte[] imageInBytes = bitmapToByteArray(bitmap);
                dbHelper.insertProfile(name, phone, email, imageInBytes);

                Intent intent = new Intent(getApplicationContext(), profile_activity.class);
                intent.putExtra("NAME", name);
                intent.putExtra("EMAIL", email);
                intent.putExtra("PHONE", phone);
                startActivity(intent);
            }
        });

    }
    private void showDatePicker() {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        // Create DatePickerDialog
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                (view, selectedYear, selectedMonth, selectedDay) -> {
                    String selectedDate = selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear;
                    datetextView.setText(selectedDate); // Set selected date on TextView
                },
                year, month, day
        );


        datePickerDialog.show();
    }


    private void showImageSourceOptions() {
        // Option to choose either Camera or Gallery
        CharSequence[] options = {"Take Photo", "Choose from Gallery"};
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(AdmissionForm.this);
        builder.setTitle("Select an Option");

        builder.setItems(options, (dialog, item) -> {
            if (options[item].equals("Take Photo")) {
                openCamera();
            } else if (options[item].equals("Choose from Gallery")) {
                openFileChooser();
            }
        });

        builder.show();
    }

    private void openCamera() {
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (cameraIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(cameraIntent, CAMERA_REQUEST);
        }
    }







    private void openFileChooser() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null) {
            if (requestCode == PICK_IMAGE_REQUEST) {
                // Image selected from gallery
                imageUri = data.getData();
                buttonUpload.setImageURI(imageUri); // Display selected image in ImageView
            } else if (requestCode == CAMERA_REQUEST) {
                // Image captured from camera
                Bitmap photo = (Bitmap) data.getExtras().get("data");
                buttonUpload.setImageBitmap(photo); // Display captured image in ImageView

                // Convert Bitmap to Uri
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

