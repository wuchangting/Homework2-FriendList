package com.example.homework2_friendlist.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

//保留一个fragment，回收其他fragment
public class MyFragmentStateAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragmentList;

    public MyFragmentStateAdapter(@NonNull FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.fragmentList = list;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList == null ? null : fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList == null ? 0 : fragmentList.size();
    }
}
