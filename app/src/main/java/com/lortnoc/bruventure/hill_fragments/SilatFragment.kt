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

class SilatFragment: Fragment(R.layout.fragment_silat) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val homeButton: Button = view.findViewById(R.id.homeButton)
        val imageSlider: ImageSlider = view.findViewById(R.id.sipatirSlider)
        val locationButton: Button = view.findViewById(R.id.LocationButton)

        homeButton.setOnClickListener {
            fragmentManager?.beginTransaction()?.replace(R.id.fragmentation_section, HomeFragment())?.commit()
        }

        locationButton.setOnClickListener {
            goToUrl("https://www.google.com/maps/place/Bukit+Silat,+Jln+Nenas+Madu+Katok+B/@4.8946249,114.8722246,17z/data=!4m2!3m1!1s0x322260762ecff0af:0x7666d5094c2b3e71")
        }

        val imageList = ArrayList<SlideModel>()

        imageList.add(SlideModel(R.drawable.silat_image_one, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.silat_image_two, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.silat_image_three, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.silat_image_four, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.silat_image_five, ScaleTypes.FIT))

        imageSlider.setImageList(imageList)
    }

    private fun goToUrl(URL: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(URL))
        startActivity(intent)
    }
}