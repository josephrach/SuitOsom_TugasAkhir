package com.example.binar_challenge_chp5.ui.main

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.binar_challenge_chp5.data.Callback
import com.example.binar_challenge_chp5.data.CallbackDialog
import com.example.suitosomand12binar.R
import com.example.suitosomand12binar.activity.InputPlayer1Activity
import com.example.suitosomand12binar.databinding.ActivityVersusCpuBinding
import com.example.suitosomand12binar.presenter.fragment.DialogHasilFragment
import com.example.suitosomand12binar.sources.data.Controller

@RequiresApi(Build.VERSION_CODES.M)
class VersusCPUActivity : AppCompatActivity(), Callback, CallbackDialog {
    private lateinit var binding: ActivityVersusCpuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVersusCpuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra(InputPlayer1Activity.NAME_PLAYER)
        binding.txtPlayer1.text = name

        val btnPlayer1 = arrayOf(
            binding.imgBatu1,
            binding.imgKertas1,
            binding.imgGunting1,
        )
        val btnComputer = arrayOf(
            binding.imgBatu2,
            binding.imgKertas2,
            binding.imgGunting2,
        )

        val controller = Controller(this)
        btnPlayer1.forEachIndexed { index, imageView ->
            imageView.setOnClickListener {
                val hasilKomputer = btnComputer.random()
                Log.d("${btnPlayer1[index].contentDescription}", "Pemain click")
                Log.d("$hasilKomputer", "Komputer Memilih")
                hasilKomputer.setBackgroundResource(R.drawable.shape_rectangle_8_ffc700)
                disableClick(false)
                controller.checkResult(
                    btnPlayer1[index].contentDescription.toString(),
                    hasilKomputer.contentDescription.toString(),
                    name,
                    "COM"
                )
                Toast.makeText(
                    this, "${btnPlayer1[index].contentDescription}", Toast.LENGTH_SHORT
                ).show()
                btnPlayer1.forEach {
                    it.setBackgroundResource(android.R.color.transparent)
                }
                btnPlayer1[index].setBackgroundResource(R.drawable.shape_rectangle_8_ffc700)
            }
        }

        binding.imgRefresh.setOnClickListener {
            Toast.makeText(this, "Reset", Toast.LENGTH_SHORT).show()
            Log.d("Reset", "Reset click")
            resetGame(android.R.color.transparent, "", "")
        }

        val ivClose1 = findViewById<ImageView>(R.id.imgClose)
        ivClose1.setOnClickListener {
            finish()
        }
    }

    private fun disableClick(isEnable: Boolean) {
        binding.imgBatu1.isEnabled = isEnable
        binding.imgKertas1.isEnabled = isEnable
        binding.imgGunting1.isEnabled = isEnable
    }

    override fun result(result: String) {
        val dialogHasil = DialogHasilFragment()
        val bundle = Bundle()
        bundle.putString("result", result)
        dialogHasil.arguments = bundle
        dialogHasil.show(supportFragmentManager, "DialogResult")
    }

    override fun resetGame(background: Int, resultPlayer1: String, resultPlayer2: String) {
        binding.imgBatu1.setBackgroundResource(background)
        binding.imgKertas1.setBackgroundResource(background)
        binding.imgGunting1.setBackgroundResource(background)
        binding.imgBatu2.setBackgroundResource(background)
        binding.imgKertas2.setBackgroundResource(background)
        binding.imgGunting2.setBackgroundResource(background)
        disableClick(true)
    }
}