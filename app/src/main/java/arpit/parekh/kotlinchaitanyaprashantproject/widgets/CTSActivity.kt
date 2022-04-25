package arpit.parekh.kotlinchaitanyaprashantproject.widgets

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.annotation.RequiresApi
import arpit.parekh.kotlinchaitanyaprashantproject.R
import arpit.parekh.kotlinchaitanyaprashantproject.databinding.ActivityCtsactivityBinding

class CTSActivity : AppCompatActivity() {

    lateinit var binding : ActivityCtsactivityBinding

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCtsactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.cbGender.setOnCheckedChangeListener { compoundButton, b ->

            if(b){

                binding.root.setBackgroundColor(Color.YELLOW)

            }else{

                binding.root.setBackgroundColor(Color.WHITE)

            }

        }

        binding.switchGender.setOnCheckedChangeListener { compoundButton, b ->

            if(b){

//                binding.root.setBackgroundColor(Color.YELLOW)

//                compoundButton.setBackgroundResource(R.drawable.ic_smile)

                compoundButton.setButtonDrawable(R.drawable.ic_smile)

            }else{

//               compoundButton.buttonDrawable?.setVisible(false,false)

                compoundButton.setButtonDrawable(android.R.drawable.screen_background_light_transparent)

            }


        }

        binding.tbGender.setOnCheckedChangeListener { compoundButton, b ->

            val button = Button(this)

            if(b){
                button.text = "Button"
                binding.root.addView(button)

            }else{



            }

        }

    }
}