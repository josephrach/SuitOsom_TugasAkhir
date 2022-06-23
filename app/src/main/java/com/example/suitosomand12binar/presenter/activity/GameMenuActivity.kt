package com.example.suitosomand12binar.presenter.activity

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.example.binar_challenge_chp5.ui.main.VersusCPUActivity
import com.example.binar_challenge_chp5.ui.main.VersusPemainActivity
import com.example.suitosomand12binar.R
import com.google.android.material.snackbar.Snackbar

class GameMenuActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_menu)

        val name = intent.getStringExtra("nama1")
        val txtVsCPU = findViewById<TextView>(R.id.txtVsCPU)
        txtVsCPU.text = "$name vs CPU"
        val imgVsCPU = findViewById<ImageView>(R.id.imgVsCPU)
        imgVsCPU.setOnClickListener {
            val intent = Intent(this, VersusCPUActivity::class.java)
            intent.putExtra("nama1", name)
            startActivity(intent)
        }

        val txtVsPemain = findViewById<TextView>(R.id.txtVsPemain)
        txtVsPemain.text = "$name vs Pemain"
        val imgVsPemain = findViewById<ImageView>(R.id.imgVsPemain)
        imgVsPemain.setOnClickListener {
            val intent = Intent(this, VersusPemainActivity::class.java)
            intent.putExtra("nama1", name)
            startActivity(intent)
        }

        Snackbar.make(
            findViewById(R.id.viewGameMenu),
            "Selamat Datang $name",
            Snackbar.LENGTH_LONG
        ).setAction("TUTUP") {
        }.show()
    }
}