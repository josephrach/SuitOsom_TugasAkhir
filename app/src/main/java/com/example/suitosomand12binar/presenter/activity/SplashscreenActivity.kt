package com.example.suitosomand12binar.activity

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.suitosomand12binar.R
import com.example.suitosomand12binar.databinding.ActivityMainBinding
import android.os.Handler

class SplashscreenActivity: AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        setDelaynMove()

        supportActionBar?.hide()
    }

    public fun setDelaynMove(){
        val handler = Handler()
        handler.postDelayed({
            val intent = Intent(this, ScreenSlidePagerActivity::class.java)
            startActivity(intent)
            finish()
        },3000)
    }
}