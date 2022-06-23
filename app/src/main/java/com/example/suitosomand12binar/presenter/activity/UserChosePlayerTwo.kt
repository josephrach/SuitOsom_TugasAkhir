package com.example.suitosomand12binar.presenter.activity

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.suitosomand12binar.R
import com.example.suitosomand12binar.activity.InputPlayer1Activity

class UserChosePlayerTwo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_chose)

        val tvPlayerTwo = findViewById<TextView>(R.id.tv_chose_player)

        val intent = intent.getStringExtra(InputPlayer1Activity.NAME_PLAYER)
        val greating = "Halo Selamat Datang $intent"

        tvPlayerTwo.text = greating

        supportActionBar?.title = greating?.uppercase()


    }
}