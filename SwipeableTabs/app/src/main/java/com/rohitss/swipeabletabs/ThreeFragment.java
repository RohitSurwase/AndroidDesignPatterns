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
public class ThreeFragment extends Fragment {

    public ThreeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_discharge, container, false);
    }

    public static ThreeFragment newInstance() {
        Bundle args = new Bundle();

        ThreeFragment fragment = new ThreeFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
