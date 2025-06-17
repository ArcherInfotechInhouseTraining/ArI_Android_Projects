package com.ArcherInfotech.tutionapp.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.ArcherInfotech.tutionapp.AboutUs;
import com.ArcherInfotech.tutionapp.Faculty_info;
import com.ArcherInfotech.tutionapp.Student_image2;
import com.ArcherInfotech.tutionapp.Student_image3;
import com.ArcherInfotech.tutionapp.getting_started_fragment;
import com.ArcherInfotech.tutionapp.howto;
import com.ArcherInfotech.tutionapp.student_image1;

public class ImageSliderAdapter  extends androidx.viewpager2.adapter.FragmentStateAdapter {


    public ImageSliderAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }










    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position) {
            case 0:
                return new student_image1();
            case 1:
                return new Student_image2();
            case 2:
                return new Student_image3();

            default:
                return new Fragment();  // Default case
        }

    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
