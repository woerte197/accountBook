package com.wangyang.account.ui


import android.os.Bundle
import android.support.v4.app.Fragment
import com.wangyang.account.R
import com.wangyang.account.adapter.MyGridAdapter
import com.wangyang.account.ui.presenter.AccountingFragmentPresenter
import com.wangyang.baselibrary.ui.fragment.BaseMvpFragment
import kotlinx.android.synthetic.main.fragment_accounting.*

/**
 * A simple [Fragment] subclass.
 *
 */
class AccountingFragment : BaseMvpFragment<AccountingFragmentPresenter>() {
    override fun setLayout(): Int {
        return R.layout.fragment_accounting
    }

    private var mAccountType: Int? = 0

    companion object {
        private const val ACCOUNTING_TYPE = "ACCOUNTING_TYPE"
        fun newInstance(type: Int): Fragment {
            val arg = Bundle()
            arg.putSerializable(ACCOUNTING_TYPE, type)
            val fragment = AccountingFragment()
            fragment.arguments = arg
            return fragment
        }
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initData()
        initView()
    }

    private fun initView() {
        var list = mutableListOf("你好", "你好", "你好", "你好", "你好", "你好")
        mGridView.adapter = MyGridAdapter(context!!, list)
    }

    private fun initData() {
        mAccountType = arguments?.getSerializable(ACCOUNTING_TYPE) as Int
        when (mAccountType) {
            0 -> {
            }
            1 -> {
            }
            2 -> {
            }
            3 -> {
            }
        }
    }

}
