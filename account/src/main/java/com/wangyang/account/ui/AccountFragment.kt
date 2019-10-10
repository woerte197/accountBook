package com.wangyang.account.ui


import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.router_lib.router.IntentManager
import com.wangyang.account.R
import com.wangyang.account.ui.presenter.AccountPresenter
import com.wangyang.baselibrary.ui.fragment.BaseMvpFragment
import com.wangyang.router_lib.provider.moudle.account.IAccountProvider
import kotlinx.android.synthetic.main.fragment_account.*


/**
 *
 */
@Route(path = IAccountProvider.ACCOUNT_FRAGMENT)
class AccountFragment : BaseMvpFragment<AccountPresenter>() {
    override fun setLayout(): Int {
        return R.layout.fragment_account
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initEvent()
    }

    private fun initEvent() {
        accountTv.setOnClickListener {
            IntentManager.INS.init(IAccountProvider.ACCOUNT_BOOK_ACTIVITY).navigation()
        }
    }


}
