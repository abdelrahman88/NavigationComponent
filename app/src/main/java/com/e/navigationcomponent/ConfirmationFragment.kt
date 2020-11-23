package com.e.navigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.Navigation

class ConfirmationFragment : Fragment() {
     lateinit var navController: NavController
    lateinit var recipient : String
    lateinit var money: Money

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recipient = requireArguments().getString("recipient")!!
        money = requireArguments().getParcelable("amount")!!
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_confirmation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        val amount = money.amount
        val confirmation_message = "you have sent $$amount To $recipient"
        view.findViewById<TextView>(R.id.confirmation_message).text = confirmation_message
        view.findViewById<Button>(R.id.go_home).setOnClickListener {
            navController.navigate(R.id.action_confirmationFragment_to_mainFragment)
        }
    }
}