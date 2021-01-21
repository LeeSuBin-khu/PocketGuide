package com.lee.pg.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.button.MaterialButton;
import com.lee.pg.view.NavigationHost;
import com.lee.pg.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TestMainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TestMainFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_test_main, container, false);

        MaterialButton btn1 = view.findViewById(R.id.select);
        MaterialButton btn2 = view.findViewById(R.id.map);
        MaterialButton btn3 = view.findViewById(R.id.routs);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((NavigationHost)getActivity()).navigateTo(new SelectFragment(), false);

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((NavigationHost)getActivity()).navigateTo(new MapFragment(), false);

            }
        });

        return view;
    }
}