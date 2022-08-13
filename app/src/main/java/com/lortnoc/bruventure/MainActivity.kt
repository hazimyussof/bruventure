package com.lortnoc.bruventure

import android.content.DialogInterface
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.lortnoc.bruventure.navigation_menu_fragments.AboutUsFragment
import com.lortnoc.bruventure.navigation_menu_fragments.HelpFeedbackFragment
import com.lortnoc.bruventure.hill_fragments.SarangHelangFragment
import com.lortnoc.bruventure.hill_fragments.SilatFragment
import com.lortnoc.bruventure.hill_fragments.SipatirFragment
import com.lortnoc.bruventure.navigation_menu_fragments.HomeFragment
import com.lortnoc.bruventure.navigation_menu_fragments.SettingsFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var buttonPressed = 0L // Variable to store the number of times a user clicks a button
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // When the application first launches, it will immediately show this fragment is the main screen
        supportFragmentManager.beginTransaction().replace(
            R.id.fragmentation_section,
            HomeFragment()
        ).commit()

        val toolbarTitle : TextView = findViewById(R.id.Title) //Initialize title from the Toolbar
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout) //Initialize the Material drawerLayout from XML File
        setSupportActionBar(findViewById(R.id.topAppBar)) //Initialize the Material Toolbar from XML File

        // Method to make Navigation button Toggle "Open" and "Close" the DrawerLayout in the Toolbar
        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        // Closes Navigation Drawer Gesture
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)

        // If user clicks on the toggle icon, the navigation drawer will open
        topAppBar.setNavigationOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        supportActionBar?.setDisplayShowTitleEnabled(false) // Disables the title shown in Toolbar
        supportActionBar?.setDisplayHomeAsUpEnabled(true) // Sets the Navigation button in Toolbar

        // Sets itemSelectListener for the Navigation Menu
        navigation.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.btn_home -> {
                    if (toolbarTitle.text == getString(R.string.app_name)) {
                        Toast.makeText(applicationContext, "Already in Home", Toast.LENGTH_SHORT).show()
                    } else {
                        drawerLayout.closeDrawer(GravityCompat.START)
                        toolbarTitle.text = getString(R.string.app_name)
                        supportFragmentManager.beginTransaction().replace(
                            R.id.fragmentation_section,
                            HomeFragment()
                        ).commit()
                    }
                }
                R.id.btn_aboutUs -> {
                    if (toolbarTitle.text == getString(R.string.about_us)) {
                        Toast.makeText(applicationContext, "Already in About Us", Toast.LENGTH_SHORT).show()
                    } else {
                        drawerLayout.closeDrawer(GravityCompat.START)
                        toolbarTitle.text = getString(R.string.about_us)
                        supportFragmentManager.beginTransaction().replace(
                            R.id.fragmentation_section,
                            AboutUsFragment()
                        ).commit()
                    }
                }
                R.id.btn_helpFeedback -> {
                    if (toolbarTitle.text == getString(R.string.help_feedback_short)) {
                        Toast.makeText(applicationContext, "Already in Help & Feedback", Toast.LENGTH_SHORT).show()
                    } else {
                        drawerLayout.closeDrawer(GravityCompat.START)
                        toolbarTitle.text = getString(R.string.help_feedback_short)
                        supportFragmentManager.beginTransaction().replace(
                            R.id.fragmentation_section,
                            HelpFeedbackFragment()
                        ).commit()
                    }
                }
                R.id.btn_settings -> {
                    if (toolbarTitle.text == getString(R.string.settings)) {
                        Toast.makeText(applicationContext, "Already in Settings", Toast.LENGTH_SHORT).show()
                    } else {
                        drawerLayout.closeDrawer(GravityCompat.START)
                        toolbarTitle.text = getString(R.string.settings)
                        supportFragmentManager.beginTransaction().replace(
                            R.id.fragmentation_section,
                            SettingsFragment()
                        ).commit()
                    }
                }
                R.id.btn_exitApplication -> {
                    if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                        drawerLayout.closeDrawer(GravityCompat.START)
                        showExitDialogPrompt()
                    }
                }
            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    // Method that sets the back button functionality
    override fun onBackPressed() {
        when {
            drawerLayout.isDrawerOpen(GravityCompat.START) -> {
                drawerLayout.closeDrawer(GravityCompat.START)
            }
            buttonPressed + 2000 > System.currentTimeMillis() -> {
                finish()
            }
            else -> {
                Toast.makeText(applicationContext, "Press again to exit", Toast.LENGTH_SHORT).show()
            }
        }
        buttonPressed = System.currentTimeMillis()
    }

    // Method that created a dialog box that prompts the user
    private fun showExitDialogPrompt() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Exit Application")
        builder.setMessage("Are you sure you want to close the application?")
        builder.setPositiveButton("Yes") { dialogInterface: DialogInterface, i: Int ->
            finish()
        }
        builder.setNegativeButton("No") { dialogInterface: DialogInterface, i: Int -> }
        builder.show()
    }

    fun changeToSipatirFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.fragmentation_section, SipatirFragment()).commit()
    }
    fun changeToSilatFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.fragmentation_section, SilatFragment()).commit()
    }
    fun changeToSerangHelangFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.fragmentation_section, SarangHelangFragment()).commit()
    }
}

/* References:
    Code adapted from Jibяaᴎ Khaᴎ & siliconeagle, (2015) from https://stackoverflow.com/a/5446680
    class MyActivity extends Activity {
      static boolean active = false;
      @Override
      public void onStart() {
         super.onStart();
         active = true;
      }
      @Override
      public void onStop() {
         super.onStop();
         active = false;
      }
}
*/

