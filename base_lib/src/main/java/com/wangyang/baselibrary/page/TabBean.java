package com.wangyang.baselibrary.page;


import android.support.v4.app.Fragment;

public class TabBean {
    private String title;
    private Fragment fragment;

    public String getTitle() {
        return title;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public TabBean setTitle(String title) {
        this.title = title;
        return this;

    }


    public TabBean setFragment(Fragment fragment) {
        this.fragment = fragment;
        return this;
    }
}
