package com.example.randomgenerator.options.number

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class NumberViewModel: ViewModel() {
    private val _outString = MutableLiveData<String>()
    val outString: MutableLiveData<String>
        get() = _outString

    fun onChoose(from: Int, to: Int, num: Int) {
        val list = mutableListOf<Int>()
        for (i in 1..num){
            list.add(Random.nextInt(from, to+1))
        }
        _outString.value =  list.toString()
    }
    fun onChooseDifferent(from: Int, to: Int, num: Int){
        val list = mutableListOf(from..to).flatten()
        val quantity = if (num > list.size)
            list.size
        else
            num
        _outString.value = list.shuffled().subList(0, quantity).toString()
    }
}