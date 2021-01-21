package com.lee.pg.view;

import androidx.fragment.app.Fragment;

public interface NavigationHost {

    void navigateTo(Fragment fragment, boolean addToBackstack);
}
