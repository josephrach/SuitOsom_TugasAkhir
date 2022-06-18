package com.example.suitosomand12binar.view.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.suitosomand12binar.R
import com.example.suitosomand12binar.activity.MainActivity
import com.example.suitosomand12binar.activity.ScreenSlidePagerActivity
import com.example.suitosomand12binar.presenter.activity.UserChose

class InputnameFragment : Fragment() {

    val acMain = MainActivity()
    val vPager = ScreenSlidePagerActivity()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.activity_inputp1, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnInputName = view.findViewById<Button>(R.id.btn_submit)

        btnInputName.setOnClickListener {
            val intentToInput = Intent(context, UserChose::class.java)
            startActivity(intentToInput)
            activity?.finish()
        }
    }

}