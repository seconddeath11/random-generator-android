package com.example.randomgenerator.options.coin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.randomgenerator.R
import kotlin.random.Random

class CoinViewModel : ViewModel(){
    private val _coinImage = MutableLiveData<Int>()
    val coinImage: LiveData<Int>
        get() = _coinImage
    fun onFlip(){

        val drawableRes = when (Random.nextInt(0, 2)) {
            1 -> R.drawable.coin_orel
            0 -> R.drawable.coin_reshka
            else -> R.drawable.coin_orel
        }

        _coinImage.value = drawableRes
    }
}