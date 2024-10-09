package com.ArcherInfotech.tutionapp.Adaptor;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ArcherInfotech.tutionapp.Cource_Details;
import com.ArcherInfotech.tutionapp.Listener.ItemClickListner;
import com.ArcherInfotech.tutionapp.Modal.Cources;
import com.ArcherInfotech.tutionapp.R;
import com.ArcherInfotech.tutionapp.cource_list;

import org.w3c.dom.Text;

import java.util.List;

public class CourceAdaptor extends RecyclerView.Adapter<CourceAdaptor.ViewHolder>{

    private final String[] courses;
    private final String[] images;
    private final String[] duration;
    private final String[] instructors;
    private final String[][] professions;
    private final String[][] syllabuses;
    private final String[] fees;

    public CourceAdaptor(String[] courses,String[] images, String[] duration, String[] instructors,String[][] professions,String[][] syllabuses,String[] fees)
    {
        this.courses=courses;
        this.images=images;
        this.duration=duration;
        this.instructors=instructors;
        this.professions=professions;
        this.syllabuses=syllabuses;
        this.fees=fees;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView courcetextview;
        private final TextView durationtext;
        private final TextView instructortext;
        private final TextView professiontext;
        private final ImageView imageView;
        private final ImageView courcebgimg;
        private final TextView feestext;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            courcetextview = itemView.findViewById(R.id.courcename);
            durationtext = itemView.findViewById(R.id.durationtext);
            instructortext =itemView.findViewById(R.id.instructername);
            professiontext=itemView.findViewById(R.id.instructerinfo);
            imageView = itemView.findViewById(R.id.courceimg);
            courcebgimg=itemView.findViewById(R.id.courcebg);
            feestext=itemView.findViewById(R.id.paynow);
        }

        public TextView getCourcetextview() {return courcetextview;}
        public TextView getDurationtext() {return durationtext;}
        public TextView getInstructortext() {return instructortext;}
        public TextView getProfessiontext() {return professiontext;}
        public ImageView getImageView() {return imageView;}
        public ImageView getCourcebgimg() {return courcebgimg;}
        public TextView getFeestext() {return feestext;}
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cource_cards, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        // Bind data to the ViewHolder
        viewHolder.getCourcetextview().setText(courses[position]);
        viewHolder.getDurationtext().setText(duration[position]);

        String courceImg = images[position].trim();  // Remove any accidental spaces
        // Log the image name for debugging
        Log.d("ImageName", "Image name at position " + position + ": " + courceImg);
        // Use getIdentifier to dynamically get the drawable resource ID
        int imageResId = viewHolder.itemView.getContext().getResources().getIdentifier(courceImg, "drawable", viewHolder.itemView.getContext().getPackageName());
        // Log the resource ID for debugging
        Log.d("ImageResourceID", "Resource ID for " + courceImg + ": " + imageResId);
        // If image resource is found, load it; otherwise load a default image
        if (imageResId != 0) {
            viewHolder.getImageView().setImageResource(imageResId);  // Load image from drawable
        } else {
            viewHolder.getImageView().setImageResource(R.drawable.c);  // Fallback image
        }

//        set image background
//        String imagebg = cource_img_bg[position].trim();
//        // Remove any accidental spaces
//        Log.d("ImageName", "Image name at position " + position + ": " + imagebg);
//        // Use getIdentifier to dynamically get the drawable resource ID
//        int imagebgResId = viewHolder.itemView.getContext().getResources().getIdentifier(imagebg, "drawable", viewHolder.itemView.getContext().getPackageName());
//        // Log the resource ID for debugging
//        Log.d("ImageResourceID", "Resource ID for " + imagebg + ": " + imagebgResId);
//        // If image resource is found, load it; otherwise load a default image
//        if (imagebgResId != 0) {
//            viewHolder.getCourcebgimg().setImageResource(imagebgResId);  // Load image from drawable
//        }
//        else {
//            viewHolder.getCourcebgimg().setImageResource(R.drawable.c);  // Fallback image
//        }


        // Handle item click to open CourseDetailsActivity
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(v.getContext(), Cource_Details.class);
                intent.putExtra("course", courses[position]);
                intent.putExtra("instructor", instructors[position]);
                intent.putExtra("profession", professions[position]);
                intent.putExtra("fees", fees[position]);

                // Passing the syllabi for the specific course as an array to the next activity
                intent.putExtra("syllabus", syllabuses[position]);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount(){return courses.length;}
}
