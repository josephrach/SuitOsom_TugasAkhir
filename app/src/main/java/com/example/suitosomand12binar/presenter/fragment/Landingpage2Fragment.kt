package com.example.suitosomand12binar.view.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.suitosomand12binar.R
import com.example.suitosomand12binar.activity.InputPlayer1Activity

class Landingpage2Fragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_landingpage2, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnLp2 = view.findViewById<Button>(R.id.btn_lp2)

        btnLp2.setOnClickListener() {
            val intentToInput = Intent(view.context, InputPlayer1Activity::class.java)
            startActivity(intentToInput)
            activity?.finish()
        }
    }
}