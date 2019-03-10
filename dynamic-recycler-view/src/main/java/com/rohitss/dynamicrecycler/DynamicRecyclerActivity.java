package com.rohitss.dynamicrecycler;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DynamicRecyclerActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_recycler);
        setContentView(R.layout.activity_dynamic_recycler);
        mContext = DynamicRecyclerActivity.this;
        mRecyclerView = findViewById(R.id.recyclerView);
        RecyclerDataAdapter recyclerDataAdapter = new RecyclerDataAdapter(getDummyDataToPass());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setAdapter(recyclerDataAdapter);
        mRecyclerView.setHasFixedSize(true);
    }

    private ArrayList<DummyParentDataItem> getDummyDataToPass() {
        ArrayList<DummyParentDataItem> arrDummyData = new ArrayList<>();
        ArrayList<DummyChildDataItem> childDataItems;
        /////////
        childDataItems = new ArrayList<>();
        childDataItems.add(new DummyChildDataItem("A Child 1"));
        childDataItems.add(new DummyChildDataItem("A Child 2"));
        childDataItems.add(new DummyChildDataItem("A Child 3"));
        arrDummyData.add(new DummyParentDataItem("A Parent, 3 Children", childDataItems));
        /////////
        childDataItems = new ArrayList<>();
        childDataItems.add(new DummyChildDataItem("B Child 1"));
        childDataItems.add(new DummyChildDataItem("B Child 2"));
        childDataItems.add(new DummyChildDataItem("B Child 3"));
        childDataItems.add(new DummyChildDataItem("B Child 4"));
        childDataItems.add(new DummyChildDataItem("B Child 5"));
        childDataItems.add(new DummyChildDataItem("B Child 6"));
        arrDummyData.add(new DummyParentDataItem("B Parent, 6 Children", childDataItems));
        /////////
        childDataItems = new ArrayList<>();
        childDataItems.add(new DummyChildDataItem("C Child 1"));
        childDataItems.add(new DummyChildDataItem("C Child 2"));
        childDataItems.add(new DummyChildDataItem("C Child 3"));
        childDataItems.add(new DummyChildDataItem("C Child 4"));
        childDataItems.add(new DummyChildDataItem("C Child 5"));
        childDataItems.add(new DummyChildDataItem("C Child 6"));
        childDataItems.add(new DummyChildDataItem("C Child 7"));
        childDataItems.add(new DummyChildDataItem("C Child 8"));
        childDataItems.add(new DummyChildDataItem("C Child 9"));
        arrDummyData.add(new DummyParentDataItem("C Parent, 9 Children", childDataItems));
        /////////
        childDataItems = new ArrayList<>();
        childDataItems.add(new DummyChildDataItem("D Child 1"));
        arrDummyData.add(new DummyParentDataItem("D Parent, 1 Children", childDataItems));
        /////////
        childDataItems = new ArrayList<>();
        arrDummyData.add(new DummyParentDataItem("E Parent, 0 Children", childDataItems));
        /////////
        childDataItems = new ArrayList<>();
        childDataItems.add(new DummyChildDataItem("F Child 1"));
        childDataItems.add(new DummyChildDataItem("F Child 2"));
        arrDummyData.add(new DummyParentDataItem("F Parent, 2 Children", childDataItems));
        /////////
        childDataItems = new ArrayList<>();
        childDataItems.add(new DummyChildDataItem("G Child 1"));
        childDataItems.add(new DummyChildDataItem("G Child 2"));
        childDataItems.add(new DummyChildDataItem("G Child 3"));
        childDataItems.add(new DummyChildDataItem("G Child 4"));
        arrDummyData.add(new DummyParentDataItem("G Parent, 4 Children", childDataItems));
        /////////
        childDataItems = new ArrayList<>();
        childDataItems.add(new DummyChildDataItem("H Child 1"));
        childDataItems.add(new DummyChildDataItem("H Child 2"));
        childDataItems.add(new DummyChildDataItem("H Child 3"));
        childDataItems.add(new DummyChildDataItem("H Child 4"));
        childDataItems.add(new DummyChildDataItem("H Child 5"));
        childDataItems.add(new DummyChildDataItem("H Child 6"));
        childDataItems.add(new DummyChildDataItem("H Child 7"));
        childDataItems.add(new DummyChildDataItem("H Child 8"));
        arrDummyData.add(new DummyParentDataItem("H Parent, 8 Children", childDataItems));
        /////////
        childDataItems = new ArrayList<>();
        childDataItems.add(new DummyChildDataItem("I Child 1"));
        arrDummyData.add(new DummyParentDataItem("I Parent, 1 Children", childDataItems));
        /////////
        childDataItems = new ArrayList<>();
        childDataItems.add(new DummyChildDataItem("J Child 1"));
        childDataItems.add(new DummyChildDataItem("J Child 2"));
        childDataItems.add(new DummyChildDataItem("J Child 3"));
        childDataItems.add(new DummyChildDataItem("J Child 4"));
        childDataItems.add(new DummyChildDataItem("J Child 5"));
        arrDummyData.add(new DummyParentDataItem("J Parent, 5 Children", childDataItems));
        /////////
        childDataItems = new ArrayList<>();
        childDataItems.add(new DummyChildDataItem("K Child 1"));
        childDataItems.add(new DummyChildDataItem("K Child 2"));
        childDataItems.add(new DummyChildDataItem("K Child 3"));
        childDataItems.add(new DummyChildDataItem("K Child 4"));
        childDataItems.add(new DummyChildDataItem("K Child 5"));
        childDataItems.add(new DummyChildDataItem("K Child 6"));
        childDataItems.add(new DummyChildDataItem("K Child 7"));
        arrDummyData.add(new DummyParentDataItem("K Parent, 7 Children", childDataItems));
        /////////
        childDataItems = new ArrayList<>();
        childDataItems.add(new DummyChildDataItem("L Child 1"));
        childDataItems.add(new DummyChildDataItem("L Child 2"));
        arrDummyData.add(new DummyParentDataItem("L Parent, 2 Children", childDataItems));
        /////////
        childDataItems = new ArrayList<>();
        childDataItems.add(new DummyChildDataItem("M Child 1"));
        childDataItems.add(new DummyChildDataItem("M Child 2"));
        childDataItems.add(new DummyChildDataItem("M Child 3"));
        childDataItems.add(new DummyChildDataItem("M Child 4"));
        childDataItems.add(new DummyChildDataItem("M Child 5"));
        arrDummyData.add(new DummyParentDataItem("M Parent, 5 Children", childDataItems));
        /////////
        childDataItems = new ArrayList<>();
        childDataItems.add(new DummyChildDataItem("N Child 1"));
        childDataItems.add(new DummyChildDataItem("N Child 2"));
        childDataItems.add(new DummyChildDataItem("N Child 3"));
        childDataItems.add(new DummyChildDataItem("N Child 4"));
        childDataItems.add(new DummyChildDataItem("N Child 5"));
        childDataItems.add(new DummyChildDataItem("N Child 6"));
        childDataItems.add(new DummyChildDataItem("N Child 7"));
        childDataItems.add(new DummyChildDataItem("N Child 8"));
        childDataItems.add(new DummyChildDataItem("N Child 9"));
        childDataItems.add(new DummyChildDataItem("N Child 10"));
        childDataItems.add(new DummyChildDataItem("N Child 11"));
        childDataItems.add(new DummyChildDataItem("N Child 12"));
        arrDummyData.add(new DummyParentDataItem("N Parent, 12 Children", childDataItems));
        /////////
        childDataItems = new ArrayList<>();
        childDataItems.add(new DummyChildDataItem("O Child 1"));
        childDataItems.add(new DummyChildDataItem("O Child 2"));
        arrDummyData.add(new DummyParentDataItem("O Parent, 2 Children", childDataItems));
        ////////
        return arrDummyData;
    }
}
