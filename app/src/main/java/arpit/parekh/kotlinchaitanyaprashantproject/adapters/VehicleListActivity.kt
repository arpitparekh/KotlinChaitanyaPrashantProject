package arpit.parekh.kotlinchaitanyaprashantproject.adapters

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import arpit.parekh.kotlinchaitanyaprashantproject.R
import arpit.parekh.kotlinchaitanyaprashantproject.databinding.ActivityVehicleListBinding
import arpit.parekh.kotlinchaitanyaprashantproject.databinding.UpdateVehicleDialogBinding

class VehicleListActivity : AppCompatActivity() {

    lateinit var binding : ActivityVehicleListBinding
    lateinit var dialogBinding : UpdateVehicleDialogBinding
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


        binding.listViewVehicle.setOnItemClickListener { adapterView, view, pos, l ->

            dialogBinding = UpdateVehicleDialogBinding.inflate(layoutInflater)

            val vehicle = list[pos]

            dialogBinding.edtUpdateName.setText(vehicle.name)
            dialogBinding.edtUpdateType.setText(vehicle.type)
            dialogBinding.edtUpdateAverage.setText(vehicle.average.toString())


            AlertDialog.Builder(this)
                .setTitle(R.string.title)
                .setPositiveButton("Update", DialogInterface.OnClickListener { dialogInterface, i ->

                    // update

                    AlertDialog.Builder(this)
                        .setTitle("Update")
                        .setView(dialogBinding.root)
                        .setPositiveButton("Update", DialogInterface.OnClickListener { dialogInterface1, i1 ->

                            val name = dialogBinding.edtUpdateName.text.toString()
                            val type = dialogBinding.edtUpdateType.text.toString()
                            val average = dialogBinding.edtUpdateAverage.text.toString()

                            val updatedVehicle = Vehicle(name,type,average.toInt())

                            list[pos] = updatedVehicle

                            adapter.notifyDataSetChanged()

                        }).create().show()


                })
                .setNegativeButton("Delete", DialogInterface.OnClickListener { dialogInterface, i ->

                    // delete

                    list.remove(vehicle)

                    adapter.notifyDataSetChanged()

                }).create().show()

        }

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
    private fun reset(){

        binding.edtName.setText("")
        binding.edtAverage.setText("")
        binding.edtType.setText("")

    }
}