package arpit.parekh.kotlinchaitanyaprashantproject.viewBinding_dataBinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import arpit.parekh.kotlinchaitanyaprashantproject.databinding.ActivityMyBinding

class MyActivity : AppCompatActivity() {

    // late initialize

    lateinit var binding : ActivityMyBinding  // declare

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyBinding.inflate(layoutInflater) // initialize
        setContentView(binding.root)

        binding.button3.setOnClickListener {
        }
        binding.imageView2.setOnClickListener {
        }
        binding.switch2.setOnClickListener {
        }
        binding.editTextTextPersonName2.text.toString()
        binding.textView.text = "Hello"

    }
}