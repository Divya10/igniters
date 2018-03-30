package com.example.divya.igniters;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    DrawerLayout d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        d = findViewById(R.id.d1);
        Toolbar toolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);
        final android.support.v7.app.ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_dehaze_black_24dp);
        NavigationView navigationView = findViewById(R.id.nav_view);
        Fragment fragment1;
        fragment1 = new BlankFragment2();
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.f1, fragment1)
                .commit();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setChecked(true);

                d.closeDrawers();
                Fragment fragment = null;
                FragmentManager fragmentManager = getFragmentManager();
                if (item.getTitle().toString().equalsIgnoreCase("Login")) {
                     actionBar.setTitle("Login");

                } else if (item.getTitle().toString().equalsIgnoreCase("Signup")) {
                    actionBar.setTitle("Signup");

                } else if (item.getTitle().toString().equalsIgnoreCase("Nearby Hospital")) {
                    actionBar.setTitle("Nearby Hospitals");

                } else if (item.getTitle().toString().equalsIgnoreCase("About Dengue")) {
                    actionBar.setTitle("About Dengue");
                    fragment = new AboutDengue();
                } else if (item.getTitle().toString().equalsIgnoreCase("Prevention")) {
                    actionBar.setTitle("Prevention");
                    fragment = new BlankFragment();
                } else {
                    actionBar.setTitle("Our Team");
                    fragment = new OurTeam();
                }
                fragmentManager.beginTransaction()
                        .replace(R.id.f1, fragment)
                        .commit();

                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (d.isDrawerOpen(GravityCompat.START)) {
            d.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



@Override
public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
        case android.R.id.home:
            d.openDrawer(GravityCompat.START);
            return true;
    }
    return super.onOptionsItemSelected(item);
}

}