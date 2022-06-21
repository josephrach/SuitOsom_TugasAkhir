package com.example.suitosomand12binar.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.suitosomand12binar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewPagerAdapter: LandingPageVpAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        binding = requireNotNull(_binding)
        setContentView(binding.root)

        checkPlayer1()

    }

    fun setScreenLp() {
        var intent: Intent

        intent = Intent(this, SplashscreenActivity::class.java)
        startActivity(intent)

    }

    fun setScreenMain() {

    }

    fun checkPlayer1() {
        val p1Exist: Boolean = false

        when (p1Exist) {
            false -> {
                setScreenLp()
                finish()
            }
            true -> {
                setScreenMain()
            }
        }
    }

}