package com.lortnoc.bruventure

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        splashscreen_logo.alpha = 0f
        splashscreen_text.alpha = 0f

        // Method for SplashScreen (splashscreen_logo, splashscreen_text) and translate to MainActivity after 2.8s
        splashscreen_logo.animate().setDuration(2800).alpha(1f)
        splashscreen_text.animate().setDuration(2800).alpha(1f).withEndAction() {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }
    }
}

/* References:
*
*   Code adapted from Code Palace, 2020
*   iv_note.alpha = 0f
*   iv_note.animate().setDuration(1500).alpha(1f).withEndAction {
*       val i = Intent(this, MainActivity::class.java)
*       startActivity(i)
*       overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
* */