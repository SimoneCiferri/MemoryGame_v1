package com.mrlp.memorygame.viewmodel

import android.widget.ImageButton
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mrlp.memorygame.model.Card

class GameViewModel : ViewModel() {

    private lateinit var cards: List<Card>
    private var milliStart: Long = 0
    private var milliStop: Long = 0
    private var timeInMillis: Long = 0
    private var indexOfSelectedCard: Int? = null
    private val _CHECK_ERROR: Int = 0
    private val _FIRSTCARD: Int = 1
    private val _CARD_MATCHED: Int = 2
    private val _CARD_NOT_MATCHED: Int = 3
    private var _error = MutableLiveData<Int>().apply {
        value = 0
    }

    var error: LiveData<Int> = _error

    private fun resetErrors(){
        _error.value = 0
    }

    fun newGame(images: MutableList<Int>, buttons: List<ImageButton>) {
        cards = buttons.indices.map { index ->
            Card(images[index])
        }
        for(card in cards){
            card.isMatched = false
            card.isFaceUp = false
        }
        resetErrors()
        indexOfSelectedCard = null
        milliStart = System.currentTimeMillis()
    }

    fun increaseErrors(){
        _error.value = error.value?.plus(1)
    }

    fun getCards(): List<Card> {
        return cards
    }

    fun updateModel(cardPosition: Int): Int {
        val card = cards[cardPosition]
        if(card.isFaceUp){
            return _CHECK_ERROR
        }else{
            val checkRes: Int
            if(indexOfSelectedCard == null){
                restoreCards()
                indexOfSelectedCard = cardPosition
                checkRes = _FIRSTCARD
            }else{
                checkRes = checkForMatch(indexOfSelectedCard!!, cardPosition)
                indexOfSelectedCard = null
            }
            card.isFaceUp = !card.isFaceUp
            return checkRes
        }
    }

    private fun checkForMatch(indexOfSelectedCard: Int, cardPosition: Int): Int {
        if(cards[indexOfSelectedCard].ID == cards[cardPosition].ID){
            cards[indexOfSelectedCard].isMatched = true
            cards[cardPosition].isMatched = true
            return _CARD_MATCHED
        }else{
            return _CARD_NOT_MATCHED
        }
    }

    private fun restoreCards(){
        for(card in cards){
            if(!card.isMatched){
                card.isFaceUp = false
            }
        }
    }

    fun getIndexOfPrevCard(): Int? {
        return indexOfSelectedCard
    }

}