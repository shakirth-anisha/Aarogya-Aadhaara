package com.example.aarogyaaadhaara;

import android.os.Bundle;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import android.view.MenuItem;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class homepage_add extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;
    FirstFragment1 firstFragment;
    SecondFragment secondFragment;
    ThirdFragment thirdFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.home);

        // Initialize fragments
        firstFragment = new FirstFragment1();
        secondFragment = new SecondFragment();
        thirdFragment = new ThirdFragment();

        // Load the default fragment (home)
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.flFragment, firstFragment)
                .commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment selectedFragment = null;
        int itemId = item.getItemId();

        if (itemId == R.id.home) {
            selectedFragment = firstFragment;
        } else if (itemId == R.id.pills) {
            selectedFragment = secondFragment;
        } else if (itemId == R.id.user) {
            selectedFragment = thirdFragment;
        } else {
            Log.e("FragmentError", "Unknown menu item selected");
            return false;
        }

        if (selectedFragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flFragment, selectedFragment)
                    .commit();
        } else {
            Log.e("FragmentError", "Fragment is null");
            return false;
        }

        return true;
    }
}
