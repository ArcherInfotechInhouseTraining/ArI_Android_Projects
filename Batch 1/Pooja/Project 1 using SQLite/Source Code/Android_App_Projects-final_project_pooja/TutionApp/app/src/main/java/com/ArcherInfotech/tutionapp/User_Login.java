package com.ArcherInfotech.tutionapp;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.ArcherInfotech.tutionapp.SQLiteDB.DBHelper;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link User_Login#newInstance} factory method to
 * create an instance of this fragment.
 */
public class User_Login extends Fragment {
    private FragmentManager fragmentManager;    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public User_Login() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment User_Login.
     */
    // TODO: Rename and change types and number of parameters
    public static User_Login newInstance(String param1, String param2) {
        User_Login fragment = new User_Login();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user__login, container, false);

        TextView dont = view.findViewById(R.id.dont);
        AppCompatButton loginbtn = view.findViewById(R.id.loginbtn);

        AppCompatButton cancelbtn= view.findViewById(R.id.cancel);
        EditText editusername = view.findViewById(R.id.editusername);
        EditText editpassword = view.findViewById(R.id.editpassword);
        fragmentManager = getParentFragmentManager();


        String text= "Don't have an account? Sign up";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(text);
        int start = text.indexOf("Sign up");
        int end = start +"Sign up".length();

        spannableStringBuilder.setSpan(new StyleSpan(Typeface.BOLD),start,end,0);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.RED),start,end,0);


        dont.setText(spannableStringBuilder);



        dont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Replace the current fragment with the registration fragment
                fragmentManager.beginTransaction()
                        .replace(R.id.frame, new user_Registration())
                        .addToBackStack(null)  // Add to backstack so user can go back
                        .commit();
            }
        });


        DBHelper dbHelper = new DBHelper(getContext());
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editusername.getText().toString();
                String password = editpassword.getText().toString();
                if(username.equals("") || password.equals("")){
                    editusername.setError("Please enter all the fields");
                }else {
                    Boolean checkPassword =dbHelper.checkpassword(username,password);
                    if(checkPassword){
                        Intent intent = new Intent(getContext(), AdmissionForm.class);
                        startActivity(intent);
                    }else {
                        editusername.setError("Invalid Credentials");
                        editpassword.setError("Invalid Credentials");
                    }
                }
            }
        });
        
        
        cancelbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(getContext().getApplicationContext(),GettingStart.class));
            }
        });
        // Inflate the layout for this fragment
        return view;
    }
}