package com.ArcherInfotech.tutionapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ArcherInfotech.tutionapp.Adaptor.BankListAdapter;
import com.ArcherInfotech.tutionapp.Modal.BankList;

import java.util.ArrayList;
import java.util.List;

public class NetBanking extends AppCompatActivity {

    RecyclerView recyclerView;
    BankListAdapter adapter;
    List<BankList> stringList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_net_banking);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        stringList = new ArrayList<>();
        stringList.add(new BankList("SBI", R.drawable.sbi));
        stringList.add(new BankList("CITI", R.drawable.citibank_logo));
        stringList.add(new BankList("BOB", R.drawable.baroda));
        stringList.add(new BankList("Canara", R.drawable.canara));
        stringList.add(new BankList("ICICI", R.drawable.icici));
        stringList.add(new BankList("AXIs", R.drawable.axis));
        stringList.add(new BankList("SBM", R.drawable.sbm_logo));




        adapter = new BankListAdapter(stringList);
        recyclerView.setAdapter(adapter);

    }
}