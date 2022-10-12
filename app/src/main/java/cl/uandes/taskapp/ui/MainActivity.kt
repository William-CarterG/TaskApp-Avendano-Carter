package cl.uandes.taskapp.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import cl.uandes.taskapp.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import android.view.View
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import androidx.navigation.ui.setupActionBarWithNavController



class MainActivity : AppCompatActivity() {
  private lateinit var navController: NavController
  private lateinit var bottomNavigationView: BottomNavigationView

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
  }

  override fun onStart() {
    Toast.makeText(this, "onStart MainActivity", Toast.LENGTH_SHORT).show()
    super.onStart()


    navController= Navigation.findNavController(this,R.id.nav_host_fragment_container)

    val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

    val appBarConfiguration = AppBarConfiguration(setOf(
      R.id.homeProjectsFragment, R.id.homeTasksFragment, R.id.userProfileFragment))

    setupActionBarWithNavController(navController, appBarConfiguration)

    bottomNavigationView.setupWithNavController(navController)

    navController.addOnDestinationChangedListener { _, destination, _ ->
      bottomNavigationView.visibility = if(destination.id == R.id.loginFragment || destination.id == R.id.registerFragment) {
        View.GONE
      } else {
        View.VISIBLE
      }
    }

  }

}
