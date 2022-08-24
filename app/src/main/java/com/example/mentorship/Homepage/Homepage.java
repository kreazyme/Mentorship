package com.example.mentorship.Homepage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.mentorship.Mentor.MentorFragment;
import com.example.mentorship.Profile.ProfileFragment;
import com.example.mentorship.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Homepage extends AppCompatActivity {
   private BottomNavigationView botBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        botBar = findViewById(R.id.homepage_bottom_bar);
        botBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.homepage_bottom_bar_mentor:
                        Toast.makeText(Homepage.this, "Mentor", Toast.LENGTH_SHORT).show();
                        changeFragment(new MentorFragment());
                        break;
                    case R.id.homepage_bottom_bar_profile:
                        Toast.makeText(Homepage.this, "Profile", Toast.LENGTH_SHORT).show();
                        changeFragment(new ProfileFragment());
                        break;
                }
                return true;
            }
        });
    }
    public void changeFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.homepage_framelayout,fragment);
        fragmentTransaction.commit();

    }
}