package com.example.briispalumni;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class StudentListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Fetch the students for the selected course (this is just an example)
        List<Student> students = new ArrayList<>();
        students.add(new Student("Mr Zimba", "Studied App development from September to December 2023", 2022, "Spring 2022",
                "https://web.facebook.com/photo/?fbid=1742642962547782&set=a.421956681283090", "https://web.facebook.com/billypeter.munyenyembe", "https://www.linkedin.com/in/billy-peterlennards-munyenyembe-8776aa220/", "https://www.linkedin.com/in/billy-peterlennards-munyenyembe-8776aa220/"));
        // Add more students as needed

        StudentAdapter adapter = new StudentAdapter(students, this);
        recyclerView.setAdapter(adapter);
    }
}
