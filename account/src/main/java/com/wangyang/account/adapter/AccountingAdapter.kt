package com.wangyang.account.adapter

import android.content.Context
import android.support.v4.app.FragmentManager
import com.wangyang.baselibrary.page.MyTabPageAdapter
import com.wangyang.baselibrary.page.TabBean

class AccountingAdapter(fm: FragmentManager, list: MutableList<TabBean>, context: Context) : MyTabPageAdapter(fm,list,context) {
    override fun setLayoutRes(): Int {
        return 0
    }
}