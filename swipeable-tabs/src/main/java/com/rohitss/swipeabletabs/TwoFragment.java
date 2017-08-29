package com.rohitss.swipeabletabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * This is a dummy fragment.
 * Created By - rohitss.
 */
public class TwoFragment extends Fragment {


    public TwoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_charge, container, false);
    }

    public static TwoFragment newInstance() {

        Bundle args = new Bundle();

        TwoFragment fragment = new TwoFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
