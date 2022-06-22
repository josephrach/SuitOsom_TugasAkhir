package com.example.suitosomand12binar.view.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.suitosomand12binar.activity.MainActivity
import com.example.suitosomand12binar.activity.ScreenSlidePagerActivity
import com.example.suitosomand12binar.databinding.ActivityInputp1Binding
import com.example.suitosomand12binar.presenter.activity.UserChosePlayerTwo

//not used

class InputnameFragment : Fragment() {

    private var _binding: ActivityInputp1Binding? = null
    private val binding get() = _binding!!

    val acMain = MainActivity()
    val vPager = ScreenSlidePagerActivity()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ActivityInputp1Binding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.btnSubmit.setOnClickListener {
            println("hello button where are you")
            val intentToInput = Intent(view.context, UserChosePlayerTwo::class.java)
            startActivity(intentToInput)
            activity?.finish()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}