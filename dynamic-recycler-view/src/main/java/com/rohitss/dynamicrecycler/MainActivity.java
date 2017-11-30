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

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = MainActivity.this;
        mRecyclerView = findViewById(R.id.recyclerView);
        RecyclerDataAdapter recyclerDataAdapter = new RecyclerDataAdapter(getDummyDataToPass());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setAdapter(recyclerDataAdapter);
        mRecyclerView.setHasFixedSize(true);
    }

    private ArrayList<DummyParentDataItem> getDummyDataToPass() {
        ArrayList<DummyParentDataItem> dummyDataItems = new ArrayList<>();
        ArrayList<DummyChildDataItem> dummyChildDataItems;
        DummyParentDataItem dummyParentDataItem;
        DummyChildDataItem dummyChildDataItem;
        /////////
        dummyParentDataItem = new DummyParentDataItem();
        dummyParentDataItem.setParentName("Parent 1");
        dummyChildDataItems = new ArrayList<>();
        //
        dummyChildDataItem = new DummyChildDataItem();
        dummyChildDataItem.setChildName("Child Item 1");
        dummyChildDataItems.add(dummyChildDataItem);
        //
        dummyParentDataItem.setChildDataItems(dummyChildDataItems);
        dummyDataItems.add(dummyParentDataItem);
        ////////
        dummyParentDataItem = new DummyParentDataItem();
        dummyParentDataItem.setParentName("Parent 2");
        dummyChildDataItems = new ArrayList<>();
        //
        dummyChildDataItem = new DummyChildDataItem();
        dummyChildDataItem.setChildName("Child Item 1");
        dummyChildDataItems.add(dummyChildDataItem);
        //
        dummyChildDataItem = new DummyChildDataItem();
        dummyChildDataItem.setChildName("Child Item 2");
        dummyChildDataItems.add(dummyChildDataItem);
        //
        dummyParentDataItem.setChildDataItems(dummyChildDataItems);
        dummyDataItems.add(dummyParentDataItem);
        ////////
        dummyParentDataItem = new DummyParentDataItem();
        dummyParentDataItem.setParentName("Parent 3");
        dummyChildDataItems = new ArrayList<>();
        //
        dummyChildDataItem = new DummyChildDataItem();
        dummyChildDataItem.setChildName("Child Item 1");
        dummyChildDataItems.add(dummyChildDataItem);
        //
        dummyChildDataItem = new DummyChildDataItem();
        dummyChildDataItem.setChildName("Child Item 2");
        dummyChildDataItems.add(dummyChildDataItem);
        //
        dummyChildDataItem = new DummyChildDataItem();
        dummyChildDataItem.setChildName("Child Item 3");
        dummyChildDataItems.add(dummyChildDataItem);
        //
        dummyChildDataItem = new DummyChildDataItem();
        dummyChildDataItem.setChildName("Child Item 4");
        dummyChildDataItems.add(dummyChildDataItem);
        //
        dummyChildDataItem = new DummyChildDataItem();
        dummyChildDataItem.setChildName("Child Item 5");
        dummyChildDataItems.add(dummyChildDataItem);
        //
        dummyParentDataItem.setChildDataItems(dummyChildDataItems);
        dummyDataItems.add(dummyParentDataItem);
        ////////
        return dummyDataItems;
    }

    private class RecyclerDataAdapter extends RecyclerView.Adapter<RecyclerDataAdapter.MyViewHolder> {
        private ArrayList<DummyParentDataItem> dummyParentDataItems;

        RecyclerDataAdapter(ArrayList<DummyParentDataItem> dummyParentDataItems) {
            this.dummyParentDataItems = dummyParentDataItems;
            int intMaxSize = 0;
            for (int index = 0; index < dummyParentDataItems.size(); index++) {
                int intMaxSizeTemp = dummyParentDataItems.get(index).getChildDataItems().size();
                if (intMaxSizeTemp > intMaxSize) intMaxSize = intMaxSizeTemp;
            }
        }

        @Override
        public RecyclerDataAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_parent_child_listing, parent, false);
            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(RecyclerDataAdapter.MyViewHolder holder, int position) {
            DummyParentDataItem dummyParentDataItem = dummyParentDataItems.get(position);
            holder.tv_parentName.setText(dummyParentDataItem.getParentName());
            //
            int noOfTextViews = holder.ll_child_items.getChildCount();
            int noOfSubModules = dummyParentDataItem.getChildDataItems().size();
            if (noOfSubModules < noOfTextViews) {
                for (int index = noOfSubModules; index < noOfTextViews; index++) {
                    TextView currentTextView = (TextView) holder.ll_child_items.getChildAt(index);
                    currentTextView.setVisibility(View.GONE);
                }
            }
            for (int textViewIndex = 0; textViewIndex < noOfSubModules; textViewIndex++) {
                TextView currentTextView = (TextView) holder.ll_child_items.getChildAt(textViewIndex);
                currentTextView.setText(dummyParentDataItem.getChildDataItems().get(textViewIndex).getChildName());
                /*currentTextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(mContext, "" + ((TextView) view).getText().toString(), Toast.LENGTH_SHORT).show();
                    }
                });*/
            }
        }

        @Override
        public int getItemCount() {
            return dummyParentDataItems.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            private Context context;
            private TextView tv_parentName;
            private LinearLayout ll_child_items;

            MyViewHolder(View itemView) {
                super(itemView);
                context = itemView.getContext();
                tv_parentName = itemView.findViewById(R.id.tv_parentName);
                ll_child_items = itemView.findViewById(R.id.ll_child_items);
                ll_child_items.setVisibility(View.GONE);
                int intMaxSize = 0;
                for (int index = 0; index < dummyParentDataItems.size(); index++) {
                    int intMaxSizeTemp = dummyParentDataItems.get(index).getChildDataItems().size();
                    if (intMaxSizeTemp > intMaxSize) intMaxSize = intMaxSizeTemp;
                }
                for (int indexView = 0; indexView < intMaxSize; indexView++) {
                    TextView textView = new TextView(context);
                    textView.setId(indexView);
                    textView.setPadding(0, 20, 0, 20);
                    textView.setGravity(Gravity.CENTER);
                    textView.setBackground(ContextCompat.getDrawable(context, R.drawable.background_sub_module_text));
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                    textView.setOnClickListener(this);
                    ll_child_items.addView(textView, layoutParams);
                }
                tv_parentName.setOnClickListener(this);
            }

            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.tv_parentName) {
                    if (ll_child_items.getVisibility() == View.VISIBLE) {
                        ll_child_items.setVisibility(View.GONE);
                    } else {
                        ll_child_items.setVisibility(View.VISIBLE);
                    }
                } else {
                    TextView textViewClicked = (TextView) view;
                    Toast.makeText(context, "" + textViewClicked.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
