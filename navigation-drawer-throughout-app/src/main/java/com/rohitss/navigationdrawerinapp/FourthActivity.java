package com.rohitss.navigationdrawerinapp;

import android.os.Bundle;

public class FourthActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        getSupportActionBar().setTitle("Activity With Back");
    }

    @Override
    protected boolean useDrawer() {
        return false;
    }

    @Override
    public boolean useToolbar() {
        return true;
    }
}
