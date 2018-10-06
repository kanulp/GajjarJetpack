package com.kanu_lp.gajjarjetpacknavigation

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import kotlinx.android.synthetic.main.activity_main.*
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.NavigationUI.onNavDestinationSelected

class MainActivity : AppCompatActivity() {

    private lateinit var  navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navController = Navigation.findNavController(this,R.id.my_nav_host_fragment)
        setupNavigation()
        navigation.setOnNavigationItemSelectedListener { item -> onNavDestinationSelected(item,Navigation.findNavController(this,R.id.my_nav_host_fragment)) }
    }

    private fun setupNavigation() {
        NavigationUI.setupWithNavController(navigation,navController)
        NavigationUI.setupActionBarWithNavController(this,navController)

    }

    /*override fun onSupportNavigateUp() : Boolean {
        Log.d("maina","back button ?")
        return findNavController(this@MainActivity, R.id.my_nav_host_fragment).navigateUp()
    }
*/
    override fun onSupportNavigateUp() : Boolean {
        if (navController.currentDestination?.id == R.id.my_nav_host_fragment) {
            navController.popBackStack(R.id.my_nav_host_fragment, true)
        }
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
         return when (item?.itemId) {
            R.id.menu_settings -> {
                Toast.makeText(this@MainActivity,"Menu Clicked",Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


}
