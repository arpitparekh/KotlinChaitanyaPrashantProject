package arpit.parekh.kotlinchaitanyaprashantproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import arpit.parekh.kotlinchaitanyaprashantproject.databinding.ActivitySplashScreenBinding
import arpit.parekh.kotlinchaitanyaprashantproject.date_differentce.DateDifferenceActivity

class SplashScreenActivity : AppCompatActivity() {
    lateinit var binding : ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // We can use Thread

        Thread{

            Thread.sleep(3000)

            val i = Intent(this,DateDifferenceActivity::class.java)
            startActivity(i)

        }.start()

    }
}