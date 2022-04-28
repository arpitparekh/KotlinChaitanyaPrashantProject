package arpit.parekh.kotlinchaitanyaprashantproject.widgets

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import arpit.parekh.kotlinchaitanyaprashantproject.databinding.ActivityMySeekBinding

class MySeekActivity : AppCompatActivity(),SeekBar.OnSeekBarChangeListener {

    lateinit var binding : ActivityMySeekBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMySeekBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivColorCode.setBackgroundColor(Color.BLACK)

        binding.sbRed.setOnSeekBarChangeListener(this)
        binding.sbGreen.setOnSeekBarChangeListener(this)
        binding.sbBlue.setOnSeekBarChangeListener(this)

    }

    override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {

        val red  : Int= binding.sbRed.progress
        val green : Int= binding.sbGreen.progress
        val blue : Int= binding.sbBlue.progress

        binding.ivColorCode.setBackgroundColor(Color.rgb(red,green,blue))

    }

    override fun onStartTrackingTouch(p0: SeekBar?) {


    }

    override fun onStopTrackingTouch(p0: SeekBar?) {


    }
}