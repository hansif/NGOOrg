package com.example.ngoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    Fragment selectedFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// HH:mm:ss");
        String reg_date = df.format(c.getTime());
        showtoast("Currrent Date Time : "+reg_date);

        c.add(Calendar.DATE, 3);  // number of days to add
        String end_date = df.format(c.getTime());
        showtoast("end Time : "+end_date);
        selectedFragment = new EventsFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container, selectedFragment).commit();

        bottomNavigationView = findViewById(R.id.main_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId()) {
                    case R.id.nav_events:
                        selectedFragment = new EventsFragment();
                        break;
                    case R.id.nav_search_ngo:
                        selectedFragment = new NGOListFragment();
                        break;
                    case R.id.nav_contact:
                        selectedFragment = new ContactFragment();
                        break;
                    case R.id.nav_profile:
                        selectedFragment = new ProfileFragment();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container, selectedFragment).commit();
                return true;
            }
        });
    }

    private void showtoast(String s) {
    }
}