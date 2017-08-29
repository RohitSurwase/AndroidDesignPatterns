package com.rohitss.swipeabletabs;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * This is the adapter class for our ViewPager.
 * This class extends FragmentStatePagerAdapter for better performance.
 * Created By - rohitss.
 */
public class MyViewPagerAdapter extends FragmentStatePagerAdapter {
    private String[] arrTabNames = {"Page 1", "Page 2", "Page 3"};

    public MyViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return OneFragment.newInstance();
            case 1:
                return TwoFragment.newInstance();
            case 2:
                return ThreeFragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return arrTabNames.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return arrTabNames[position];
    }
}
