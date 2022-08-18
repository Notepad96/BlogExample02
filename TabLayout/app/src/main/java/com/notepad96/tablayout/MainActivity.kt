package com.notepad96.tablayout

import android.graphics.PorterDuff
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.notepad96.tablayout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    val tabTextList = listOf("Profile", "Search", "Setting")
    val tabIconList = listOf(R.drawable.icon_profile, R.drawable.icon_search, R.drawable.icon_setting)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.viewPager01.adapter = ViewPagerAdapter(this)

        TabLayoutMediator(binding.tabLayout01, binding.viewPager01) { tab, pos ->
            tab.text = tabTextList[pos]
            tab.setIcon(tabIconList[pos])
        }.attach()

        binding.tabLayout01.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                var iconColor = ContextCompat.getColor(baseContext, R.color.select)
                tab?.icon?.setColorFilter( iconColor, PorterDuff.Mode.SRC_IN)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                var iconColor = ContextCompat.getColor(baseContext, R.color.unselect)
                tab?.icon?.setColorFilter( iconColor, PorterDuff.Mode.SRC_IN)

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                var iconColor = ContextCompat.getColor(baseContext, R.color.select)
                tab?.icon?.setColorFilter( iconColor, PorterDuff.Mode.SRC_IN)
            }
        })

        binding.tabLayout01.selectTab(binding.tabLayout01.getTabAt(0))

    }

}