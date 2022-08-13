package com.lortnoc.bruventure.navigation_menu_fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.lortnoc.bruventure.R
import kotlinx.android.synthetic.main.fragment_us_about.*

class AboutUsFragment: Fragment(R.layout.fragment_us_about) {

    // Using onViewCreated instead of onCreate because unlike activities, fragment views are not created yet.
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Share Button to share application (Implement downloadable APK to to download link after application is fully developed)
        share_button.setOnClickListener {
            val intent= Intent()
            intent.action=Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT,"Hey, check out Bruventure:")
            intent.type="text/plain"
            startActivity(Intent.createChooser(intent,"Share To:"))
        }
    }
}

/* Code adapted from CyberShark, 2017 from https://stackoverflow.com/a/60724584
* val share_text_1_btn = findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(R.id.share_text_1_btn)
share_text_1_btn.setOnClickListener {
            val intent= Intent()
            intent.action=Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT,"Hey Check out this Great app:")
            intent.type="text/plain"
            startActivity(Intent.createChooser(intent,"Share To:"))
}
*
* */
