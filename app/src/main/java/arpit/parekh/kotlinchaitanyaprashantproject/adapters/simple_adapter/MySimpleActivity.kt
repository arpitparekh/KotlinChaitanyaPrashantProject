package arpit.parekh.kotlinchaitanyaprashantproject.adapters.simple_adapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SimpleAdapter
import arpit.parekh.kotlinchaitanyaprashantproject.R
import arpit.parekh.kotlinchaitanyaprashantproject.adapters.array_adapter.Vehicle
import arpit.parekh.kotlinchaitanyaprashantproject.databinding.ActivityMySimpleBinding

class MySimpleActivity : AppCompatActivity() {
    lateinit var binding : ActivityMySimpleBinding

//    lateinit var list : ArrayList<HashMap<String,String>>
    lateinit var list : ArrayList<HashMap<String,Vehicle>>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMySimpleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        list = ArrayList()

//        val map = HashMap<String,String>()
//        map["name"] = "chaitanya"
//        map["address"] = "MP"
//
//        list.add(map)
//
//        val map1 = HashMap<String,String>()
//        map1["name"] = "arpit"
//        map1["address"] = "Surat"
//
//        list.add(map1)

        val map = HashMap<String,Vehicle>()
        map["name"] = Vehicle("Bmw","4Wheel",20)
        map["address"] = Vehicle("Bmw","4Wheel",20)

        list.add(map)

        val map1 = HashMap<String,Vehicle>()
        map1["name"] = Vehicle("Bmw","4Wheel",20)
        map1["address"] = Vehicle("Bmw","4Wheel",20)

        list.add(map1)

        val keyArray = arrayOf("name","address")
        val idArray = intArrayOf(R.id.tvName,R.id.tvAddress)

        val simpleAdapter = SimpleAdapter(this,list,R.layout.simple_row_item,keyArray,idArray)

        binding.listViewSimple.adapter = simpleAdapter

        binding.spinner.adapter = simpleAdapter

    }
}