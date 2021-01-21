package com.lee.pg.fragment;

import android.os.Bundle;

import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.lee.pg.view.GestureLockedBottomSheetBehavior;
import com.lee.pg.R;
import com.lee.pg.javaClass.Spot;
import com.lee.pg.view.Spot_Adapter;

import net.daum.mf.map.api.MapView;

import java.util.ArrayList;
import java.util.List;

public class MapFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        List<Spot> spots = new ArrayList<>();
        spots.add(new Spot(null, "name1", "location1"));
        spots.add(new Spot(null, "name2", "location2"));
        Spot_Adapter spot_adapter = new Spot_Adapter(spots);

        CoordinatorLayout coordinatorLayout = (CoordinatorLayout)inflater.inflate(R.layout.fragment_map, container, false);
        LinearLayout contentLayout = coordinatorLayout.findViewById(R.id.contentLayout);
        RecyclerView recyclerView = coordinatorLayout.findViewById(R.id.Test);
        LinearLayoutManager spotLinearLayoutManager = new LinearLayoutManager(getActivity());
        spotLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(spotLinearLayoutManager);

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

        recyclerView.setAdapter(spot_adapter);

        return coordinatorLayout;
    }
}