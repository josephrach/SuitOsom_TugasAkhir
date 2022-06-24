package com.example.suitosomand12binar.presenter.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.suitosomand12binar.activity.InputPlayer1Activity
import com.example.suitosomand12binar.databinding.ActivityChooseAnOpponentBinding
import com.example.suitosomand12binar.presenter.adapters.UserChooseAdapter
import com.example.suitosomand12binar.presenter.fragment.PlayFragment
import com.example.suitosomand12binar.sources.database.UserChooseDatabase
import com.example.suitosomand12binar.sources.interfaces.UserChooseDao
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ChooseAnOpponentActivity : AppCompatActivity() {

    private var _binding: ActivityChooseAnOpponentBinding? = null
    private lateinit var binding: ActivityChooseAnOpponentBinding

    private val userChooseAdapter = UserChooseAdapter()

    private val userChooseDatabase: UserChooseDatabase? by lazy {
        UserChooseDatabase.getInstance(this)
    }
    private val userChooseDao: UserChooseDao? by lazy {
        userChooseDatabase?.userChooseDao()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityChooseAnOpponentBinding.inflate(layoutInflater)
        binding = requireNotNull(_binding)

        setContentView(binding.root)
        setupView()

    }

    private fun setupView() {
        val linearLayoutManager = LinearLayoutManager(this)
        binding.rvChoseOpponent.layoutManager = linearLayoutManager
        binding.rvChoseOpponent.adapter = userChooseAdapter

        val getNamePlayeOne = intent.getStringExtra(InputPlayer1Activity.PLAYER_ONE)
        binding.btnChoosplayer.setOnClickListener {
            val intent = Intent(this, InsertUserChooseActivity::class.java)
            intent.putExtra(InputPlayer1Activity.PLAYER_ONE, getNamePlayeOne)
            startActivity(intent)
            finish()
        }

        getUserDatabase()
    }

    private fun getUserDatabase() {
        GlobalScope.launch {
            val userData = userChooseDao?.getAllUser().orEmpty()
            runOnUiThread {
                userChooseAdapter.addList(userData)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        getUserDatabase()

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}