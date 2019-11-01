package com.ale.navigationgraphtutorial

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_specify_amount.*
import java.math.BigDecimal

class SpecifyAmountFragment : Fragment() {

    private lateinit var navController: NavController
    private lateinit var recipient: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        recipient = arguments!!.getString("recipient").toString()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_specify_amount, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        val message = "Sending money to $recipient"
        tvRecipient.text = message

        bCancel.setOnClickListener {
            activity!!.onBackPressed()
        }

        bSend.setOnClickListener {
            val amountString = etInputAmount.text.toString()

            if (!TextUtils.isEmpty(amountString)) {
                val amount = Money(BigDecimal(amountString))
                val bundle = bundleOf(
                    "recipient" to recipient,
                    "amount" to amount
                )

                navController.navigate(R.id.action_specifyAmountFragment_to_confirmationFragment, bundle)
            }
            else {
                Toast.makeText(activity, "Enter a vaid amount", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
