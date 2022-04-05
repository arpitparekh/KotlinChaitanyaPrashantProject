package arpit.parekh.kotlinchaitanyaprashantproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) { // method overriding
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("lifecycle","create")

    }

    override fun onStart() {
        super.onStart()
        Log.i("lifecycle","start")
    }

    override fun onResume() {
        super.onResume()
        Log.i("lifecycle","resume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("lifecycle","pause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("lifecycle","stop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("lifecycle","restart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("lifecycle","destroy")
    }

}