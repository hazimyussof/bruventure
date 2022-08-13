package com.lortnoc.bruventure.navigation_menu_fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.lortnoc.bruventure.adapters.Adapter
import com.lortnoc.bruventure.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment: Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewPager.adapter = Adapter(requireContext(), childFragmentManager)
    }
}

/* Code adapted from Zhuinden, 2019 https://gist.github.com/Zhuinden/c643f03a023a9cbe83fff6c75c948d3b
import kotlin.synthetic...

class ParentFragment: Fragment() {
    override fun onCreateView(...) = ...

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewPager.adapter = MyFragmentPagerAdapter(requireContext(), childFragmentManager)
        tabLayout.setupWithViewPager(viewPager)
    }
}
*/
