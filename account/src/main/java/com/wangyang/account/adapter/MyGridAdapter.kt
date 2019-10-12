package com.wangyang.account.adapter

import android.content.Context
import android.widget.TextView
import com.wangyang.account.R
import com.wangyang.baselibrary.page.GridViewAdapter

class MyGridAdapter<T>(context: Context, list: List<T>) : GridViewAdapter<T>(context, list) {
    override fun getHolder(): ViewHolder<T>? {
        return MyViewHolder()
    }

    override fun initLayout(): Int {
        return R.layout.item_news_layout
    }


    class MyViewHolder<T> : GridViewAdapter.ViewHolder<T>() {
        override fun setView(data: T) {
            var text = data as String
            textView?.text = text
        }

        var textView: TextView? = null

        override fun initView() {
            textView = view?.findViewById(R.id.mNewsText)
        }


    }

}