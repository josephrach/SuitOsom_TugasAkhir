package com.example.suitosomand12binar.presenter.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.binar_challenge_chp5.ui.main.VersusCPUActivity
import com.example.suitosomand12binar.activity.InputPlayer1Activity
import com.example.suitosomand12binar.databinding.FragmentPlayBinding
import com.example.suitosomand12binar.presenter.activity.ChooseAnOpponentActivity

class PlayFragment : Fragment() {

    private var _binding: FragmentPlayBinding? = null
    private lateinit var binding: FragmentPlayBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPlayBinding.inflate(inflater, container, false)
        binding = requireNotNull(_binding)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        /*binding.run {
            btnPlayerVsPlayer.setOnClickListener {
                val intent = Intent(context, ChooseAnOpponentActivity::class.java)
                startActivity(intent)
            }
        }*/

        val name = activity?.intent?.getStringExtra(InputPlayer1Activity.PLAYER_ONE)
        binding.txtVsCPU.text = "$name vs CPU"
        binding.imgVsCPU.setOnClickListener {
            val intent = Intent(context, VersusCPUActivity::class.java)
            intent.putExtra(InputPlayer1Activity.PLAYER_ONE, name)
            startActivity(intent)
        }

        binding.txtVsPemain.text = "$name vs Pemain"
        binding.imgVsPemain.setOnClickListener {
            /*val intent = Intent(context, VersusPemainActivity::class.java)
            intent.putExtra(InputPlayer1Activity.NAME_PLAYER, name)
            startActivity(intent)*/

            val intent = Intent(context, ChooseAnOpponentActivity::class.java)
            intent.putExtra(InputPlayer1Activity.PLAYER_ONE, name)
            startActivity(intent)

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}