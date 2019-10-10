package com.wangyang.router_lib.provider.moudle.account

import com.example.router_lib.provider.base.IFragmentProvider

interface IAccountProvider :IFragmentProvider{
    companion object {
        const val ACCOUNT_SERVICE = "/account/account/service"
        const val ACCOUNT_FRAGMENT = "/account/account/AccountFragment"
        const val ACCOUNT_BOOK_ACTIVITY = "/account/account/AccountBookActivity"
    }
}