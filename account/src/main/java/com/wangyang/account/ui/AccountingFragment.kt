package com.wangyang.account.ui


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wangyang.account.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 *
 */
class AccountingFragment : Fragment() {

    companion object {
        const val ACCOUNTING_TYPE = "ACCOUNTING_TYPE"
        fun newInstance(type: Int): Fragment {
            val arg = Bundle()
            arg.putSerializable(ACCOUNTING_TYPE, type)
            val fragment = AccountingFragment()
            fragment.arguments = arg
            return fragment
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_accounting, container, false)
    }


}
