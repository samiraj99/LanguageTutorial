package com.foslipy.languagetutorial;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class Home extends AppCompatActivity {

    private DrawerLayout homedrawerlayout;
    private ActionBarDrawerToggle homedrawertoggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        homedrawerlayout=findViewById(R.id.drawerLayout);
        homedrawertoggle=new ActionBarDrawerToggle(this,homedrawerlayout,R.string.open,R.string.close);
        homedrawerlayout.addDrawerListener(homedrawertoggle);
        homedrawertoggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(homedrawertoggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);

    }

}
