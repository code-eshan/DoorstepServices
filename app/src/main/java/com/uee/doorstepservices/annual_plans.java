package com.uee.doorstepservices;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class annual_plans extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG="Annual Activity";

    private DrawerLayout drawer;
    private NavigationView navigationView;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_annual_plans);

        toolbar = (Toolbar)findViewById(R.id.ppTopNavBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Annual Plans");

        initViews();

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.drawer_open,R.string.drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public void onBackPressed() {

        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else
            super.onBackPressed();
    }

    private void initViews() {

        Log.d(TAG, "initViews: started");
        drawer = (DrawerLayout)findViewById(R.id.drawer);
        navigationView = (NavigationView)findViewById(R.id.navigation_drawer);

        navigationView.setNavigationItemSelectedListener(this);

        navigationView.getMenu().getItem(6).setChecked(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch(item.getItemId())
        {
            case R.id.nav_home:
                Toast.makeText(getApplicationContext(),"Home Selected",Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_bookings:
                Toast.makeText(getApplicationContext(),"Bookings Selected",Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_aboutus:
                Toast.makeText(getApplicationContext(),"About Us Selected",Toast.LENGTH_SHORT).show();
                intent = new Intent(annual_plans.this,aboutus.class);
                startActivity(intent);
                break;
            case R.id.nav_prime:
                Toast.makeText(getApplicationContext(),"Prime Panel Selected",Toast.LENGTH_SHORT).show();
                intent = new Intent(annual_plans.this,PrimePanel.class);
                startActivity(intent);
                break;
            case R.id.nav_annual:
                Toast.makeText(getApplicationContext(),"Annual Subscriptions Selected",Toast.LENGTH_SHORT).show();
                drawer.closeDrawer(GravityCompat.START);
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}