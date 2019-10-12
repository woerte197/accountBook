package com.wangyang.baselibrary.page

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter


abstract class GridViewAdapter<T>(var context: Context, var list: List<T>) : BaseAdapter() {
    private var layoutInflater: LayoutInflater? = null
    private var view: View? = null

    init {
        layoutInflater = LayoutInflater.from(context)

    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var viewHolder: ViewHolder<T>?
        if (convertView == null) {
            view = layoutInflater?.inflate(initLayout(), null)
            viewHolder = getHolder()
            viewHolder?.view = view
            viewHolder?.initView()
            view?.tag = viewHolder
        } else {
            viewHolder = view!!.tag as ViewHolder<T>
        }
        viewHolder!!.setView(list[position])
        return view!!

    }

    abstract fun initLayout(): Int

    abstract fun getHolder(): ViewHolder<T>?

    override fun getItem(position: Int): T {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return list.size
    }

    abstract class ViewHolder<T> {
        var view: View? = null
        abstract fun initView()
        abstract fun setView(t: T)

    }
}