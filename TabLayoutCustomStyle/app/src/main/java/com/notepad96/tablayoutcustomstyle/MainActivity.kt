package com.notepad96.tablayoutcustomstyle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.notepad96.tablayoutcustomstyle.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val tabTextList = listOf("Profile", "Search", "Setting")
    private val tabIconList =
        listOf(R.drawable.icon_profile, R.drawable.icon_search, R.drawable.icon_setting)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.viewPager01.adapter = ViewPagerAdapter(this)

        TabLayoutMediator(binding.tabLayout01, binding.viewPager01) { tab, pos ->
            tab.text = tabTextList[pos]
        }.attach()

        TabLayoutMediator(binding.tabLayout02, binding.viewPager01) { tab, pos ->
            tab.text = tabTextList[pos]
        }.attach()

        TabLayoutMediator(binding.tabLayout03, binding.viewPager01) { tab, pos ->
            tab.text = tabTextList[pos]
        }.attach()

        // 처음, 마지막 페이지간 양방향 이동 가능
        binding.viewPager01.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            var currentState = 0
            var currentPos = 0

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                if (currentState == ViewPager2.SCROLL_STATE_DRAGGING && currentPos == position) {
                    if (currentPos == 0) binding.viewPager01.currentItem = 2
                    else if (currentPos == 2) binding.viewPager01.currentItem = 0
                }
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
            }

            override fun onPageSelected(position: Int) {
                currentPos = position
                super.onPageSelected(position)
            }

            override fun onPageScrollStateChanged(state: Int) {
                currentState = state
                super.onPageScrollStateChanged(state)
            }
        })

        // TabLayout Tab 사이 간격 설정
        setTabItemMargin(binding.tabLayout01, 3)
        setTabItemMargin(binding.tabLayout02, 30)
        setTabItemMargin(binding.tabLayout03, 30)

    }

    // TabLayout Tab 사이 간격 부여
    private fun setTabItemMargin(tabLayout: TabLayout, marginEnd: Int = 20) {
        for(i in 0 until 3) {
            val tabs = tabLayout.getChildAt(0) as ViewGroup
            for(i in 0 until tabs.childCount) {
                val tab = tabs.getChildAt(i)
                val lp = tab.layoutParams as LinearLayout.LayoutParams
                lp.marginEnd = marginEnd
                tab.layoutParams = lp
                tabLayout.requestLayout()
            }
        }
    }
}