package com.example.briispalumni;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // This method will be called when a button is clicked
    public void openCourses(View view) {
        Intent intent = new Intent(this, CoursesActivity.class);
        String category = "";

        int id = view.getId();
        if (id == R.id.btnKids) {
            category = "Kids";
        } else if (id == R.id.btnAdults) {
            category = "Adults";
        }

        intent.putExtra("CATEGORY", category);
        startActivity(intent);
    }
}