package com.example.suitosomand12binar.presenter.activity

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.suitosomand12binar.R
import com.example.suitosomand12binar.activity.InputPlayer1Activity
import com.example.suitosomand12binar.databinding.ActivityGameMenuBinding
import com.example.suitosomand12binar.presenter.fragment.HistoryFragment
import com.example.suitosomand12binar.presenter.fragment.LeaderboardFragment
import com.example.suitosomand12binar.presenter.fragment.PlayFragment
import com.google.android.material.snackbar.Snackbar

class GameMenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGameMenuBinding

    private val leaderboarFragment = LeaderboardFragment()
    private val historyFragment = HistoryFragment()
    private val playFragmnet = PlayFragment()

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(playFragmnet)

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_first_fragment -> replaceFragment(playFragmnet)
                R.id.menu_second_fragment -> replaceFragment(leaderboarFragment)
                R.id.menu_trird_Fragment -> replaceFragment(historyFragment)
            }
            true
        }
        supportActionBar?.hide()


        val intent = intent.getStringExtra(InputPlayer1Activity.PLAYER_ONE)

        Snackbar.make(
            findViewById(R.id.main_layout),
            "Selamat Datang ${intent}",
            Snackbar.LENGTH_LONG
        ).setAction("TUTUP") {
        }.show()

    }

    private fun replaceFragment(fragment: Fragment) {
        if (fragment != null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container_view, fragment)
            transaction.commit()
        }
    }
}