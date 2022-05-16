package arpit.parekh.kotlinchaitanyaprashantproject.bottom_appbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import arpit.parekh.kotlinchaitanyaprashantproject.databinding.ActivityBottomBarBinding

class BottomBarActivity : AppCompatActivity() {
    lateinit var binding : ActivityBottomBarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomBarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fab.setOnClickListener {

        }

        binding.bottomAppBar.setOnMenuItemClickListener {

            true
        }

        binding.bottomAppBar.setNavigationOnClickListener {


        }

    }
}