package com.abdullojon.memorygame.domain


import com.abdullojon.memorygame.R
import com.abdullojon.memorygame.model.CardData
import com.abdullojon.memorygame.model.LevelEnum

object AppRepository {
    private val cardList= ArrayList<CardData>()

    init {
        cardList.add(CardData(1, R.drawable.image_1))
        cardList.add(CardData(2, R.drawable.image_2))
        cardList.add(CardData(3, R.drawable.image_3))
        cardList.add(CardData(4, R.drawable.image_4))
        cardList.add(CardData(5, R.drawable.image_5))
        cardList.add(CardData(6, R.drawable.image_6))
        cardList.add(CardData(7, R.drawable.image_7))
        cardList.add(CardData(8, R.drawable.image_8))
        cardList.add(CardData(9, R.drawable.image_9))
        cardList.add(CardData(10, R.drawable.image_10))
        cardList.add(CardData(11, R.drawable.image_11))
        cardList.add(CardData(12, R.drawable.image_12))
        cardList.add(CardData(13, R.drawable.image_13))
        cardList.add(CardData(14, R.drawable.image_14))
        cardList.add(CardData(15, R.drawable.image_15))
        cardList.add(CardData(16, R.drawable.image_16))
        cardList.add(CardData(17, R.drawable.image_17))
        cardList.add(CardData(18, R.drawable.image_18))
        cardList.add(CardData(19, R.drawable.image_19))
        cardList.add(CardData(20, R.drawable.image_20))
        cardList.add(CardData(21, R.drawable.image_21))
        cardList.add(CardData(22, R.drawable.image_22))
        cardList.add(CardData(23, R.drawable.image_23))
        cardList.add(CardData(24, R.drawable.image_24))
        cardList.add(CardData(25, R.drawable.image_25))
    }

    fun getCardListByLevel(level: LevelEnum) : List<CardData> {
        val count = level.horizontalCount * level.verticalCount/ 2
        cardList.shuffle()

        val ls = ArrayList<CardData>()
        ls.addAll(cardList.subList(0, count))
        ls.addAll(ls)
        ls.shuffle()
        return ls
    }
}
