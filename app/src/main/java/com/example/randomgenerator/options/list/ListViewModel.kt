package com.example.randomgenerator.options.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ListViewModel : ViewModel(){
    private val _list = MutableLiveData<MutableList<String>>()
    val list: MutableLiveData<MutableList<String>>
        get() = _list

    fun onAdd(text: String){
        if (_list.value == null){
            _list.value = mutableListOf()
        }
        _list.value?.add(text)
        notifyObservers()
    }
    private fun notifyObservers(){
        list.postValue(_list.value)
    }

    fun onChoose(num: Int) : List<String>? {
        if (_list.value == null)
            return null
        val quantity = if (num > list.value!!.size) {
            list.value!!.size
        }
        else{
            num
        }
        return _list.value?.shuffled()?.subList(0, quantity)
    }

    fun onClear(){
        _list.value = null
        notifyObservers()
    }

}