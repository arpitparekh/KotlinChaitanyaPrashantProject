package arpit.parekh.kotlinchaitanyaprashantproject.viewpager_tablayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import arpit.parekh.kotlinchaitanyaprashantproject.R
import arpit.parekh.kotlinchaitanyaprashantproject.databinding.ActivityMyPagerBinding
import com.google.android.material.tabs.TabLayout

class MyPagerActivity : AppCompatActivity() {
    lateinit var binding : ActivityMyPagerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyPagerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tabView.addTab(binding.tabView.newTab().setText("Chat"))
        binding.tabView.addTab(binding.tabView.newTab().setText("Call"))
        binding.tabView.addTab(binding.tabView.newTab().setText("Status"))

        val callTab : TabLayout.Tab? = binding.tabView.getTabAt(1)
        callTab?.setIcon(R.drawable.ic_call)

        val adapter = MyPagerAdapter(supportFragmentManager,lifecycle)

        binding.viewPager.adapter = adapter

        binding.tabView.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {

                binding.viewPager.currentItem = binding.tabView.selectedTabPosition

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){

            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                binding.tabView.selectTab(binding.tabView.getTabAt(position))

            }

        })
    }
}