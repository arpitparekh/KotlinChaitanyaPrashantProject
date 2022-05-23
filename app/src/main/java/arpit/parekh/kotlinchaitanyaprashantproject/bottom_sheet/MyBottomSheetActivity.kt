package arpit.parekh.kotlinchaitanyaprashantproject.bottom_sheet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import arpit.parekh.kotlinchaitanyaprashantproject.databinding.ActivityMyBottomSheetBinding

class MyBottomSheetActivity : AppCompatActivity() {
    lateinit var binding : ActivityMyBottomSheetBinding
    lateinit var list : ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyBottomSheetBinding.inflate(layoutInflater)
        setContentView(binding.root)

        list = ArrayList()

        list.add("Android")
        list.add("Flutter")
        list.add("React Native")
        list.add("Dart")
        list.add("JavaScript")
        list.add("Java")
        list.add("Kotlin")

        val adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list)

        binding.listViewDemo.adapter = adapter

        binding.listViewDemo.setOnItemClickListener { adapterView, view, pos, l ->

            val str = list[pos]

            val sheet = MySheet(str)

            sheet.show(supportFragmentManager,"mySheet")

        }


        binding.btnBottom.setOnClickListener {

            val sheet = MySheet("")

            sheet.show(supportFragmentManager,"sheet1")

        }

    }
}