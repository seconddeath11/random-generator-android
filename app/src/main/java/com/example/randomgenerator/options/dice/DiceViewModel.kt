package com.example.randomgenerator.options.dice

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class DiceViewModel: ViewModel() {
    private val _list = MutableLiveData<MutableList<Int>>()
    val list: MutableLiveData<MutableList<Int>>
        get() = _list

    init{
        list.value = mutableListOf()
    }

    fun onChoose(num: Int){
        list.value = mutableListOf()
        for (i in 0 until num){
            list.value?.add(Random.nextInt(1, 7))
        }
        notifyObservers()

    }
    private fun notifyObservers(){
        list.postValue(_list.value)
    }

}
