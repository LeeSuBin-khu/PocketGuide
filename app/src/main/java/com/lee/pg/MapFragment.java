package com.lee.pg;

import android.os.Bundle;

import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

import net.daum.mf.map.api.MapView;

public class MapFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout)inflater.inflate(R.layout.fragment_map, container, false);
        LinearLayout contentLayout = coordinatorLayout.findViewById(R.id.contentLayout);

        BottomSheetBehavior<LinearLayout> sheetBehavior = GestureLockedBottomSheetBehavior.from(contentLayout);
        sheetBehavior.setFitToContents(false);
        sheetBehavior.setHideable(false);//prevents the boottom sheet from completely hiding off the screen
        sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);//initially state to fully expande;

        SwipeRefreshLayout swipeRefreshLayout = coordinatorLayout.findViewById(R.id.swiperefresh);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //Do your changes here
            }
        });

        MapView mapView = new MapView(getActivity());

        ViewGroup mapViewContainer = (ViewGroup) coordinatorLayout.findViewById(R.id.map_view);
        mapViewContainer.addView(mapView);

        return coordinatorLayout;
    }
}