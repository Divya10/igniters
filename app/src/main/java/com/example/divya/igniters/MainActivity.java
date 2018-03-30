package com.example.divya.igniters;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    DrawerLayout d;
    //ActionBarDrawerToggle toggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        d=findViewById(R.id.d1);
        Toolbar toolbar=findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);
        //d.addDrawerListener(toggle);
        NavigationView navigationView = findViewById(R.id.nav_view);
        Fragment fragment1;
        fragment1=new BlankFragment2();
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.f1, fragment1)
                .commit();
        //toggle.syncState();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setChecked(true);

                d.closeDrawers();
                Fragment fragment=null;
                FragmentManager fragmentManager = getFragmentManager();
                if(item.getTitle().toString().equalsIgnoreCase("Login"))
                {



                }
                else if(item.getTitle().toString().equalsIgnoreCase("Signup"))
                {

                }
                else if(item.getTitle().toString().equalsIgnoreCase("Nearby Hospital"))
                {

                }
                else if(item.getTitle().toString().equalsIgnoreCase("About Dengue"))
                {
                    fragment=new AboutDengue();
                }
                else if(item.getTitle().toString().equalsIgnoreCase("Prevention"))
                {
                    fragment=new BlankFragment();
                }
                else
                {
                    fragment=new OurTeam();
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
    }




