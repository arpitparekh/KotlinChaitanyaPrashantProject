package arpit.parekh.kotlinchaitanyaprashantproject.pass_string_fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import arpit.parekh.kotlinchaitanyaprashantproject.R

class AnotherHolderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_another_holder)

        supportFragmentManager.beginTransaction()
            .add(R.id.fcv_another_holder,HelloFragment())
            .commit()

    }
}