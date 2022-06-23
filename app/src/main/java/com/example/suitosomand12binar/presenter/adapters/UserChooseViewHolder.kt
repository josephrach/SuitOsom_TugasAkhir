package com.example.suitosomand12binar.presenter.adapters

import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.binar_challenge_chp5.ui.main.VersusPemainActivity
import com.example.suitosomand12binar.activity.InputPlayer1Activity
import com.example.suitosomand12binar.databinding.ItemRecyclerViewChooseOpponentBinding
import com.example.suitosomand12binar.presenter.activity.InsertUserChooseActivity
import com.example.suitosomand12binar.sources.dataclass.UserChoose

class UserChooseViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val playerOne = Intent()
    val plyaerOneInt = playerOne.getStringExtra(InputPlayer1Activity.PLAYER_ONE)

    fun bind(userChoose: UserChoose) = ItemRecyclerViewChooseOpponentBinding.bind(itemView).run {

        tvItemChooseOpponent.text = userChoose.name

        itemView.setOnClickListener {
            val intent = Intent(itemView.context, VersusPemainActivity::class.java).apply {
                putExtra(InsertUserChooseActivity.PLAYER_TWO, position)
                putExtra(InsertUserChooseActivity.PLAYER_TWO, tvItemChooseOpponent.text)

                putExtra(InputPlayer1Activity.PLAYER_ONE, position)
                putExtra(InputPlayer1Activity.PLAYER_ONE, plyaerOneInt)
            }

            /*val intetPlayerOne = Intent(itemView.context)
            val getNamePlayeOne =
                itemView.context.intent.getStringExtra(InputPlayer1Activity.PLAYER_ONE)
            putExtra(InputPlayer1Activity.PLAYER_ONE, getNamePlayeOne)*/

            Toast.makeText(
                itemView.context,
                "Halo Selamat Datang ${userChoose.name}",
                Toast.LENGTH_SHORT
            )
                .show()

            itemView.context.startActivity(intent)
        }

    }


}