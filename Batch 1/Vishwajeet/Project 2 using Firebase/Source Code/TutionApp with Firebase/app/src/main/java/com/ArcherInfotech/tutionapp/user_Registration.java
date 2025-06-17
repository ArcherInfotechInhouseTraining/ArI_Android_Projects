package com.ArcherInfotech.tutionapp;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link user_Registration#newInstance} factory method to
 * create an instance of this fragment.
 */
public class user_Registration extends Fragment {

    private FragmentManager fragmentManager;
    private EditText editName, editPassword, editCpassword, editEmail;
    private CheckBox terms;
    private Button registerBtn;
    private FirebaseAuth mAuth;
//    private ProgressBar progressBar;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user__registration, container, false);

        editName = view.findViewById(R.id.editfullname);
        editEmail = view.findViewById(R.id.editemail);
        editPassword = view.findViewById(R.id.password);
        editCpassword = view.findViewById(R.id.confirmpassword);
        terms = view.findViewById(R.id.terms);
        registerBtn = view.findViewById(R.id.registerbtn);
        //progressBar = view.findViewById(R.id.progressBar);
        TextView signin = view.findViewById(R.id.signin);
        fragmentManager = getParentFragmentManager();

        registerBtn.setOnClickListener(v -> {
            String username = editName.getText().toString();
            String useremail = editEmail.getText().toString();
            String userPassword = editPassword.getText().toString();
            String userCpassword = editCpassword.getText().toString();

            if (!terms.isChecked()) {
                Toast.makeText(getContext(), "Please accept terms and conditions", Toast.LENGTH_SHORT).show();
                return;
            }

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

//            progressBar.setVisibility(View.VISIBLE);

            mAuth.createUserWithEmailAndPassword(useremail, userPassword)
                    .addOnCompleteListener(requireActivity(), new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
//                            progressBar.setVisibility(View.GONE);
                            if (task.isSuccessful()) {
                                Toast.makeText(getContext(), "Registration Successful", Toast.LENGTH_SHORT).show();
                            } else {
                                Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                Toast.makeText(getContext(), "Registration failed.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentManager.beginTransaction()
                        .replace(R.id.frame, new User_Login())
                        .addToBackStack(null)
                        .commit();
            }
        });

        return view;
    }
}
