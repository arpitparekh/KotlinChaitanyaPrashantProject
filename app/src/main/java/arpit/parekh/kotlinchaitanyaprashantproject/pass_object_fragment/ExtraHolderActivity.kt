package arpit.parekh.kotlinchaitanyaprashantproject.pass_object_fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import arpit.parekh.kotlinchaitanyaprashantproject.R

class ExtraHolderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_extra_holder)

        supportFragmentManager.beginTransaction()
            .add(R.id.fcv_extra_holder,PehlaFragment())
            .commit()

    }
}