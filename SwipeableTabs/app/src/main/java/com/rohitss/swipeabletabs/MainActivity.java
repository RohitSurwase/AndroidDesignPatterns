package com.rohitss.swipeabletabs;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

/**
 * This is the class where we want to add swipeable tabs.
 * Created By - rohitss.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize VIewPager
        ViewPager mViewPager = (ViewPager) findViewById(R.id.viewPager_Home);
        TabLayout mTabLayout = (TabLayout) findViewById(R.id.tabLayout_Home);
        MyViewPagerAdapter myViewPagerAdapter = new MyViewPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(myViewPagerAdapter);
        //Sync TabLayout with ViewPager.
        mTabLayout.setupWithViewPager(mViewPager);
    }
}
