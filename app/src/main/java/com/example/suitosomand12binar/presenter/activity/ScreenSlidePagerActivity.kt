package com.example.suitosomand12binar.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.suitosomand12binar.R
import com.example.suitosomand12binar.view.fragment.InputnameFragment
import com.example.suitosomand12binar.view.fragment.Landingpage1Fragment
import com.example.suitosomand12binar.view.fragment.Landingpage2Fragment

class ScreenSlidePagerActivity: AppCompatActivity() {

    init {
        println("ini ScreenSlidePagerActivity")
    }

    private lateinit var viewPager : ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen_slide)

        setViewPager()
    }

    fun setViewPager(){
        //ngambil view pager di layout activitu_screen_slide

        viewPager = findViewById(R.id.pager)

        val pageAdapter = LandingPageVpAdapter(supportFragmentManager)
//        viewPager.adapter = pageAdapter

        val lp1Frag = Landingpage1Fragment()
        val lp2Frag = Landingpage2Fragment()

        val fragmentList = listOf(
            lp1Frag,lp2Frag
        )
        pageAdapter.addFragmentList(fragmentList)
        viewPager.adapter = pageAdapter
    }


}