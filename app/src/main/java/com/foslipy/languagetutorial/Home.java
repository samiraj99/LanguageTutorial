package com.foslipy.languagetutorial;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout homedrawerlayout;
    private ActionBarDrawerToggle homedrawertoggle;
    FirebaseAuth firebaseAuth;
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

        getSupportFragmentManager().beginTransaction().replace(R.id.fragmest_container_frame_layout,new home_fragment()).commit();
        navigationView.setCheckedItem(R.id.home_menu);

        firebaseAuth=FirebaseAuth.getInstance();
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
            case R.id.home_menu:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmest_container_frame_layout,new home_fragment()).commit();
                break;
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
               firebaseAuth.signOut();
               finish();
                Intent log=new Intent(Home.this,Login.class);
                startActivity(log);
                break;
            }

        homedrawerlayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
