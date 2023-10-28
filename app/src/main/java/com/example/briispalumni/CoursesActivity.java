package com.example.briispalumni;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.briispalumni.R;

public class CoursesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);

        String category = getIntent().getStringExtra("CATEGORY");
        Button btnCourse1 = findViewById(R.id.btnCourse1);
        Button btnCourse2 = findViewById(R.id.btnCourse2);

        if ("Kids".equals(category)) {
            btnCourse1.setText("Robotics");
            btnCourse2.setText("Android Studio");
        } else if ("Adults".equals(category)) {
            btnCourse1.setText("Web Development");
            btnCourse2.setText("Android Development");
        }
    }

    public void openStudentList(View view) {
        // Here you would pass the selected course to the StudentListActivity
        Intent intent = new Intent(this, StudentListActivity.class);
        startActivity(intent);
    }
}
