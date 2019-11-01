package com.ale.navigationgraphtutorial

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_confirmation.*

class ConfirmationFragment : Fragment() {

    private lateinit var recipient: String
    private lateinit var money: Money

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        recipient = arguments!!.getString("recipient").toString()
        money = arguments!!.getParcelable<Money>("amount")!!
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_confirmation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val amount = money.amount
        val message = "You have sent $amount to $recipient"

        tvConfirmationMessage.text = message
    }
}
