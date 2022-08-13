package com.lortnoc.bruventure.adapters

import android.content.Context
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.lortnoc.bruventure.viewpager_fragments.HikeFragment
import com.lortnoc.bruventure.viewpager_fragments.HikeFunctionalityFragment
import com.lortnoc.bruventure.R
import com.lortnoc.bruventure.viewpager_fragments.StepFragment

class Adapter(private val context: Context, fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {
    override fun getCount() = 3

    override fun getItem(position: Int) = when (position) {
        0 -> HikeFragment()
        1 -> HikeFunctionalityFragment()
        2 -> StepFragment()
        else -> throw IllegalStateException("Unexpected position $position")
    }

    override fun getPageTitle(position: Int): CharSequence = when(position) {
        0 -> context.getString(R.string.main)
        1 -> context.getString(R.string.hikeSection)
        2 -> context.getString(R.string.StepSection)
        else -> throw IllegalStateException("Unexpected position $position")
    }
}

/* Code adapted from Zhuinden, 2019 https://gist.github.com/Zhuinden/c643f03a023a9cbe83fff6c75c948d3b
class MyFragmentPagerAdapter(
    private val context: Context,
    fragmentManager: FragmentManager
) : FragmentPagerAdapter(fragmentManager) {
    override fun getCount() = 2

    override fun getItem(position: Int) = when(position) {
        0 -> FirstFragment()
        1 -> SecondFragment()
        else -> throw IllegalStateException("Unexpected position $position")
    }

    override fun getPageTitle(position: Int): CharSequence = when(position) {
        0 -> context.getString(R.string.first)
        1 -> context.getString(R.string.second)
        else -> throw IllegalStateException("Unexpected position $position")
    }
}
*/