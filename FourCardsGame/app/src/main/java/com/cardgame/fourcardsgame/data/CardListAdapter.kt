package com.cardgame.fourcardsgame.data

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.cardgame.fourcardsgame.R
import com.cardgame.fourcardsgame.model.Card

class CardListAdapter(private val list: ArrayList<Card>,
                      private val context: Context) : RecyclerView.Adapter<CardListAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItem(card: Card) {
            var cardPic: ImageView = itemView.findViewById(R.id.img_cardId)

        // Todo: set to imageView a picture of card's back or face
               cardPic.setBackgroundResource(R.drawable.back)


            itemView.setOnClickListener {
                cardPic.setBackgroundResource(card.face)
                Toast.makeText(context, "$card.rank, $card.suit", Toast.LENGTH_LONG).show()
        }

        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.card, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder?.bindItem(list[position])
    }

}