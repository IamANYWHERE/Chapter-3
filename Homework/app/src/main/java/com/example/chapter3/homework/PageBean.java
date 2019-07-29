package com.example.chapter3.homework;

import android.support.v4.app.Fragment;

/**
 * Created by lingyihong on 2019-07-29 20:44
 *
 * @author lingyihong@bytedance.com
 */
public class PageBean {

    private Fragment fragment;
    private String title;

    public PageBean(String title, Fragment fragment){
        this.title = title;
        this.fragment = fragment;
    }
    public Fragment getFragment() {
        return fragment;
    }

    public String getTitle() {
        return title;
    }
}
