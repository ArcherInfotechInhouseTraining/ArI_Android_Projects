package com.ArcherInfotech.tutionapp;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class user_Registration extends Fragment {

    private FragmentManager fragmentManager;
    private EditText editName, editPassword, editCpassword, editEmail;
    private CheckBox terms;
    private Button registerBtn;
    FirebaseAuth mAuth;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public user_Registration() {
        // Required empty public constructor
    }

    public static user_Registration newInstance(String param1, String param2) {
        user_Registration fragment = new user_Registration();
        Bundle args = new Bundle();
        args.putString(fragment.mParam1, param1);
        args.putString(fragment.mParam2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(mParam1);
            mParam2 = getArguments().getString(mParam2);
        }
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user__registration, container, false);

        // Initialize UI components

        editName = view.findViewById(R.id.editfullname);
        editEmail = view.findViewById(R.id.editemail);
        editPassword = view.findViewById(R.id.password);
        editCpassword = view.findViewById(R.id.confirmpassword);
        terms = view.findViewById(R.id.terms);
        registerBtn = view.findViewById(R.id.registerbtn);
        TextView signin = view.findViewById(R.id.signin);
        fragmentManager = getParentFragmentManager();


        // Set up the register button click listener
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = editName.getText().toString();
                String useremail = editEmail.getText().toString();
                String userPassword = editPassword.getText().toString();
                String userCpassword = editCpassword.getText().toString();


                // Check if terms are accepted
                if (TextUtils.isEmpty(username) || TextUtils.isEmpty(useremail) ||
                        TextUtils.isEmpty(userPassword) || TextUtils.isEmpty(userCpassword)) {
                    Toast.makeText(getContext(), "Please fill all the fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (userPassword.length() < 6) {
                    Toast.makeText(getContext(), "Password is too short", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!userPassword.equals(userCpassword)) {
                    Toast.makeText(getContext(), "Passwords do not match", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Use Firebase push() to create a unique user entry
                mAuth.createUserWithEmailAndPassword(useremail, userPassword).addOnCompleteListener(requireActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(getContext(), "Registration  successfull.",
                                    Toast.LENGTH_SHORT).show();

                            fragmentManager.beginTransaction()
                                    .replace(R.id.frame, new User_Login())
                                    .addToBackStack(null)  // Add to backstack so user can go back
                                    .commit();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(getContext(), "Registration failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        // Set up the sign-in button click listener
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction()
                        .replace(R.id.frame, new User_Login())
                        .addToBackStack(null)  // Add to backstack so user can go back
                        .commit();
            }
        });
        // Inflate the layout for this fragment
        return view;
    }
}
