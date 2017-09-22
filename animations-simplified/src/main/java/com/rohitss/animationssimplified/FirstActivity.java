package com.rohitss.animationssimplified;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FirstActivity extends BaseActivity implements View.OnClickListener {
    private TextView textViewRight;
    private TextView textViewLeft;
    private TextView textViewTop;
    private Button buttonActivity;
    private Button buttonAddRight;
    private Button buttonRemoveLeft;
    private Button buttonAddLeft;
    private Button buttonRemoveRight;
    private Button buttonAddTop;
    private Button buttonRemoveBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        textViewRight = (TextView) findViewById(R.id.textViewRight);
        textViewLeft = (TextView) findViewById(R.id.textViewLeft);
        textViewTop = (TextView) findViewById(R.id.textViewTop);
        buttonActivity = (Button) findViewById(R.id.buttonActivity);
        buttonAddRight = (Button) findViewById(R.id.buttonAddRight);
        buttonRemoveLeft = (Button) findViewById(R.id.buttonRemoveLeft);
        buttonAddLeft = (Button) findViewById(R.id.buttonAddLeft);
        buttonRemoveRight = (Button) findViewById(R.id.buttonRemoveRight);
        buttonAddTop = (Button) findViewById(R.id.buttonAddTop);
        buttonRemoveBottom = (Button) findViewById(R.id.buttonRemoveBottom);
        buttonActivity.setOnClickListener(this);
        buttonAddRight.setOnClickListener(this);
        buttonAddLeft.setOnClickListener(this);
        buttonAddTop.setOnClickListener(this);
        buttonRemoveRight.setOnClickListener(this);
        buttonRemoveLeft.setOnClickListener(this);
        buttonRemoveBottom.setOnClickListener(this);
        textViewRight.setVisibility(View.INVISIBLE);
        textViewLeft.setVisibility(View.INVISIBLE);
        textViewTop.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonActivity:
                startActivity(new Intent(FirstActivity.this, SecondActivity.class));
                break;
            case R.id.buttonAddRight:
                textViewRight.setVisibility(View.VISIBLE);
                SlideAnimationUtil.slideInFromRight(this, textViewRight);
                break;
            case R.id.buttonRemoveLeft:
                textViewRight.setVisibility(View.INVISIBLE);
                SlideAnimationUtil.slideOutToLeft(this, textViewRight);
                break;
            case R.id.buttonAddLeft:
                textViewLeft.setVisibility(View.VISIBLE);
                SlideAnimationUtil.slideInFromLeft(this, textViewLeft);
                break;
            case R.id.buttonRemoveRight:
                textViewLeft.setVisibility(View.INVISIBLE);
                SlideAnimationUtil.slideOutToRight(this, textViewLeft);
                break;
            case R.id.buttonAddTop:
                textViewTop.setVisibility(View.VISIBLE);
                SlideAnimationUtil.slideInFromTop(this, textViewTop);
                break;
            case R.id.buttonRemoveBottom:
                textViewTop.setVisibility(View.INVISIBLE);
                SlideAnimationUtil.slideOutToBottom(this, textViewTop);
                break;
        }
    }
}
