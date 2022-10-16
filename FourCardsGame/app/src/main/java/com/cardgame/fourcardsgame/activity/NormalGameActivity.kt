package com.cardgame.fourcardsgame.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cardgame.fourcardsgame.R
import com.cardgame.fourcardsgame.data.CardListAdapter
import com.cardgame.fourcardsgame.model.Card
import com.cardgame.fourcardsgame.model.Ranks
import com.cardgame.fourcardsgame.model.Suits
import kotlinx.android.synthetic.main.activity_normal_game.*

class NormalGameActivity : AppCompatActivity(), View.OnClickListener {
    private var adapter: CardListAdapter? = null
    private var myCardList: ArrayList<Card>? = null
    private var layoutManager: RecyclerView.LayoutManager? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_normal_game)

        myCardList = ArrayList<Card>()
        layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        adapter = CardListAdapter(myCardList!!, this)

        //Initializing a whole DECK of cards
        var i = 1
        var deck = ArrayList<Card>(54)
        for (suit in Suits.values())
            for (rank in 0..Ranks.values().size-2) {
                val card = Card(suit, Ranks.values()[rank], resources.getIdentifier("card$i", "drawable", packageName))
                deck.add(card)
                i++
            }
        deck.add(Card(Suits.HEARTS, Ranks.JOKER, resources.getIdentifier("card$i", "drawable", packageName)))
        deck.add(Card(Suits.SPADES, Ranks.JOKER, resources.getIdentifier("card"+ (i+1), "drawable", packageName)))

        // setup list Recyclerview
        rv_myCardsId.layoutManager = layoutManager
        rv_myCardsId.adapter = adapter
        //load data
        for (item in 0..3) {
            var card = deck.random()
            myCardList!!.add(card)
            deck.remove(card)
        }
        adapter!!.notifyDataSetChanged()



        // Иконка и имя пользователя на экране во время игры
        var data = intent.extras
        if(data != null) {
            var playerName = data.get("playerName")
            // Сейчас это неправильно! Введенное имя должно присваиваться не опоненту, а игроку.
            lbl_opNameId.text = playerName.toString()
        }

//        var myCard1 = myCard1_Id
//        myCard1.setOnClickListener(this)



    }

    override fun onClick(v: View?) {
        when(v!!.id) {
            opCard1_Id.id -> {
                Toast.makeText(this, "You are a very huge patsuk", Toast.LENGTH_LONG).show()

            }
        }
    }
}


