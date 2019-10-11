package com.wangyang.baselibrary.page;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public abstract class MyTabPageAdapter extends FragmentStatePagerAdapter {
    private List<TabBean> TAB_BEAN_LIST = new ArrayList<>();
    private Context mContext;

    public MyTabPageAdapter(FragmentManager fm, List<TabBean> list, Context context) {
        super(fm);
        this.TAB_BEAN_LIST.clear();
        this.TAB_BEAN_LIST.addAll(list);
        this.mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        return TAB_BEAN_LIST.get(position).getFragment();
    }

    @Override
    public int getCount() {
        return TAB_BEAN_LIST.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return TAB_BEAN_LIST.get(position).getTitle();
    }

    protected final View getTabView() {
        if (setLayoutRes() != 0) {
            final View view = LayoutInflater.from(mContext).inflate(setLayoutRes(), null);
            return view;
        }
        throw new RuntimeException("TabLayout setLayoutRes is not be Null!");
    }

    protected abstract int setLayoutRes();

    public final void setIndicator(TabLayout tabs, int leftDip, int rightDip) {
        Class<?> tabLayout = tabs.getClass();
        Field tabStrip = null;
        try {
            tabStrip = tabLayout.getDeclaredField("slidingTabIndicator");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        tabStrip.setAccessible(true);
        LinearLayout llTab = null;
        try {
            llTab = (LinearLayout) tabStrip.get(tabs);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        int left = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, leftDip, Resources.getSystem().getDisplayMetrics());
        int right = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, rightDip, Resources.getSystem().getDisplayMetrics());

        for (int i = 0; i < llTab.getChildCount(); i++) {
            View child = llTab.getChildAt(i);
            child.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1);
            params.leftMargin = left;
            params.rightMargin = right;
            child.setLayoutParams(params);
            child.invalidate();
        }
    }

    public final void setCustomView(TabLayout tabLayout) {
        final int size = tabLayout.getTabCount();
        for (int i = 0; i < size; i++) {
            final TabLayout.Tab tab = tabLayout.getTabAt(i);
            if (tab != null) {
                tab.setCustomView(initTabView(i));
            }
        }
    }

    protected View initTabView(int i) {
        return getTabView();
    }

    public void clear() {
        this.TAB_BEAN_LIST.clear();
        notifyDataSetChanged();
    }
}
