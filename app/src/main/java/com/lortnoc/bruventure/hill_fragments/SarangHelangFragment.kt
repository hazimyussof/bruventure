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

class SarangHelangFragment: Fragment(R.layout.fragment_helang_sarang) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val homeButton: Button = view.findViewById(R.id.homeButton)
        val imageSlider: ImageSlider = view.findViewById(R.id.sipatirSlider)
        val locationButton: Button = view.findViewById(R.id.LocationButton)

        homeButton.setOnClickListener {
            fragmentManager?.beginTransaction()?.replace(R.id.fragmentation_section, HomeFragment())?.commit()
        }

        locationButton.setOnClickListener {
            goToUrl("https://www.google.com/maps/place/Bukit+Sarang+Helang,+Bandar+Seri+Begawan/@4.9068737,114.9548398,17z/data=!4m2!3m1!1s0x3222f4d92977e095:0x127eb3597dc33308")
        }

        val imageList = ArrayList<SlideModel>()

        imageList.add(SlideModel(R.drawable.sarang_image_one, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.sarang_image_two, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.sarang_image_three, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.sarang_image_four, ScaleTypes.FIT))

        imageSlider.setImageList(imageList)
    }

    private fun goToUrl(URL: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(URL))
        startActivity(intent)
    }
}