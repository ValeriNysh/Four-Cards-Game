package com.cardgame.fourcardsgame.model

enum class Suits {
    HEARTS,
    SPADES,
    DIAMONDS,
    CLUBES
}

enum class Ranks {
    ACE,
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    TEN,
    JACK,
    QUEEN,
    KING,
    JOKER
}


class Card(suit:Suits?=null, rank:Ranks?=null, face:Int) {
    var suit: Suits? = null
    var rank: Ranks? = null
    var face: Int = 0

    init {
        this.suit = suit
        this.rank = rank
        this.face = face
    }

}