package com.example.randomgenerator.options.magicball

import androidx.lifecycle.ViewModel

class MagicBallViewModel : ViewModel() {
    fun onChoose(array: List<String>) : String{
        return array.shuffled()[0]
    }
}
