package com.ArcherInfotech.tutionapp;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class User_Login extends Fragment {

    private FragmentManager fragmentManager;
    private FirebaseAuth mAuth;

    private EditText editUsername, editPassword;
    private AppCompatButton loginBtn, cancelBtn;
    private TextView dont;

    public User_Login() {
        // Required empty public constructor
    }


    public static User_Login newInstance(String param1, String param2) {
        User_Login fragment = new User_Login();
        Bundle args = new Bundle();
        args.putString("param1", param1);
        args.putString("param2", param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user__login, container, false);

       dont = view.findViewById(R.id.dont);
       loginBtn = view.findViewById(R.id.loginbtn);
       cancelBtn = view.findViewById(R.id.cancel);
       editUsername = view.findViewById(R.id.editusername);
       editPassword = view.findViewById(R.id.editpassword);

        fragmentManager = getParentFragmentManager();

        String text = "Don't have an account? Sign up";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(text);
        int start = text.indexOf("Sign up");
        int end = start + "Sign up".length();

        spannableStringBuilder.setSpan(new StyleSpan(Typeface.BOLD), start, end, 0);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.RED), start, end, 0);

        dont.setText(spannableStringBuilder);

        // Navigate to the registration fragment
        dont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction()
                        .replace(R.id.frame, new user_Registration())
                        .addToBackStack(null)
                        .commit();
            }
        });

        // Login button logic
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editUsername.getText().toString().trim();
                String password = editPassword.getText().toString().trim();

                if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
                    Toast.makeText(getActivity(), "Please fill all the fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length() < 6) {
                    Toast.makeText(getActivity(), "Password should be at least 6 characters", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Authenticate using Firebase
                mAuth.signInWithEmailAndPassword(username, password)
                        .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {

                                    Toast.makeText(getActivity(), "Log In Successful", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(getActivity(), HomePageActivity.class));
                                } else {
                                    Log.w(TAG, "signInWithEmail:failure", task.getException());
                                    Toast.makeText(getActivity(), "Log in  failed.", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

        // Cancel button logic
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext().getApplicationContext(), GettingStart.class));
            }
        });
        return view;
    }
}
