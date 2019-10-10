package com.wangyang.accountbook.home

import android.os.Bundle
import android.support.v4.app.Fragment
import com.example.router_lib.router.RouterManager
import com.wangyang.account.ui.AccountFragment
import com.wangyang.accountbook.R
import com.wangyang.accountbook.home.presenter.MainPresenter
import com.wangyang.baselibrary.common.BottomTabSelectListener
import com.wangyang.baselibrary.ui.activity.BaseMvpActivity
import com.wangyang.baselibrary.utils.FragmentManager
import com.wangyang.router_lib.provider.moudle.account.IAccountProvider
import com.wangyang.tinner.dagger.compontent.DaggerMainComment
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import javax.inject.Inject

class MainActivity : BaseMvpActivity<MainPresenter>() {

    private val stack: Stack<Fragment> = Stack()

    @Inject
    lateinit var fragmentManager: FragmentManager

    private val accountFragment by lazy {
        RouterManager.INS.getAccountProvider().newInstance(IAccountProvider.ACCOUNT_FRAGMENT)
    }

    override fun inject() {
        DaggerMainComment.builder().build().inject(this)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initFragment()
        initEvent()
    }

    private fun initFragment() {
        stack.push(accountFragment)
        stack.push(AccountFragment())
        stack.push(AccountFragment())
        stack.push(AccountFragment())
        fragmentManager.addFragments(R.id.mFrameLayout, supportFragmentManager.beginTransaction(), stack)
        fragmentManager.changeFragment(supportFragmentManager.beginTransaction(), 0)
    }

    private fun initEvent() {
        mBottomBar.setTabSelectedListener(object : BottomTabSelectListener {
            override fun onTabSelected(position: Int) {
                fragmentManager.changeFragment(supportFragmentManager.beginTransaction(), position)
            }
        })
    }
}
