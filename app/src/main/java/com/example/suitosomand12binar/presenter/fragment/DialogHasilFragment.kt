package com.example.suitosomand12binar.presenter.fragment

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.binar_challenge_chp5.data.CallbackDialog
import com.example.suitosomand12binar.R
import java.lang.Exception

class DialogHasilFragment : DialogFragment() {
    private var callbackDialog: CallbackDialog? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return inflater.inflate(R.layout.fragment_dialog_hasil, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnMainLagi = view.findViewById<Button>(R.id.btnMainLagi)
        val btnMenu = view.findViewById<Button>(R.id.btnMenu)
        val tvHasil = view.findViewById<TextView>(R.id.tvHasil)

        if (arguments != null) {
            val hasil = arguments?.getString("result", "")

            tvHasil.text = hasil
        }

        btnMainLagi.setOnClickListener {
            dismiss()
            callbackDialog?.resetGame(
                android.R.color.transparent,
                resultPlayer1 = "",
                resultPlayer2 = ""
            )
        }

        btnMenu.setOnClickListener {
            activity?.finish()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            callbackDialog = context as CallbackDialog
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}