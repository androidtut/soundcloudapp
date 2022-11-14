package com.example.soundcloudapp;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomnav;
    LinearLayout container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomnav = findViewById(R.id.bottomnav);
        container = findViewById(R.id.container);

        showhome();

        bottomnav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        showhome();
                        break;
                    case R.id.setting:
                        SettingFragment sFragment = new SettingFragment();
                        FragmentTransaction stransaction = getSupportFragmentManager().beginTransaction();
                        stransaction.replace(R.id.container,sFragment);
                        stransaction.commit();
                        break;
                    case R.id.location:
                        LocationFragment lFragment = new LocationFragment();
                        FragmentTransaction ltransaction = getSupportFragmentManager().beginTransaction();
                        ltransaction.replace(R.id.container,lFragment);
                        ltransaction.commit();
                        break;
                    case R.id.search:
                        SearchFragment seFragment = new SearchFragment();
                        FragmentTransaction setransaction = getSupportFragmentManager().beginTransaction();
                        setransaction.replace(R.id.container,seFragment);
                        setransaction.commit();
                        break;
                }
                return false;
            }
        });

    }

    private void showhome() {
        HomeFragment homeFragment = new HomeFragment();
        FragmentTransaction htransaction = getSupportFragmentManager().beginTransaction();
        htransaction.replace(R.id.container,homeFragment);
        htransaction.commit();
    }
}