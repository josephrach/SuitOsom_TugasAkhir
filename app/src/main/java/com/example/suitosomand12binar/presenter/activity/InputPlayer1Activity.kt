package com.example.suitosomand12binar.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.suitosomand12binar.R
import com.example.suitosomand12binar.databinding.ActivityInputp1Binding
import com.example.suitosomand12binar.dataclass.Pemain1
import com.example.suitosomand12binar.presenter.activity.UserChosePlayerTwo
import com.example.suitosomand12binar.sources.database.PermainanDatabase
import com.example.suitosomand12binar.sources.interfaces.Pemain1Dao
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class InputPlayer1Activity : AppCompatActivity() {
    private var _binding: ActivityInputp1Binding? = null
    private lateinit var binding: ActivityInputp1Binding

    lateinit var namaPemain: String
    private val permainanDatabase: PermainanDatabase? by lazy {
        PermainanDatabase.getInstance(this)
    }
    private val pemain1Dao: Pemain1Dao? by lazy {
        permainanDatabase?.pemain1Dao()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityInputp1Binding.inflate(layoutInflater)
        binding = requireNotNull(_binding)
        setContentView(binding.root)

        inputNama()
    }

    fun inputNama() {
        val etNama = findViewById<EditText>(R.id.et_nama)
        val btnSubmit = findViewById<Button>(R.id.btn_submit)
        val intentToMenu: Intent

        btnSubmit?.setOnClickListener() {
            namaPemain = etNama.text.toString()

            val newPemain1 = Pemain1(
                id = 1,
                nama = namaPemain,
                score = 0
            )
            saveToDatabase(pemain = newPemain1)

            val intentToMenu = Intent(this, UserChosePlayerTwo::class.java)
            intentToMenu.putExtra("playertwo", newPemain1.nama)
            Toast.makeText(this, "Halo Selamat Datang ${newPemain1.nama}", Toast.LENGTH_SHORT)
                .show()
            startActivity(intentToMenu)
        }

        runOnUiThread() {
            etNama.setText("")
        }


    }

    private fun saveToDatabase(pemain: Pemain1) {
        GlobalScope.launch {
            val addUser = pemain1Dao?.insertPemain1(pemain)
            println("user has added -->> $addUser")
        }
    }

    fun fetchData() {
        GlobalScope.launch {
            val pemain1Data = pemain1Dao?.getAllPemain1().orEmpty()
            println("ini database ${pemain1Data}")
        }
    }
}