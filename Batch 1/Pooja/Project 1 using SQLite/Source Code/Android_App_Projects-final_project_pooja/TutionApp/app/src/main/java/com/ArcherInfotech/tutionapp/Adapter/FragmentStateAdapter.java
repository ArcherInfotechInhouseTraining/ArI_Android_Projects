package com.ArcherInfotech.tutionapp.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.ArcherInfotech.tutionapp.AboutUs;
import com.ArcherInfotech.tutionapp.Faculty_info;
import com.ArcherInfotech.tutionapp.getting_started_fragment;
import com.ArcherInfotech.tutionapp.howto;


public class FragmentStateAdapter extends androidx.viewpager2.adapter.FragmentStateAdapter {
    public FragmentStateAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position) {
            case 0:
                return new getting_started_fragment();
            case 1:
                return new Faculty_info();
            case 2:
                return new howto();
            case 3:
                return new AboutUs();
            default:
                return new Fragment();  // Default case
        }

    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
