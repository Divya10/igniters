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
    //android.support.v7.app.ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        d = findViewById(R.id.d1);
        Toolbar toolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);
        android.support.v7.app.ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_dehaze_black_24dp);
//        getSupportActionBar().setHomeButtonEnabled(true);
        NavigationView navigationView = findViewById(R.id.nav_view);
        Fragment fragment1;
        fragment1 = new BlankFragment2();
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.f1, fragment1)
                .commit();
        //toggle.syncState();
//        toggle = new android.support.v7.app.ActionBarDrawerToggle(this, d,
//                R.string.drawer_open, R.string.drawer_close) {
//
//            /** Called when a drawer has settled in a completely open state. */
//            public void onDrawerOpened(View drawerView) {
//                super.onDrawerOpened(drawerView);
//                getSupportActionBar().setTitle("Navigation!");
//                invalidateOptionsMenu();
//            }
//
//            /** Called when a drawer has settled in a completely closed state. */
//            public void onDrawerClosed(View view) {
//                super.onDrawerClosed(view);
//                getSupportActionBar().setTitle("Navigation!");
//                invalidateOptionsMenu();
//            }
//
//        };
//        d.addDrawerListener(toggle);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setChecked(true);

                d.closeDrawers();
                Fragment fragment = null;
                FragmentManager fragmentManager = getFragmentManager();
                if (item.getTitle().toString().equalsIgnoreCase("Login")) {


                } else if (item.getTitle().toString().equalsIgnoreCase("Signup")) {

                } else if (item.getTitle().toString().equalsIgnoreCase("Nearby Hospital")) {

                } else if (item.getTitle().toString().equalsIgnoreCase("About Dengue")) {
                    fragment = new AboutDengue();
                } else if (item.getTitle().toString().equalsIgnoreCase("Prevention")) {
                    fragment = new BlankFragment();
                } else {
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


//    @Override
//    protected void onPostCreate(Bundle savedInstanceState) {
//        super.onPostCreate(savedInstanceState);
//        toggle.syncState();
//    }
//    @Override
//    public void onConfigurationChanged(Configuration newConfig) {
//        super.onConfigurationChanged(newConfig);
//        toggle.onConfigurationChanged(newConfig);
//    }
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