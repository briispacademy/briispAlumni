package com.example.briispalumni;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends AppCompatActivity {

    private EditText FullName;
    private EditText mSignupUsername;
    private EditText mSignupPassword;
    private EditText mConfirmPassword;
    private Button mSignupButton;
    private DatabaseHelper mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // Initialize views
        FullName = findViewById(R.id.fullName);
        mSignupUsername = findViewById(R.id.signupUsername);
        mSignupPassword = findViewById(R.id.signupPassword);
        mConfirmPassword = findViewById(R.id.confirmPassword);
        mSignupButton = findViewById(R.id.signupButton);

        // Initialize database
        mDatabase = new DatabaseHelper(this);

        mSignupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullName = FullName.getText().toString();
                String username = mSignupUsername.getText().toString();
                String password = mSignupPassword.getText().toString();
                String confirmPassword = mConfirmPassword.getText().toString();

                if (validateInput(fullName, username, password, confirmPassword)) {
                    // Save user data to SQLite database
                    boolean isInserted = mDatabase.insertData(username, password);
                    if (isInserted) {
                        Toast.makeText(Signup.this, "Registration successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Signup.this, Login.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(Signup.this, "Error registering user", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private boolean validateInput(String fullName, String username, String password, String confirmPassword) {
        if (fullName.isEmpty()) {
            FullName.setError("Full name cannot be empty");
            return false;
        }
        if (username.isEmpty()) {
            mSignupUsername.setError("Username cannot be empty");
            return false;
        }
        if (password.isEmpty()) {
            mSignupPassword.setError("Password cannot be empty");
            return false;
        }
        if (!password.equals(confirmPassword)) {
            mConfirmPassword.setError("Passwords do not match");
            return false;
        }
        return true;
    }
}
