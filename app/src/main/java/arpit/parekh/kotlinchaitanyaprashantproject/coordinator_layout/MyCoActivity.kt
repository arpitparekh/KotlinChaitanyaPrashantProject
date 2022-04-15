package arpit.parekh.kotlinchaitanyaprashantproject.coordinator_layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import arpit.parekh.kotlinchaitanyaprashantproject.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class MyCoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_co)

        val floating = findViewById<FloatingActionButton>(R.id.fab)

        floating.setOnClickListener {

            Snackbar.make(it,"This is SnackBar",Snackbar.LENGTH_SHORT).show()

        }

    }
}