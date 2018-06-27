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
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private long backPressedTimer;
    private DrawerLayout homedrawerlayout;
    private ActionBarDrawerToggle homedrawertoggle;
    FirebaseAuth firebaseAuth;
    FirebaseUser user;
    String uid, User_first_name;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        homedrawerlayout = findViewById(R.id.drawerLayout);
        homedrawertoggle = new ActionBarDrawerToggle(this, homedrawerlayout, R.string.open, R.string.close);
        homedrawerlayout.addDrawerListener(homedrawertoggle);
        homedrawertoggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final NavigationView navigationView = findViewById(R.id.home_navigation);
        navigationView.setNavigationItemSelectedListener(this);


        View header = navigationView.getHeaderView(0);
        final TextView profileName = header.findViewById(R.id.profile_name);

        header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profile = new Intent(getApplicationContext(), ProfileActivity.class);
                startActivity(profile);
            }
        });


        user = FirebaseAuth.getInstance().getCurrentUser();
        uid = user.getUid();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User_first_name = dataSnapshot.child("Users").child(uid).child("Info").child("FirstName").getValue(String.class);
                profileName.setText(User_first_name);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        getSupportFragmentManager().beginTransaction().add(R.id.fragmest_container_frame_layout, new HomeFragment()).commit();
        navigationView.setCheckedItem(R.id.home_menu);

        firebaseAuth = FirebaseAuth.getInstance();
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

        switch (item.getItemId()) {
            case R.id.home_menu:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmest_container_frame_layout, new HomeFragment()).commit();
                break;
            case R.id.BeginnersLevel_menu:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmest_container_frame_layout, new BeginnersLevelFragment()).commit();
                break;
            case R.id.AdvancedLevel_menu:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmest_container_frame_layout, new AdvancedLevelFragment()).commit();
                break;
            case R.id.ExpertLevel_menu:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmest_container_frame_layout, new ExpertLevelFragment()).commit();
                break;
            case R.id.Ranking_menu:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmest_container_frame_layout, new RankingFragment()).commit();
                break;
            case R.id.Logout_menu:
                firebaseAuth.signOut();
                finish();
                Intent log = new Intent(Home.this, Login.class);
                startActivity(log);
                break;
        }

        homedrawerlayout.closeDrawer(GravityCompat.START);
        return true;
    }


}
