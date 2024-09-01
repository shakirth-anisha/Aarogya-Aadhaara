package com.example.aarogyaaadhaara;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

public class choose_p extends AppCompatActivity {

    private int[] images = {R.drawable.patient, R.drawable.doc}; // Replace with your actual image resources
    private String[] roles = {"Patient", "Doctor"}; // Corresponding roles
    private ViewPager2 viewPager;
    private String chosenRole;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose); // Reference the correct XML layout file

        viewPager = findViewById(R.id.viewPager);
        Button chooseButton = findViewById(R.id.chooseButton);

        // Set up ViewPager with the adapter
        ImageAdapter adapter = new ImageAdapter(images);
        viewPager.setAdapter(adapter);

        // Handle button click
        chooseButton.setOnClickListener(v -> {
            int currentItem = viewPager.getCurrentItem();
            chosenRole = roles[currentItem]; // Store the selected role
            System.out.println(chosenRole);
            Toast.makeText(choose_p.this, "You have chosen: " + chosenRole, Toast.LENGTH_SHORT).show();

            // Pass the chosen role to the next activity
            Intent intent;
            if ("Patient".equals(chosenRole)) {
                intent = new Intent(choose_p.this, login_p.class); // Navigate to login_p for Patient
            } else {
                intent = new Intent(choose_p.this, login.class); // Navigate to login for Doctor
            }
            intent.putExtra("chosenRole", chosenRole);
            startActivity(intent);
        });

    }
}