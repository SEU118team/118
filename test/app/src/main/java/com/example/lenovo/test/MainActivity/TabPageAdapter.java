package com.example.lenovo.test.MainActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class TabPageAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;
    private String[] tabNames;//tab选项名字


    public TabPageAdapter(FragmentManager fm, List<Fragment> fragments, String[] tabNames) {
        super(fm);
        this.fragments = fragments;
        this.tabNames=tabNames;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
    //重写getPageTitle()方法
    @Override
    public CharSequence getPageTitle(int position) {
        //返回tab选项的名字
        return tabNames[position];
    }

}
