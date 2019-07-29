package com.example.chapter3.homework;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.List;

/**
 * Created by lingyihong on 2019-07-29 15:44
 *
 * @author lingyihong@bytedance.com
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    private List<PageBean> fragments;

    public ViewPagerAdapter(FragmentManager fm, List<PageBean> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int i) {
        return fragments.get(i).getFragment();
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragments.get(position).getTitle();
    }
}
