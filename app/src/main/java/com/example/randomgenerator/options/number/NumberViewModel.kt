package com.example.randomgenerator.options.number

import androidx.lifecycle.ViewModel
import kotlin.random.Random

class NumberViewModel: ViewModel() {
    fun onChoose(from: Int, to: Int, num: Int) : List<Int>{
        val list = mutableListOf<Int>()
        for (i in 1..num){
            list.add(Random.nextInt(from, to+1))
        }
        return list
    }
    fun onChooseDifferent(from: Int, to: Int, num: Int) : List<Int>{
        val list = mutableListOf(from..to).flatten()
        val quantity = if (num > list.size)
            list.size
        else
            num
        return list.shuffled().subList(0, quantity)
    }
}