package com.example.feame3.home.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class HomeFragmentAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments;

    public HomeFragmentAdapter(@NonNull FragmentManager fm, List<Fragment>  fragments) {
        super(fm);
        this.fragments = fragments;
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}