package com.example.randomgenerator.options.magicball

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MagicBallViewModel : ViewModel() {
    private val _outString = MutableLiveData<String>()
    val outString: MutableLiveData<String>
        get() = _outString

    fun onChoose(array: List<String>){
        _outString.value = array.shuffled()[0]
    }
}
