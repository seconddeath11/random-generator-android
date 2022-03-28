package com.example.randomgenerator

import android.content.Context
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.randomgenerator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //private lateinit var drawerLayout: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        val navController = this.findNavController(R.id.navHostFragment)
        //drawerLayout = binding.drawerLayout

        NavigationUI.setupWithNavController(binding.navView, navController)
        //NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)

    }


}