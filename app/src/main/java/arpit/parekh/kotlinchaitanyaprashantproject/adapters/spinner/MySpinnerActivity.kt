package arpit.parekh.kotlinchaitanyaprashantproject.adapters.spinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import arpit.parekh.kotlinchaitanyaprashantproject.databinding.ActivityMySpinnerBinding
import com.google.android.material.snackbar.Snackbar

class MySpinnerActivity : AppCompatActivity() {
    lateinit var binding : ActivityMySpinnerBinding
    lateinit var list : ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMySpinnerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        list = ArrayList()

        list.add("cycling")
        list.add("guilar")
        list.add("coding")
        list.add("harmonica")

        val adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list)

        binding.spinner.adapter = adapter

        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, pos: Int, p3: Long) {

                Toast.makeText(applicationContext,list[pos],Toast.LENGTH_SHORT).show()

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

    }
}