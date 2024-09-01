package com.example.aarogyaaadhaara;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class login extends AppCompatActivity {

    private String chosenRole;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login); // Reference your login layout file

        // Retrieve the chosen role from the previous activity
        chosenRole = getIntent().getStringExtra("chosenRole");

        Button loginButton = findViewById(R.id.chooseButton);

        // Handle login button click
        loginButton.setOnClickListener(v -> {
            if (chosenRole.equals("Doctor")) {
                // Navigate to homepage_d
                Intent intent = new Intent(login.this, homepage.class);
                startActivity(intent);
            } else if (chosenRole.equals("Patient")) {
                // Navigate to homepage_p
                Intent intent = new Intent(login.this, homepage_p.class);
                startActivity(intent);
            }
        });
    }

    public void onClick_signup(View v) {
        Intent intent = new Intent(login.this, signup.class);
        startActivity(intent);
    }
}