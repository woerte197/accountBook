package com.wangyang.tinner.dagger.compontent

import com.wangyang.accountbook.home.MainActivity
import com.wangyang.tinner.dagger.moudle.MainMoudle
import dagger.Component

@Component(modules = [MainMoudle::class])
interface MainComment {

    fun inject(activity: MainActivity)
}