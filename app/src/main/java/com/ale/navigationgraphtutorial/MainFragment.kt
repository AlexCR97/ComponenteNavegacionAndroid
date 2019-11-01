package com.ale.navigationgraphtutorial

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation

import kotlinx.android.synthetic.main.fragment_main.bViewTransactions
import kotlinx.android.synthetic.main.fragment_main.bSendMoney
import kotlinx.android.synthetic.main.fragment_main.bViewBalance

class MainFragment : Fragment(), View.OnClickListener {

    private lateinit var navController: NavController

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        bSendMoney.setOnClickListener(this)
        bViewBalance.setOnClickListener(this)
        bViewTransactions.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.bSendMoney -> navController.navigate(R.id.action_mainFragment_to_chooseRecipientFragment)
            R.id.bViewBalance -> navController.navigate(R.id.action_mainFragment_to_viewBalanceFragment2)
            R.id.bViewTransactions -> navController.navigate(R.id.action_mainFragment_to_viewTransactionFragment)
        }
    }
}
