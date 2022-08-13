package com.lortnoc.bruventure.viewpager_fragments

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.lortnoc.bruventure.MainActivity
import com.lortnoc.bruventure.R

class HikeFunctionalityFragment: Fragment(R.layout.fragment_functionality_hike) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bukitOne: LinearLayout = view.findViewById(R.id.bukit1)
        val bukitTwo: LinearLayout = view.findViewById(R.id.bukit2)
        val bukitThree: LinearLayout = view.findViewById(R.id.bukit3)

        bukitOne.setOnClickListener {
            (activity as MainActivity).changeToSipatirFragment()
        }
        bukitTwo.setOnClickListener {
            (activity as MainActivity).changeToSilatFragment()
        }
        bukitThree.setOnClickListener {
            (activity as MainActivity).changeToSerangHelangFragment()
        }
    }
}