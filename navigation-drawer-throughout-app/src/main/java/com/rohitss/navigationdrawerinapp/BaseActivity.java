package com.rohitss.navigationdrawerinapp;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

public class BaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private NavigationView navigationView;
    private DrawerLayout fullLayout;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setContentView(int layoutResID) {
        fullLayout = (DrawerLayout) getLayoutInflater().inflate(R.layout.base_drawer_layout, null);

//        FrameLayout activityContainer = (FrameLayout) fullLayout.findViewById(R.id.activity_content);
//        getLayoutInflater().inflate(layoutResID, activityContainer, true);
        super.setContentView(fullLayout);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        navigationView = (NavigationView) findViewById(R.id.navigationView);

        if (useToolbar()) {
            setSupportActionBar(toolbar);
        } else {
            toolbar.setVisibility(View.GONE);
        }

        setUpNavView();
    }

    private void setUpNavView() {
        navigationView.setNavigationItemSelectedListener(this);
        if (useDrawer()) { // use the hamburger main_menu
            ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, fullLayout, toolbar,
                    R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            fullLayout.addDrawerListener(drawerToggle);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            drawerToggle.syncState();
        } else if (useToolbar() && getSupportActionBar() != null) {
            // Use home/back button instead
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        } else if (!useToolbar() && getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        }
    }

    public boolean useToolbar() {
        return true;
    }

    protected boolean useDrawer() {
        return true;
    }

    @Override
    public void onBackPressed() {
        if (fullLayout.isDrawerOpen(GravityCompat.START)) {
            fullLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//         Inflate the main_menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main_menu, menu);
//        return true;
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        fullLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
