package com.example.router_lib.router

import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.launcher.ARouter
import com.example.router_lib.provider.moudle.home.IHomeProvider
import com.example.router_lib.provider.moudle.news.INewsProvider
import com.example.router_lib.provider.moudle.user.IUserProvider
import com.wangyang.router_lib.provider.moudle.account.IAccountProvider

class RouterManager {

    companion object {
        val INS: RouterManager by lazy { RouterManager() }
    }

    init {
        ARouter.getInstance().inject(this)
    }

    @JvmField
    @Autowired
    var homeProvider: IHomeProvider? = null


    @JvmField
    @Autowired
    var userProvider: IUserProvider? = null


    @JvmField
    @Autowired
    var newsProvider: INewsProvider? = null

    @JvmField
    @Autowired
    var accountProvider: IAccountProvider? = null

    fun getMainProvider(): IHomeProvider {
        if (null == homeProvider) {
            homeProvider = ARouter.getInstance().build(IHomeProvider.HOME_SERVICE).navigation() as IHomeProvider
        }
        return homeProvider as IHomeProvider
    }


    fun getAccountProvider(): IAccountProvider {
        if (null == accountProvider) {
            accountProvider = ARouter.getInstance().build(IAccountProvider.ACCOUNT_SERVICE).navigation() as IAccountProvider
        }
        return accountProvider as IAccountProvider
    }

    fun getNewsProvider(): INewsProvider {
        if (null == newsProvider) {
            newsProvider = ARouter.getInstance().build(INewsProvider.NEWS_SERVICE).navigation() as INewsProvider
        }
        return newsProvider as INewsProvider
    }

    fun getUserProvider(): IUserProvider {
        if (null == userProvider) {
            userProvider = ARouter.getInstance().build(IUserProvider.USER_SERVICE).navigation() as IUserProvider
        }
        return userProvider as IUserProvider
    }

}