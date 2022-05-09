package arpit.parekh.kotlinchaitanyaprashantproject.assignment_questions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import arpit.parekh.kotlinchaitanyaprashantproject.databinding.ActivityReverseNumberBinding

class ReverseNumberActivity : AppCompatActivity() {
    lateinit var binding : ActivityReverseNumberBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReverseNumberBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.edtReverse.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(cs: CharSequence?, p1: Int, p2: Int, p3: Int) {



                if(binding.edtReverse.text.toString().isNotEmpty()){

                    var number : Int = binding.edtReverse.text.toString().toInt()
                    var reverse = 0

                    while(number>0){

                        val last_digit = number%10
                        reverse = reverse*10 + last_digit
                        number = number/10
                    }

                    binding.tvReverse.setText(reverse.toString())
                }



            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })

    }
}