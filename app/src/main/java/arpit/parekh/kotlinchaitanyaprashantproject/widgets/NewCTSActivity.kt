package arpit.parekh.kotlinchaitanyaprashantproject.widgets

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import arpit.parekh.kotlinchaitanyaprashantproject.databinding.ActivityNewCtsactivityBinding

class NewCTSActivity : AppCompatActivity(),CompoundButton.OnCheckedChangeListener {

    lateinit var binding : ActivityNewCtsactivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewCtsactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.cbGender.setOnCheckedChangeListener(this)
        binding.swithGender.setOnCheckedChangeListener(this)
        binding.tbGender.setOnCheckedChangeListener(this)

    }

    override fun onCheckedChanged(compoundButton: CompoundButton, b: Boolean) {

        if(b){
            binding.cbGender.text = "Male"
            binding.swithGender.text = "Male"

            binding.cbGender.isChecked = true
            binding.swithGender.isChecked = true
            binding.tbGender.isChecked = true

            binding.root.setBackgroundColor(Color.GREEN)
        }else{

            binding.cbGender.isChecked = false
            binding.swithGender.isChecked = false
            binding.tbGender.isChecked = false

            binding.cbGender.text = "Female"
            binding.swithGender.text = "Female"

            binding.root.setBackgroundColor(Color.WHITE)
        }

    }
}