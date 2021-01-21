package com.lee.pg.fragment;

import android.annotation.SuppressLint;
import android.database.DataSetObserver;
import android.os.Bundle;

import androidx.core.util.Pair;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.google.android.material.textfield.TextInputEditText;
import com.lee.pg.R;


public class SelectFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment`

        View view = inflater.inflate(R.layout.fragment_select, container, false);
        MaterialAutoCompleteTextView autoCompleteTextView = view.findViewById(R.id.dropdown_menu_region);
        TextInputEditText textView_datepicker = view.findViewById(R.id.editText_date);

        String[] items = {"서울특별시", "경기도", "강원도", "충청남도", "충청북도"};
        ArrayAdapter<CharSequence> adapter = new ArrayAdapter(getActivity(), R.layout.list_region, items);

        autoCompleteTextView.setAdapter(adapter);



        textView_datepicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MaterialDatePicker.Builder<Pair<Long, Long>> builder = MaterialDatePicker.Builder.dateRangePicker();
                builder.setTitleText("여행 날짜 선택하기");

                MaterialDatePicker picker = builder.build();

                picker.show(getFragmentManager(), "Picker");
            }
        });



        return view;
    }
}