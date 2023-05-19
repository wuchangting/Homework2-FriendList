package com.example.homework2_friendlist.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

public class MyFragmentVPTAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> fragmentList;
    private List<String> stringList;

    public MyFragmentVPTAdapter(@NonNull FragmentManager fm,
                                List<Fragment> list,
                                List<String> stringList
    ) {
        super(fm);
        this.fragmentList = list;
        this.stringList = stringList;
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

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return stringList == null ? "" : stringList.get(position);
    }
}
