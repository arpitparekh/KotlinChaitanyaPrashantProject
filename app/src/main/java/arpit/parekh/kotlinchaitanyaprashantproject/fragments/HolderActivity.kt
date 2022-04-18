package arpit.parekh.kotlinchaitanyaprashantproject.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import arpit.parekh.kotlinchaitanyaprashantproject.R

class HolderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_holder)

        val manager = supportFragmentManager

        val transaction : FragmentTransaction = manager.beginTransaction()

        transaction.add(R.id.fcv,MyFragment())

        transaction.commit()

    }
}