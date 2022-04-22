package arpit.parekh.kotlinchaitanyaprashantproject.fragments_another

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import arpit.parekh.kotlinchaitanyaprashantproject.R

class MyHolderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_holder)

        title = "My Activity"

        val manager : FragmentManager = supportFragmentManager   // fragment manager
        val transaction : FragmentTransaction = manager.beginTransaction()
        transaction.add(R.id.fcv_holder,MumbaiFragment())
        transaction.commit()

    }
}