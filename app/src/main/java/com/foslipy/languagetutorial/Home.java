package com.foslipy.languagetutorial;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout homedrawerlayout;
    private ActionBarDrawerToggle homedrawertoggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        homedrawerlayout = findViewById(R.id.drawerLayout);
        homedrawertoggle = new ActionBarDrawerToggle(this, homedrawerlayout, R.string.open, R.string.close);
        homedrawerlayout.addDrawerListener(homedrawertoggle);
        homedrawertoggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView = findViewById(R.id.home_navigation);
        navigationView.setNavigationItemSelectedListener(this);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (homedrawertoggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.BeginnersLevel_menu:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmest_container_frame_layout,new beginners_fragment()).commit();
                break;
            case R.id.AdvancedLevel_menu:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmest_container_frame_layout,new advanced_fragment()).commit();
                break;
            case R.id.ExpertLevel_menu:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmest_container_frame_layout,new experts_fragment()).commit();
                break;
            case R.id.Ranking_menu:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmest_container_frame_layout,new ranking_fragment()).commit();
                break;
            case R.id.Logout_menu:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmest_container_frame_layout,new logout_fragment()).commit();
                break;


        }


        return true;
    }
}
