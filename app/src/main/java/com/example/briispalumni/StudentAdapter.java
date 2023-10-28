package com.example.briispalumni;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;


public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    private List<Student> students;
    private Context context;

    public StudentAdapter(List<Student> students, Context context) {
        this.students = students;
        this.context = context;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student student = students.get(position);
        holder.tvName.setText(student.getName());
        holder.tvDescription.setText(student.getDescription());
        holder.tvYear.setText(String.valueOf(student.getYear()));
        holder.tvPeriodOfStudy.setText(student.getPeriodOfStudy());

        // Load image using Glide
        Glide.with(context)
                .load(student.getImageUrl())
                .into(holder.imageView);

        // TODO: Add click listeners for social media links if needed
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public static class StudentViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView tvName, tvDescription, tvYear, tvPeriodOfStudy;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            tvName = itemView.findViewById(R.id.tvName);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvYear = itemView.findViewById(R.id.tvYear);
            tvPeriodOfStudy = itemView.findViewById(R.id.tvPeriodOfStudy);
        }
    }
}