package com.example.randomgenerator.options.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ListViewModel : ViewModel(){
    private val _inList = MutableLiveData<MutableList<String>>()
    val inList: MutableLiveData<MutableList<String>>
        get() = _inList

    private val _outString = MutableLiveData<String>()
    val outString: MutableLiveData<String>
        get() = _outString

    fun onAdd(text: String){
        if (_inList.value == null){
            _inList.value = mutableListOf()
        }
        _inList.value?.add(text)
        notifyObservers()
    }
    private fun notifyObservers(){
        inList.postValue(_inList.value)
    }

    fun onChoose(num: Int) {
        if (_inList.value == null)
            return
        val quantity = if (num > inList.value!!.size) {
            inList.value!!.size
        }
        else{
            num
        }
        _outString.value =  _inList.value?.shuffled()?.subList(0, quantity).toString()
    }

    fun onClear(){
        _inList.value = null
        _outString.value = null
        notifyObservers()
    }

}