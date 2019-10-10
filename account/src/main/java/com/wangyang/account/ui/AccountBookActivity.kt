package com.wangyang.account.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.wangyang.account.R
import com.wangyang.account.ui.presenter.AccountBookActivityPresenter
import com.wangyang.baselibrary.ui.activity.BaseMvpActivity
import com.wangyang.router_lib.provider.moudle.account.IAccountProvider

@Route(path = IAccountProvider.ACCOUNT_BOOK_ACTIVITY)
class AccountBookActivity : BaseMvpActivity<AccountBookActivityPresenter>() {
    override fun inject() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_book)
    }
}
