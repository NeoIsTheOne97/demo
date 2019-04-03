package com.hexabyte.demo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabPageAdapter extends FragmentPagerAdapter {

    int tabCount;

    public TabPageAdapter(FragmentManager fm, int numberOfTabs) {
        super(fm);
        this.tabCount = numberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                dietFragment tab1 = new dietFragment();
                return tab1;
            case 1:
                signUpFragment tab2 = new signUpFragment();
                return tab2;
            case 2:
                reportFragment tab3 = new reportFragment();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
