package com.example.crud_app_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.ui.setupWithNavController

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        val app_toolbar = findViewById<Toolbar>(R.id.app_toolbar)
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        app_toolbar.setupWithNavController(navController, appBarConfiguration)
    }
}

