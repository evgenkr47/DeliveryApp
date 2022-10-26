package com.example.finalpizzadeliveryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.finalpizzadeliveryapp.databinding.ActivityMainBinding
import com.example.finalpizzadeliveryapp.presentation.delivery.DeliveryFragment
import com.example.finalpizzadeliveryapp.presentation.profile.ProfileFragment
import com.example.finalpizzadeliveryapp.presentation.shoppingcart.ShoppingCartFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var currentFragment: Fragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bottom_nav_menu.setupWithNavController(
            navController = nav_host_fragment.findNavController()
        )


    }


}