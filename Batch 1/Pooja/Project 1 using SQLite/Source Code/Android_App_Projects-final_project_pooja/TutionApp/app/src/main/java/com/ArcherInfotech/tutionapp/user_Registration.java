package com.ArcherInfotech.tutionapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ArcherInfotech.tutionapp.SQLiteDB.DBHelper;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link user_Registration#newInstance} factory method to
 * create an instance of this fragment.
 */
public class user_Registration extends Fragment {
    private FragmentManager fragmentManager;
    EditText editName,editPassword,editCpassword,editEmail;
    CheckBox terms;
    Button registerBtn;
    DBHelper dbHelper;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public user_Registration() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment user_Registration.
     */
    // TODO: Rename and change types and number of parameters
    public static user_Registration newInstance(String param1, String param2) {
        user_Registration fragment = new user_Registration();
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

        View view = inflater.inflate(R.layout.fragment_user__registration, container, false);

        editName = view.findViewById(R.id.editfullname);
        editEmail= view.findViewById(R.id.editemail);
        editPassword = view.findViewById(R.id.password);
        editCpassword = view.findViewById(R.id.confirmpassword);
        terms = view.findViewById(R.id.terms);
        registerBtn = view.findViewById(R.id.registerbtn);
        dbHelper = new DBHelper(getContext());
        TextView signin = view.findViewById(R.id.signin);
        fragmentManager = getParentFragmentManager();


        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if(!terms.isChecked()) {
                    Toast.makeText(getContext().getApplicationContext(), "Please accept terms and conditions", Toast.LENGTH_SHORT).show();
                }
                String username = editName.getText().toString();
                String useremail = editEmail.getText().toString();
                String userPassword = editPassword.getText().toString();
                String userCpassword = editCpassword.getText().toString();


                if(username.isEmpty() || useremail.isEmpty() || userPassword.isEmpty() || userCpassword.isEmpty() ){
                    Toast.makeText(getContext().getApplicationContext(),    "plase fill all the fields", Toast.LENGTH_SHORT).show();
                }else{
                    if(userPassword.equals(userCpassword)){
                            Boolean checkuser =dbHelper.checkpassword(username,userPassword);
                            if(!checkuser){
                                        Boolean insert = dbHelper.insertData(username,useremail,userPassword);

                                        if(insert){
                                            Toast.makeText(requireContext().getApplicationContext(), "Registered Successfully",Toast.LENGTH_SHORT).show();
                                            editName.setText("");
                                            editEmail.setText("");
                                            editPassword.setText("");
                                            editCpassword.setText("");

                                            fragmentManager.beginTransaction()
                                                    .replace(R.id.frame, new User_Login())
                                                    .addToBackStack(null)  // Add to backstack so user can go back
                                                    .commit();
                                        }
                            }else{
                                Toast.makeText(requireContext().getApplicationContext(),"User Alreay Exist",Toast.LENGTH_SHORT).show();

                            }
                    }else {
                        Toast.makeText(requireContext().getApplicationContext(),"Password does not matching",Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });



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