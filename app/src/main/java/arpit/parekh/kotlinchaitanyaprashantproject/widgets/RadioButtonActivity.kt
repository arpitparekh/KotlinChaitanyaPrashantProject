package arpit.parekh.kotlinchaitanyaprashantproject.widgets

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.get
import arpit.parekh.kotlinchaitanyaprashantproject.R
import arpit.parekh.kotlinchaitanyaprashantproject.databinding.ActivityRadioButtonBinding

class RadioButtonActivity : AppCompatActivity() {

    lateinit var binding : ActivityRadioButtonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRadioButtonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rgColor.setOnCheckedChangeListener { radioGroup, i ->

            if(radioGroup.checkedRadioButtonId== R.id.rbRed){

                binding.root.setBackgroundColor(Color.RED)

            }else if(radioGroup.checkedRadioButtonId== R.id.rbGreen){

                binding.root.setBackgroundColor(Color.GREEN)

            }else if(radioGroup.checkedRadioButtonId== R.id.rbCustom){

                binding.root.setBackgroundColor(Color.rgb(103,138,227))

            }
        }
    }
}