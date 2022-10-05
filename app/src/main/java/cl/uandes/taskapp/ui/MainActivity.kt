package cl.uandes.taskapp.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import cl.uandes.taskapp.R
import com.google.android.material.bottomnavigation.BottomNavigationView


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

    /*TODO: Implement BottomNavBar
    navController= Navigation.findNavController(this,R.id.nav_host_fragment_container)
    val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

    setupWithNavController(bottomNavigationView, navController)

    navController.addOnDestinationChangedListener { _, destination, _ ->
      bottomNavigationView.visibility = if(destination.id == R.id.loginFragment) {
        View.GONE
      } else {
        View.VISIBLE
      }
    }
    */

    //TODO: Connect to DB
    //...
  }

  override fun onDestroy() {
    super.onDestroy()
    Toast.makeText(this, "onDestroy Activity2", Toast.LENGTH_SHORT).show()

    //TODO: Disconnect from DB
    //...
  }
}
