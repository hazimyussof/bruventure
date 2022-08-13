
package com.lortnoc.bruventure.hill_fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.lortnoc.bruventure.navigation_menu_fragments.HomeFragment
import com.lortnoc.bruventure.R

class SipatirFragment: Fragment(R.layout.fragment_sipatir) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val homeButton: Button = view.findViewById(R.id.homeButton)
        val imageSlider: ImageSlider = view.findViewById(R.id.sipatirSlider)
        val locationButton: Button = view.findViewById(R.id.LocationButton)

        homeButton.setOnClickListener {
            fragmentManager?.beginTransaction()?.replace(R.id.fragmentation_section, HomeFragment())?.commit()
        }

        locationButton.setOnClickListener {
            goToUrl("https://www.google.com/maps/place/Entrance+to+Bukit+Sipatir,+Simpang+322,+Subok/@4.8996289,114.9743073,17z/data=!4m2!3m1!1s0x3222f56619f9bd4d:0xa24caa553d8c88f5")
        }

        val imageList = ArrayList<SlideModel>()

        imageList.add(SlideModel(R.drawable.sipatir_image_one, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.sipatir_image_two, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.sipatir_image_three, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.sipatir_image_four, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.sipatir_image_five, ScaleTypes.FIT))

        imageSlider.setImageList(imageList)
    }

    private fun goToUrl(URL: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(URL))
        startActivity(intent)
    }
}