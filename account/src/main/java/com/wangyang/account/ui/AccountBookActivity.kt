package com.wangyang.account.ui

import android.graphics.Color
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.wangyang.account.R
import com.wangyang.account.adapter.AccountingAdapter
import com.wangyang.account.ui.presenter.AccountBookActivityPresenter
import com.wangyang.baselibrary.page.TabBean
import com.wangyang.baselibrary.ui.activity.BaseMvpActivity
import com.wangyang.router_lib.provider.moudle.account.IAccountProvider
import kotlinx.android.synthetic.main.activity_account_book.*

@Route(path = IAccountProvider.ACCOUNT_BOOK_ACTIVITY)
class AccountBookActivity : BaseMvpActivity<AccountBookActivityPresenter>() {

    override fun inject() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_book)
        initView()
    }

    private fun initView() {
        val tableList: MutableList<TabBean> = mutableListOf()
        val tableBeanA = TabBean().setFragment(AccountingFragment.newInstance(1)).setTitle("支出")
        val tableBeanB = TabBean().setFragment(AccountingFragment.newInstance(2)).setTitle("支出")
        val tableBeanC = TabBean().setFragment(AccountingFragment.newInstance(3)).setTitle("支出")
        val tableBeanD = TabBean().setFragment(AccountingFragment.newInstance(4)).setTitle("支出")
        tableList.add(tableBeanA)
        tableList.add(tableBeanB)
        tableList.add(tableBeanC)
        tableList.add(tableBeanD)
        mViewPager.adapter = AccountingAdapter(supportFragmentManager, tableList, this)
        mTable.setSelectedTabIndicatorColor(Color.GREEN)
        mTable.setupWithViewPager()




    }
}
