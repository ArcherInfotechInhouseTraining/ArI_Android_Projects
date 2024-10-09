package com.ArcherInfotech.tutionapp.Adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ArcherInfotech.tutionapp.Modal.BankList;
import com.ArcherInfotech.tutionapp.R;

import java.util.List;
import java.util.zip.Inflater;

public class BankListAdapter extends RecyclerView.Adapter<BankListAdapter.BankListViewHolder> {

    List<BankList> bankList;

    public BankListAdapter(List<BankList> bankList){
        this.bankList = bankList;
    }

    @NonNull
    @Override
    public BankListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.banklist, parent, false);

        return new BankListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BankListViewHolder holder, int position) {

        BankList item = bankList.get(position);
        holder.textView.setText(item.getBankName());
        holder.imageView.setImageResource(item.getBankImg());



    }

    @Override
    public int getItemCount() {

        if (bankList != null)
        {
            return bankList.size();
        }
        return 0;
    }

    public static class BankListViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        ImageView imageView;


        public BankListViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.bankList_textview);
            imageView = itemView.findViewById(R.id.bankList_imgview);
        }
    }


}
