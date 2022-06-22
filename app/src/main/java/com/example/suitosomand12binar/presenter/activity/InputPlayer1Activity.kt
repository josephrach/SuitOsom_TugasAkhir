package com.example.suitosomand12binar.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.suitosomand12binar.R
import com.example.suitosomand12binar.databinding.ActivityMainBinding
import com.example.suitosomand12binar.dataclass.Pemain1
import com.example.suitosomand12binar.sources.database.PermainanDatabase
import com.example.suitosomand12binar.sources.interfaces.Pemain1Dao
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class InputPlayer1Activity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private lateinit var binding: ActivityMainBinding

    lateinit var namaPemain: String
    private val permainanDatabase: PermainanDatabase? by lazy {
        PermainanDatabase.getInstance(this)
    }
    private val pemain1Dao: Pemain1Dao? by lazy {
        permainanDatabase?.pemain1Dao()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        binding = requireNotNull(_binding)
        setContentView(R.layout.activity_inputp1)

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
        }

        runOnUiThread() {
            etNama.setText("")
        }

//        intentToMenu = Intent(this, MainActivity::class.java)
//        startActivity(intentToMenu)
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