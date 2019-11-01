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
import kotlinx.android.synthetic.main.fragment_choose_recipient.*

class ChooseRecipientFragment : Fragment() {

    private lateinit var navController: NavController

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_choose_recipient, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        bCancel.setOnClickListener {
            activity!!.onBackPressed()
        }

        bNext.setOnClickListener {
            val name: String = etName.text.toString()

            if (!TextUtils.isEmpty(name)) {
                val bundle: Bundle = bundleOf("recipient" to name)
                navController.navigate(R.id.action_chooseRecipientFragment_to_specifyAmountFragment, bundle)
            }
            else {
                Toast.makeText(activity, "Enter a recipient", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
