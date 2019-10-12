package com.wangyang.account.ui

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.wangyang.account.R
import com.wangyang.account.adapter.AccountingAdapter
import com.wangyang.account.ui.presenter.AccountBookActivityPresenter
import com.wangyang.baselibrary.magicindicator.ViewPagerHelper
import com.wangyang.baselibrary.magicindicator.buildins.commonnavigator.CommonNavigator
import com.wangyang.baselibrary.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter
import com.wangyang.baselibrary.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
import com.wangyang.baselibrary.magicindicator.buildins.commonnavigator.abs.IPagerTitleView
import com.wangyang.baselibrary.magicindicator.buildins.commonnavigator.indicators.BezierPagerIndicator
import com.wangyang.baselibrary.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView
import com.wangyang.baselibrary.page.TabBean
import com.wangyang.baselibrary.ui.activity.BaseMvpActivity
import com.wangyang.router_lib.provider.moudle.account.IAccountProvider
import kotlinx.android.synthetic.main.activity_account_book.*

@Route(path = IAccountProvider.ACCOUNT_BOOK_ACTIVITY)
class AccountBookActivity : BaseMvpActivity<AccountBookActivityPresenter>() {
    private var commonNavigatorAdapter: CommonNavigatorAdapter? = null
    private val tableList: MutableList<TabBean> = mutableListOf()

    override fun inject() {

    }

    init {
        val tableBeanA = TabBean().setFragment(AccountingFragment.newInstance(1)).setTitle("支出")
        val tableBeanB = TabBean().setFragment(AccountingFragment.newInstance(2)).setTitle("支出")
        val tableBeanC = TabBean().setFragment(AccountingFragment.newInstance(3)).setTitle("支出")
        val tableBeanD = TabBean().setFragment(AccountingFragment.newInstance(4)).setTitle("支出")
        tableList.add(tableBeanA)
        tableList.add(tableBeanB)
        tableList.add(tableBeanC)
        tableList.add(tableBeanD)
        commonNavigatorAdapter = object : CommonNavigatorAdapter() {
            override fun getCount(): Int {
                return tableList.size
            }

            override fun getTitleView(context: Context?, index: Int): IPagerTitleView {
                val simplePagerTitleView = SimplePagerTitleView(context)
                simplePagerTitleView.text = tableList[index].title
                simplePagerTitleView.textSize = 18f
                simplePagerTitleView.normalColor = Color.GRAY
                simplePagerTitleView.selectedColor = Color.BLACK
                simplePagerTitleView.setOnClickListener { mViewPager.currentItem = index }
                return simplePagerTitleView
            }

            override fun getIndicator(context: Context?): IPagerIndicator {
                val indicator = BezierPagerIndicator(context)
                indicator.setColors(
                    Color.parseColor("#ff4a42"),
                    Color.parseColor("#fcde64"),
                    Color.parseColor("#73e8f4"),
                    Color.parseColor("#76b0ff"),
                    Color.parseColor("#c683fe")
                )
                return indicator
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_book)
        initView()
    }

    private fun initView() {
        mViewPager.adapter = AccountingAdapter(supportFragmentManager, tableList, this)
        mMagicIndicator.setBackgroundColor(Color.WHITE)
        val commonNavigator = CommonNavigator(this)
        commonNavigator.adapter = commonNavigatorAdapter
        commonNavigator.isAdjustMode = true
        mMagicIndicator.navigator = commonNavigator
        ViewPagerHelper.bind(mMagicIndicator, mViewPager)

    }

}
