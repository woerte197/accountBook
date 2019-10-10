package com.wangyang.account.router.provider

import com.alibaba.android.arouter.facade.annotation.Route
import com.example.router_lib.provider.base.BaseProvider
import com.wangyang.router_lib.provider.moudle.account.IAccountProvider


@Route(path = IAccountProvider.ACCOUNT_SERVICE)
class AccountProvider :BaseProvider(), IAccountProvider{
    override fun init() {

    }

}