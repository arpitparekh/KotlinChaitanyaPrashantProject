package arpit.parekh.kotlinchaitanyaprashantproject.adapters.auto_complete_textview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import arpit.parekh.kotlinchaitanyaprashantproject.databinding.ActivityAutoBinding

class AutoActivity : AppCompatActivity() {

    lateinit var binding : ActivityAutoBinding
    lateinit var list : ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAutoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        list= ArrayList()

        list.add("Bike")
        list.add("Car")
        list.add("Plane")
        list.add("Bus")

        val adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list)

        binding.autoComplete.setAdapter(adapter)

    }
}