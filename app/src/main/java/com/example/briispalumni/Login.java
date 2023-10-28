package com.example.briispalumni;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.database.Cursor;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class Login extends AppCompatActivity {

    private EditText mUsername;
    private EditText mPassword;
    private Button mLoginButton;
    private TextView mSignupLink;
    private DatabaseHelper mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize views
        mUsername = findViewById(R.id.username);
        mPassword = findViewById(R.id.password);
        mLoginButton = findViewById(R.id.loginButton);
        mSignupLink = findViewById(R.id.signupLink);

        // Initialize database
        mDatabase = new DatabaseHelper(this);

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = mUsername.getText().toString();
                String password = mPassword.getText().toString();

                if (validateInput(username, password)) {
                    // Check if user exists in SQLite database
                    Cursor user = mDatabase.getData(username);
                    if (user.getCount() > 0) {
                        user.moveToFirst();
                        int passwordColumnIndex = user.getColumnIndex("PASSWORD");
                        if (passwordColumnIndex != -1) {
                            String storedPassword = user.getString(passwordColumnIndex);
                            if (password.equals(storedPassword)) {
                                // Successful Login, proceed to main app screen
                                Intent  intent = new Intent(Login.this, MainActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(Login.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(Login.this, "Database error", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(Login.this, "User not found", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        mSignupLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect to Signup page
                Intent a = new Intent(Login.this, Signup.class);
                startActivity(a);
            }
        });
    }


    private boolean validateInput(String username, String password) {
        if (username.isEmpty()) {
            mUsername.setError("Username cannot be empty");
            return false;
        }
        if (password.isEmpty()) {
            mPassword.setError("Password cannot be empty");
            return false;
        }
        return true;
    }
}
