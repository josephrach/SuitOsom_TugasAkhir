package com.example.suitosomand12binar.presenter.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.binar_challenge_chp5.ui.main.VersusPemainActivity
import com.example.suitosomand12binar.activity.InputPlayer1Activity
import com.example.suitosomand12binar.databinding.ActivityInsertUserChooseBinding
import com.example.suitosomand12binar.sources.database.UserChooseDatabase
import com.example.suitosomand12binar.sources.dataclass.UserChoose
import com.example.suitosomand12binar.sources.interfaces.UserChooseDao
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class InsertUserChooseActivity : AppCompatActivity() {

    private var _binding: ActivityInsertUserChooseBinding? = null
    private lateinit var binding: ActivityInsertUserChooseBinding

    private val userChooseDatabase: UserChooseDatabase? by lazy {
        UserChooseDatabase.getInstance(this)
    }

    private val userChooseDao: UserChooseDao? by lazy {
        userChooseDatabase?.userChooseDao()
    }

    companion object {
        const val PLAYER_TWO = "player_two"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityInsertUserChooseBinding.inflate(layoutInflater)
        binding = requireNotNull(_binding)
        setContentView(binding.root)

        setupView()

    }

    private fun setupView() {

        val getNamePlayeOne = intent.getStringExtra(InputPlayer1Activity.PLAYER_ONE)

        binding.btnUserInsertChoose.setOnClickListener {
            val name: String = binding.etUserInsertChose.text.toString()

            val newChoiseUser = UserChoose(
                name = name
            )

            saveToDatabase(newChoiseUser)

            val intent = Intent(this, VersusPemainActivity::class.java)
            intent.putExtra(PLAYER_TWO, newChoiseUser.name)
            intent.putExtra(InputPlayer1Activity.PLAYER_ONE, getNamePlayeOne)

            Toast.makeText(this, "Halo Selamat Datang ${newChoiseUser.name}", Toast.LENGTH_SHORT)
                .show()
            startActivity(intent)
            finish()
        }
    }

    private fun saveToDatabase(userChoose: UserChoose) {

        GlobalScope.launch {
            val addUser = userChooseDao?.addUser(userChoose)
            println("new added userChoose ---> $addUser")

            runOnUiThread {
                binding.etUserInsertChose.setText("")
            }
        }

    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}