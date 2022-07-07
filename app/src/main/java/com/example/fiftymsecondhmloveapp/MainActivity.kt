package com.example.fiftymsecondhmloveapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.fiftymsecondhmloveapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    /*@Inject
    lateinit var prefs : Prefs*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController = findNavController(R.id.nav_host_fragment)

        /*if (!Prefs(this).isShown()) {
            navController.navigate(R.id.boardFragment)
        }*/

        /*if (!prefs.isShown()){
            navController.navigate(R.id.boardFragment)
        }*/

    }
}