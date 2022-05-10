package arpit.parekh.kotlinchaitanyaprashantproject.adapters

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import arpit.parekh.kotlinchaitanyaprashantproject.databinding.ActivityVehicleListBinding

class VehicleListActivity : AppCompatActivity() {

    lateinit var binding : ActivityVehicleListBinding
    lateinit var list : ArrayList<Vehicle>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVehicleListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        list = ArrayList() // empty list
        val adapter = ArrayAdapter<Vehicle>(this,android.R.layout.simple_list_item_1,list)
        binding.listViewVehicle.adapter = adapter

//        list.add(Vehicle("Honda","2Wheel",50))
//        list.add(Vehicle("BMW","4Wheel",20))
//        list.add(Vehicle("Hundai","4Wheel",35))
//        list.add(Vehicle("Helicopter","NoWheel",10))

        binding.btnAdd.setOnClickListener {

            val name = binding.edtName.text.toString()
            val type = binding.edtType.text.toString()
            val average = binding.edtAverage.text.toString()

            val vehicle = Vehicle(name,type,average.toInt())

            list.add(vehicle)

            adapter.notifyDataSetChanged()  // refresh the adapter

            reset()
        }

    }
    fun reset(){

        binding.edtName.setText("")
        binding.edtAverage.setText("")
        binding.edtType.setText("")

    }
}