package com.lee.pg;

import android.database.DataSetObserver;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SelectFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SelectFragment extends Fragment {
//dsadas
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment`

        View view = inflater.inflate(R.layout.fragment_select, container, false);
        String[] items = {"서울", "경기도"};
        ListAdapter adapter = new ArrayAdapter<String>(getActivity(), R.layout.list_region, items);

        AutoCompleteTextView autoCompleteTextView = view.findViewById(R.id.labels);
        //autoCompleteTextView.setAdapter(adapter);


        return view;
    }
}