package arpit.parekh.kotlinchaitanyaprashantproject.viewpager_tablayout

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import arpit.parekh.kotlinchaitanyaprashantproject.viewpager_tablayout.fragments.CallFragment
import arpit.parekh.kotlinchaitanyaprashantproject.viewpager_tablayout.fragments.ChatFragment
import arpit.parekh.kotlinchaitanyaprashantproject.viewpager_tablayout.fragments.StatusFragment

class MyPagerAdapter(fragmentManager: FragmentManager,lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager,lifecycle) {

    override fun getItemCount() = 3

    override fun createFragment(position: Int): Fragment {

        when(position){

            0-> return ChatFragment()
            1-> return CallFragment()
            2-> return StatusFragment()
        }
        return ChatFragment()
    }
}